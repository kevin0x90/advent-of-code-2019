package day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun `111111 is a valid password`() {
        val password = 111111

        val isValid = Day4().isValidPassword(password)

        assertThat(isValid).isTrue()
    }

    @Test
    fun `223450 is an invalid password`() {
        val password = 223450

        val isValid = Day4().isValidPassword(password)

        assertThat(isValid).isFalse()
    }

    @Test
    fun `123789 is an invalid password`() {
        val password = 123789

        val isValid = Day4().isValidPassword(password)

        assertThat(isValid).isFalse()
    }

    @Test
    fun `112233 is a valid extended password`() {
        val password = 112233

        val isValid = Day4().isValidPasswordExtended(password)

        assertThat(isValid).isTrue()
    }

    @Test
    fun `123444 is an invalid extended password`() {
        val password = 123444

        val isValid = Day4().isValidPasswordExtended(password)

        assertThat(isValid).isFalse()
    }

    @Test
    fun `111122 is a valid extended password`() {
        val password = 111122

        val isValid = Day4().isValidPasswordExtended(password)

        assertThat(isValid).isTrue()
    }

    @Test
    fun `111111 is an invalid extended password`() {
        val password = 111111

        val isValid = Day4().isValidPasswordExtended(password)

        assertThat(isValid).isFalse()
    }
}