package day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `R75,D30,R83,U83,L12,D49,R71,U7,L72 U62,R66,U55,R34,D71,R55,D58,R83 result in min intersection distance 159`() {
        val wire1Path = "R75,D30,R83,U83,L12,D49,R71,U7,L72"
        val wire2Path = "U62,R66,U55,R34,D71,R55,D58,R83"

        val result = Day3().minIntersectionDistance(wire1Path, wire2Path)

        assertThat(result).isEqualTo(159)
    }

    @Test
    fun `R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51 U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 result in min intersection distance 135`() {
        val wire1Path = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"
        val wire2Path = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"

        val result = Day3().minIntersectionDistance(wire1Path, wire2Path)

        assertThat(result).isEqualTo(135)
    }

    @Test
    fun `R75,D30,R83,U83,L12,D49,R71,U7,L72 U62,R66,U55,R34,D71,R55,D58,R83 result in min steps 610`() {
        val wire1Path = "R75,D30,R83,U83,L12,D49,R71,U7,L72"
        val wire2Path = "U62,R66,U55,R34,D71,R55,D58,R83"

        val result = Day3().minIntersectionSteps(wire1Path, wire2Path)

        assertThat(result).isEqualTo(610)
    }

    @Test
    fun `R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51 U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 result in min steps 410`() {
        val wire1Path = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"
        val wire2Path = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"

        val result = Day3().minIntersectionSteps(wire1Path, wire2Path)

        assertThat(result).isEqualTo(410)
    }

    @Test
    fun `R8,U5,L5,D3 U7,R6,D4,L4 result in min steps 30`() {
        val wire1Path = "R8,U5,L5,D3"
        val wire2Path = "U7,R6,D4,L4"

        val result = Day3().minIntersectionSteps(wire1Path, wire2Path)

        assertThat(result).isEqualTo(30)
    }
}