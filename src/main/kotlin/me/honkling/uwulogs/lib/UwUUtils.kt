package me.honkling.uwulogs.lib

// Thanks https://github.com/UwUAroze/UwUCore/blob/master/src/main/java/me/aroze/uwucore/util/UwUUtils.kt

private val uwuReplacements = mapOf(
    "\\. " to "~ ",
    ", " to "~ ",
    "- " to "~ ",
    "\\? " to "~ ",
    "hurt" to "hUWUrt",
    "kill" to "hwuwrt",
    "you" to "you<3",
    "r" to "w",
    "l" to "w",
    "uwu" to "UWU",
    "owo" to "OWO",
    ";-;" to "(-_-)",
    "-_-" to "(-_-)",
    ":o" to "※(^o^)/※",
    ":0" to "※(^o^)/※",
    ":\\)" to "(｡◕‿‿◕｡)",
    ":>" to "(｡◕‿‿◕｡)",
    ":\\(" to "(︶︹︶)",
    ":<" to "(︶︹︶)",
    ":3" to "(・3・)",
    ":D" to "(ﾉ◕ヮ◕)ﾉ*:・ﾟ✧",
    "\\._\\." to "(っ´ω`c)",
    "fuck" to "fwick",
    "shit" to "*poops*",
    "wtf" to "whawt the fwick",
    "wth" to "whawt the hecc"
)

fun uwuify(text: String): String {
    var uwuText = text

    uwuReplacements.forEach { (key, value) ->
        uwuText = uwuText.replace(key, value, true)
    }

    return uwuText + getRandomUwUSuffix()
}

private fun getRandomUwUSuffix(): String {
    val uwuSuffixes = listOf(
        "~ uwu *nuzzles you*",
        "~ owo whats this",
        "~ *kisses you*",
        "~ *blushes*",
        "~ *hehe*",
        "~ meow",
        "~ owo",
        "~ uwu",
        " ;3",
        "~ *boops your nose*",
        "~ *snuggles with you*",
        "~ *giggles*",
        "~ *hugs you*",
    )

    return listOf(*uwuSuffixes.toTypedArray(), *Array(7) { "~" }).random()
}
