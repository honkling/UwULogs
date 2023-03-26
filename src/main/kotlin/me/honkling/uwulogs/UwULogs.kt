package me.honkling.uwulogs

import me.honkling.uwulogs.lib.SLF4JUwULogger
import me.honkling.uwulogs.lib.UwULogger
import org.apache.logging.log4j.core.Logger
import org.apache.logging.slf4j.Log4jLogger
import org.bstats.bukkit.Metrics
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.lang.reflect.Field

class UwULogs : JavaPlugin() {
    private var locked = false

    override fun onLoad() {
        // Enable UwULogs as soon as possible.
        // We cannot use an init {} block because we depend on Bukkit having loaded all the other plugins as well.
        // If we use init {}, no plugins will be listed by the plugin manager, and we won't be able to replace plugin loggers.
        Bukkit.getPluginManager().enablePlugin(this)
    }

    override fun onEnable() {
        dataFolder.mkdir()
        saveDefaultConfig()

        if (locked) {
            locked = false
            return
        }

        setBukkitLogger()
        setMinecraftLogger()
        setPluginLoggers()

        if (config.getBoolean("bstats")) {
            Metrics(this, 18059)
            logger.info("Enabled metrics.")
        }

        logger.info("UwULogs is done.")
        locked = true
    }

    fun setPluginLoggers() {
        Bukkit.getPluginManager().plugins.forEach { plugin ->
            val pluginField = JavaPlugin::class.java.getDeclaredField("logger")

            pluginField.isAccessible = true
            pluginField.set(
                plugin, UwULogger(
                    plugin::class.java.canonicalName,
                    null,
                    plugin
                )
            )
        }
    }

    fun setBukkitLogger() {
        val logger = UwULogger("Minecraft", null, null)
        val server = Bukkit.getServer()
        val field = server::class.java.getDeclaredField("logger")
        field.isAccessible = true
        field.set(server, logger)
    }

    fun setMinecraftLogger() {
        val server = Bukkit::class.java.classLoader.loadClass("net.minecraft.server.MinecraftServer")

        // Get logger
        val field = server.declaredFields[1]
        setExtendedLogger(field)
    }

    fun setExtendedLogger(field: Field) {
        field.isAccessible = true
        val logger = field.get(null) as Log4jLogger

        val loggerField = logger::class.java.getDeclaredField("logger")
        loggerField.isAccessible = true
        val extendedLogger = loggerField.get(logger) as Logger
        loggerField.set(logger, SLF4JUwULogger(extendedLogger))
    }
}