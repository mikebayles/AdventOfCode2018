import com.mikebayles.aoc.Day3
import org.junit.Assert.assertEquals
import org.junit.Test

class Day3Test {
    @Test
    fun part1Test() {
        assertEquals(4, Day3().part1(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
    }

    @Test
    fun part2Test() {
        assertEquals(3, Day3().part2(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
    }
}