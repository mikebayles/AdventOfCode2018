import com.mikebayles.aoc.Day2
import org.junit.Assert.assertEquals
import org.junit.Test

class Day2Test {
    @Test
    fun part1Test() {
        assertEquals(12, Day2().part1(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")))
    }

    @Test
    fun part2Test() {
        assertEquals("fgij", Day2().part2(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")))
    }
}