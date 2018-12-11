package com.mikebayles.aoc

import java.io.File

fun main(args: Array<String>) {
    println(Day2().part2(File("Day2.txt").readLines()))
}

class Day2 {
    private fun String.toCharCount() = this.associateBy({ it }, { this.count { c -> c == it } })
    private fun String.diff(other: String): List<Int> {
        val ret = mutableListOf<Int>()

        forEachIndexed { index, c ->
            if (other[index] != c) ret.add(index)
        }

        return ret
    }

    fun part1(input: List<String>): Int {
        var doubles = 0
        var triples = 0

        input.forEach { line ->
            line.toCharCount().apply {
                doubles += if (count { it.value == 2 } > 0) 1 else 0
                triples += if (count { it.value == 3 } > 0) 1 else 0
            }
        }

        return doubles * triples
    }

    fun part2(input: List<String>): String {
        input.forEach { outer ->
            input.forEach { inner ->
                outer.diff(inner).apply {
                    if (size == 1) {
                        return outer.removeRange(this[0], this[0] + 1)
                    }
                }
            }
        }

        return ""
    }
}