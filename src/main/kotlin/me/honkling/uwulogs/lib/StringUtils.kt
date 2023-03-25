package me.honkling.uwulogs.lib

// Thanks https://github.com/UwUAroze/UwUCore/blob/master/src/main/java/me/aroze/uwucore/util/ChatUtils.kt
fun String.replaceCaseInsensitive(text: String, replacement: String): String {
    return this.replace(Regex("(?i)$text"), replacement)
}