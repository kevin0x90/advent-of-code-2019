package day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `mass of 12 should result in 2 fuel`() {
        val inputMass = 12

        val result = Day1().fuel(inputMass)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `For a mass of 14 required fuel is 2`() {
        val inputMass = 14

        val result = Day1().fuel(inputMass)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `For a mass of 1969 required fuel is 654`() {
        val inputMass = 1969

        val result = Day1().fuel(inputMass)

        assertThat(result).isEqualTo(654)
    }

    @Test
    fun `For a mass of 100756 required fuel is 33583`() {
        val inputMass = 100756

        val result = Day1().fuel(inputMass)

        assertThat(result).isEqualTo(33583)
    }

    @Test
    fun `module of mass 14 requires total fuel of 2`() {
        val day1 = Day1()
        val inputMass = 14
        val fuel = day1.fuel(inputMass)

        val totalFuel = day1.totalFuel(fuel)

        assertThat(totalFuel).isEqualTo(fuel)
    }

    @Test
    fun `module of mass 1969 requires a total fuel of 966`() {
        val day1 = Day1()
        val inputMass = 1969
        val fuel = day1.fuel(inputMass)

        val totalFuel = day1.totalFuel(fuel)

        assertThat(totalFuel).isEqualTo(966)
    }

    @Test
    fun `module of mass 100756 requires a total fuel of 50346`() {
        val day1 = Day1()
        val inputMass = 100756
        val fuel = day1.fuel(inputMass)

        val totalFuel = day1.totalFuel(fuel)

        assertThat(totalFuel).isEqualTo(50346)
    }
}