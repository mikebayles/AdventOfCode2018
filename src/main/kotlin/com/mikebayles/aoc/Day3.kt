package com.mikebayles.aoc

import java.io.File

fun main(args: Array<String>) {
    println(Day3().part2(File("Day3.txt").readLines()))
}

class Day3 {

    private val squares: MutableMap<Pair<Int, Int>, MutableList<Int>> by lazy {
        mutableMapOf<Pair<Int, Int>, MutableList<Int>>()

    }

    private val claims: MutableList<Claim> by lazy {
        mutableListOf<Claim>()
    }

    fun part1(input: List<String>): Int {

        input.forEach {
            processClaim(it)
        }

        return squares.count { it.value.size > 1 }
    }

    fun part2(input: List<String>): Int {

        input.forEach {
            processClaim(it)
        }

        val all = mutableMapOf<Pair<Int, Int>, Int>()
        val good = claims.map { it.id }.toMutableSet()

        claims.forEach { claim ->
            claim.occupiedSquares.forEach { square ->
                val match = all.getOrPut(square) { claim.id }
                if (claim.id != match) {
                    good.remove(match)
                    good.remove(claim.id)
                }
            }
        }

        return good.first()
    }


    private fun processClaim(line: String) {
        val claim = line.toClaim()
        claims.add(claim)
        claim.occupiedSquares.forEach { square ->
            if (!squares.containsKey(square)) {
                squares[square] = mutableListOf()
            }

            squares[square]!!.add(claim.id)
        }
    }


    private fun String.toClaim(): Claim {
        val (id, x, y, width, height) = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)".toRegex().find(this)!!.destructured
        return Claim(id.toInt(), x.toInt(), y.toInt(), width.toInt(), height.toInt())
    }
}

class Claim(
    val id: Int,
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int
) {

    val occupiedSquares: List<Pair<Int, Int>> by lazy {
        val squares = mutableListOf<Pair<Int, Int>>()

        for (iy in y..(y + height - 1)) {
            for (ix in x..(x + width - 1)) {
                squares.add(Pair(ix, iy))
            }

        }
        squares
    }
}