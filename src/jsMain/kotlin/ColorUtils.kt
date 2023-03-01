fun distanceTo(hex1: String, hex2: String): Int {
    val r1 = hex1.substring(1, 3).toInt(16)
    val g1 = hex1.substring(3, 5).toInt(16)
    val b1 = hex1.substring(5, 7).toInt(16)
    val r2 = hex2.substring(1, 3).toInt(16)
    val g2 = hex2.substring(3, 5).toInt(16)
    val b2 = hex2.substring(5, 7).toInt(16)
    return (r1 - r2) * (r1 - r2) + (g1 - g2) * (g1 - g2) + (b1 - b2) * (b1 - b2)
}

fun nearest(hex: String, language: Language = Language.ENGLISH): ColorName {
    val colorNames = if (language == Language.ENGLISH) colorNamesEN else colorNamesFA
    var minColor: ColorName = colorNames.first()
    var minDistance = distanceTo(minColor.hex, hex)

    for (color in colorNames) {
        val distance = distanceTo(color.hex, hex)
        if (distance < minDistance) {
            minDistance = distance
            minColor = color
        }
    }
    return minColor
}

fun furthest(hex: String): ColorName {
    var maxColor: ColorName = colorNamesEN.first()
    var maxDistance = distanceTo(maxColor.hex, hex)

    for (color in colorNamesEN) {
        val distance = distanceTo(color.hex, hex)
        if (distance > maxDistance) {
            maxDistance = distance
            maxColor = color
        }
    }
    return maxColor
}

data class ColorName(val name: String, val hex: String)

enum class Language {
    ENGLISH, FARSI
}