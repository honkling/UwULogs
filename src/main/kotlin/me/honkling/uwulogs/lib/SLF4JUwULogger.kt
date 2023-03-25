package me.honkling.uwulogs.lib

import org.apache.logging.log4j.Level
import org.apache.logging.log4j.Marker
import org.apache.logging.log4j.core.Logger
import org.apache.logging.log4j.core.config.LocationAwareReliabilityStrategy
import org.apache.logging.log4j.message.Message
import org.apache.logging.log4j.message.SimpleMessage
import org.apache.logging.log4j.util.Strings

class SLF4JUwULogger(parent: Logger) : Logger(parent.context, parent.name, parent.getMessageFactory()) {
    override fun logMessage(fqcn: String?, level: Level?, marker: Marker?, message: Message?, t: Throwable?) {
        val msg = message ?: SimpleMessage(Strings.EMPTY)
        val strategy = privateConfig.loggerConfig.reliabilityStrategy
        strategy.log(this, getName(), fqcn, marker, level, SimpleMessage(uwuify(msg.formattedMessage)), t)
    }

    override fun log(
        level: Level?, marker: Marker?, fqcn: String?, location: StackTraceElement?,
        message: Message?, throwable: Throwable?
    ) {
        val strategy = privateConfig.loggerConfig.reliabilityStrategy
        val msg = SimpleMessage(uwuify((message ?: SimpleMessage(Strings.EMPTY)).formattedMessage))
        if (strategy is LocationAwareReliabilityStrategy) {
            (strategy as LocationAwareReliabilityStrategy).log(
                this, getName(), fqcn, location, marker, level,
                msg, throwable
            )
        } else {
            strategy.log(this, getName(), fqcn, marker, level, msg, throwable)
        }
    }
}