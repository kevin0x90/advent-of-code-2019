package day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun `sample program 1,0,0,0,99 becomes 2,0,0,0,99`() {
        val sampleProgram = "1,0,0,0,99"

        val result = Day2().parse(sampleProgram)

        assertThat(result).isEqualTo("2,0,0,0,99")
    }

    @Test
    fun `sample program 2,3,0,3,99 becomes 2,3,0,6,99`() {
        val sampleProgram = "2,3,0,3,99"

        val result = Day2().parse(sampleProgram)

        assertThat(result).isEqualTo("2,3,0,6,99")
    }

    @Test
    fun `sample program 2,4,4,5,99,0 becomes 2,4,4,5,99,9801`() {
        val sampleProgram = "2,4,4,5,99,0"

        val result = Day2().parse(sampleProgram)

        assertThat(result).isEqualTo("2,4,4,5,99,9801")
    }

    @Test
    fun `sample program 1,1,1,4,99,5,6,0,99 becomes 30,1,1,4,2,5,6,0,99`() {
        val sampleProgram = "1,1,1,4,99,5,6,0,99"

        val result = Day2().parse(sampleProgram)

        assertThat(result).isEqualTo("30,1,1,4,2,5,6,0,99")
    }

    @Test
    fun `sample program 99 becomes 99`() {
        val sampleProgram = "99"

        val result = Day2().parse(sampleProgram)

        assertThat(result).isEqualTo("99")
    }
}