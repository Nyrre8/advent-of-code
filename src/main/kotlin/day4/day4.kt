package org.example.day4

import org.example.util.InputReader

fun main() {

    val lines = InputReader.readLines(4)

    println("Part 1: ${partOne(lines)}")

    println("Part 2: ${partTwo(lines)}")

}

data class RangePair(
    val aStartRange: Int,
    val aEndRange: Int,
    val bStartRange: Int,
    val bEndRange: Int
)

fun stringToIntParser(lines: String): RangePair {

    val firstRange = lines.substringBefore(",")
    val secondRange = lines.substringAfter(",")

    return RangePair(
        firstRange.substringBefore("-").toInt(),
        firstRange.substringAfter("-").toInt(),
        secondRange.substringBefore("-").toInt(),
        secondRange.substringAfter("-").toInt()
    )
}

fun partOne(lines: List<String>): Int {

    fun fullyContains(aStartRange: Int, aEndRange: Int, bStartRange: Int, bEndRange: Int) =
        aStartRange >= bStartRange && aEndRange <= bEndRange || bStartRange >= aStartRange && bEndRange <= aEndRange

    return lines.sumOf { input ->

        val rangePair = stringToIntParser(input)

        if (fullyContains(
                rangePair.aStartRange,
                rangePair.aEndRange,
                rangePair.bStartRange,
                rangePair.bEndRange
            )
        ) 1 else 0
    }
}

fun partTwo(lines: List<String>): Int {

    fun overlaps(aStartRange: Int, aEndRange: Int, bStartRange: Int, bEndRange: Int) =
        !(aEndRange < bStartRange || bEndRange < aStartRange)

    return lines.sumOf { input ->
        val rangePair = stringToIntParser(input)
        if (overlaps(
                rangePair.aStartRange,
                rangePair.aEndRange,
                rangePair.bStartRange,
                rangePair.bEndRange
            )
        ) 1 else 0

    }


}