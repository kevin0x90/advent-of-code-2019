package day4

import java.util.*


class Day4 {
    fun isValidPassword(password: Int): Boolean {
        var numberOfAdjacents = 0

        return getDigits(password)
            .zipWithNext()
            .all { pair ->
                val isAdjacent = areTwoAdjacentNumbers(pair)

                if (isAdjacent) {
                    numberOfAdjacents += 1
                }

                isAdjacent || areTwoNumbersInOrder(pair)
            } && numberOfAdjacents >= 1
    }

    fun isValidPasswordExtended(password: Int): Boolean {
        val digits = getDigits(password)
        val groups = digits.groupingBy { it }.eachCount()

        val meetsGeneralCriteria = digits
            .zipWithNext()
            .all(this::areTwoNumbersInOrder)

        return meetsGeneralCriteria && groups.any { it.value == 2 }
    }

    private fun areTwoAdjacentNumbers(numbers: Pair<Int, Int>) = numbers.first == numbers.second

    private fun areTwoNumbersInOrder(numbers: Pair<Int, Int>) = numbers.first <= numbers.second

    private fun getDigits(number: Int): List<Int> {
        val result = Stack<Int>()
        var remaining = number

        while (remaining > 0) {
            result.push(remaining % 10)
            remaining /= 10
        }

        return result.asReversed()
    }

}

fun main() {
    val solver = Day4()

    val numberOfValidPasswords = (158126..624574).count(solver::isValidPassword)
    val numberOfValidPasswordsExtended = (158126..624574).count(solver::isValidPasswordExtended)

    println(numberOfValidPasswords)
    println(numberOfValidPasswordsExtended)
}