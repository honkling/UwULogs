package me.honkling.uwulogs.lib

import org.bukkit.plugin.Plugin
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger

class UwULogger(
    name: String,
    resourceBundleName: String?,
    plugin: Plugin?
) : Logger(name, resourceBundleName) {
    var prefix: String = ""

    init {
        if (plugin != null) {
            prefix = "[${plugin.description.prefix ?: plugin.description.name}] "
            parent = plugin.server.logger
            level = Level.ALL
        }
    }

    override fun log(log: LogRecord) {
        log.message = uwuify(prefix + log.message)

        log.parameters?.forEachIndexed { i, v ->
            log.message = log.message.replace("{$i}", v.toString())
        }

        log(Level.INFO, log.message)

        if (log.thrown != null) {
            log.thrown.printStackTrace(object : PrintStream(System.err) {
                override fun println(x: Any?) {
                    log(Level.SEVERE, uwuify(x.toString()))
                }
            })
        }
    }
}
