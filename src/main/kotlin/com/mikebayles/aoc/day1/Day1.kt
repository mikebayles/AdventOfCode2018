package com.mikebayles.aoc.day1

import java.io.File

fun main(args : Array<String>) {
    println(Day1().part2(File("Day1.txt").readLines()))
}

class Day1 {
    fun part1(input: List<String>) : Int {
        var sum = 0

        input.forEach {
            sum += it.toInt()
        }

        return sum
    }

    fun part2(input: List<String>) : Int {
        var sum = 0
        val seen = mutableListOf(0)

        while (true) {
            input.forEach {
                sum += it.toInt()
                if (seen.contains(sum)) return sum

                seen.add(sum)
            }
        }
    }
}

