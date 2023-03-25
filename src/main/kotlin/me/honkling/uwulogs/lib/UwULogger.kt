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
        println(log.message)
    }
}