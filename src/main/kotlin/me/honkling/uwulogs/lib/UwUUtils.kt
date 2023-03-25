package me.honkling.uwulogs.lib

import kotlin.math.ceil

// Thanks https://github.com/UwUAroze/UwUCore/blob/master/src/main/java/me/aroze/uwucore/util/UwUUtils.kt
fun uwuify(text: String) : String {
    return text
        .replace("\\. ", "~ ", true)
        .replace(", ", "~ ", true)
        .replace("- ", "~ ", true)
        .replace("\\? ", "~ ", true)
        .replace("hurt", "hUWUrt", true)
        .replace("kill", "hwuwrt", true)
        .replace("you", "you<3", true)
        .replace("r", "w", true)
        .replace("l", "w", true)
        .replace("uwu", "UWU", true)
        .replace("owo", "OWO", true)
        .replace(";-;", "(-_-)", true)
        .replace("-_-", "(-_-)", true)
        .replace(":o", "※(^o^)/※", true)
        .replace(":0", "※(^o^)/※", true)
        .replace(":\\)", "(｡◕‿‿◕｡)", true)
        .replace(":>", "(｡◕‿‿◕｡)", true)
        .replace(":\\(", "(︶︹︶)", true)
        .replace(":<", "(︶︹︶)", true)
        .replace(":3", "(・3・)", true)
        .replace(":D", "(ﾉ◕ヮ◕)ﾉ*:・ﾟ✧", true)
        .replace("\\._\\.", "(っ´ω`c)", true)
        .replace("fuck", "fwick", true)
        .replace("shit", "*poops*", true)
        .replace("wtf", "whawt the fwick", true)
        .replace("wth", "whawt the hecc", true) +
            when ((ceil(Math.random() * 20)).toInt()) {
                1 -> "~ uwu *nuzzles you*"
                2 -> "~ owo whats this"
                3 -> "~ *kisses you*"
                4 -> "~ *blushes*"
                5 -> "~ *hehe*"
                6 -> "~ meow"
                7 -> "~ owo"
                8 -> "~ uwu"
                9 -> " ;3"
                10 -> "~ *boops your nose*"
                11 -> "~ *snuggles with you*"
                12 -> "~ *giggles*"
                13 -> "~ *hugs you*"
                else -> "~"
            }
}
