package me.honkling.uwulogs.lib

import kotlin.math.ceil

// Thanks https://github.com/UwUAroze/UwUCore/blob/master/src/main/java/me/aroze/uwucore/util/UwUUtils.kt
fun uwuify(text: String) : String {
    var toReturn = text

    toReturn = toReturn.replaceCaseInsensitive("\\. ", "~ ");
    toReturn = toReturn.replaceCaseInsensitive(", ", "~ ");
    toReturn = toReturn.replaceCaseInsensitive("- ", "~ ");
    toReturn = toReturn.replaceCaseInsensitive("\\? ", "~ ");
    toReturn = toReturn.replaceCaseInsensitive("hurt", "hUWUrt");
    toReturn = toReturn.replaceCaseInsensitive("kill", "hwuwrt");
    toReturn = toReturn.replaceCaseInsensitive("you", "you<3");
    toReturn = toReturn.replaceCaseInsensitive("r", "w");
    toReturn = toReturn.replaceCaseInsensitive("l", "w");
    toReturn = toReturn.replaceCaseInsensitive("uwu", "UWU");
    toReturn = toReturn.replaceCaseInsensitive("owo", "OWO");
    toReturn = toReturn.replaceCaseInsensitive(";-;", "(-_-)");
    toReturn = toReturn.replaceCaseInsensitive("-_-", "(-_-)");
    toReturn = toReturn.replaceCaseInsensitive(":o", "※(^o^)/※");
    toReturn = toReturn.replaceCaseInsensitive(":0", "※(^o^)/※");
    toReturn = toReturn.replaceCaseInsensitive(":\\)", "(｡◕‿‿◕｡)");
    toReturn = toReturn.replaceCaseInsensitive(":>", "(｡◕‿‿◕｡)");
    toReturn = toReturn.replaceCaseInsensitive(":\\(", "(︶︹︶)");
    toReturn = toReturn.replaceCaseInsensitive(":<", "(︶︹︶)");
    toReturn = toReturn.replaceCaseInsensitive(":3", "(・3・)");
    toReturn = toReturn.replaceCaseInsensitive(":D", "(ﾉ◕ヮ◕)ﾉ*:・ﾟ✧");
    toReturn = toReturn.replaceCaseInsensitive("\\._\\.", "(っ´ω`c)");
    toReturn = toReturn.replaceCaseInsensitive("fuck", "fwick");
    toReturn = toReturn.replaceCaseInsensitive("shit", "*poops*");
    toReturn = toReturn.replaceCaseInsensitive("wtf", "whawt the fwick");
    toReturn = toReturn.replaceCaseInsensitive("wth", "whawt the hecc");

    toReturn += when ((ceil(Math.random() * 20)).toInt()) {
        1 -> "~ uwu *nuzzles you*"
        2 -> "~ owo whats this"
        3 -> "~ *kisses you*"
        4 -> "~ *blushes*"
        5 -> "~ *hehe*"
        6 -> "~ meow"
        7 -> "~ owo"
        8 -> "~ uwu"
        9 -> " ;3"
        else -> "~"
    }

    return toReturn
}