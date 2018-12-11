import com.mikebayles.aoc.day1.Day1
import org.junit.Assert.assertEquals
import org.junit.Test

class Day1Test {

    @Test
    fun part1Test() {
        assertEquals(3, Day1().part1(listOf("+1", "+1", "+1")))
        assertEquals(0, Day1().part1(listOf("+1", "+1", "-2")))
        assertEquals(-6, Day1().part1(listOf("-1", "-2", "-3")))
    }

    @Test
    fun part2Test() {
        assertEquals(0, Day1().part2(listOf("+1", "-1")))
        assertEquals(10, Day1().part2(listOf("+3", "+3", "+4", "-2", "-4")))
        assertEquals(5, Day1().part2(listOf("-6", "+3", "+8", "+5", "-6")))
        assertEquals(14, Day1().part2(listOf("+7", "+7", "-2", "-7", "-4")))
    }
}