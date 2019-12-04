package day4

import java.util.*


class Day4 {
    fun isValidPassword(password: Int): Boolean {
        var numberOfAdjacents = 0

        return getDigits(password)
            .zipWithNext()
            .all { pair ->
                val isAdjacent = areTwoAdjacentNumbers(pair)
                val isSmallerThanNext = areTwoNumbersInOrder(pair)

                if (isAdjacent) {
                    numberOfAdjacents += 1
                }

                isAdjacent || isSmallerThanNext
            } && numberOfAdjacents >= 1
    }

    fun isValidPasswordExtended(password: Int): Boolean {
        var numberOfAdjacents = 0
        val previousGroups = mutableListOf<Pair<Int, Int>>()

        val meetsGeneralCriteria = getDigits(password)
            .zipWithNext()
            .all { pair ->
                val isAdjacent = areTwoAdjacentNumbers(pair)
                val isSmallerThanNext = areTwoNumbersInOrder(pair)

                if (isAdjacent && !previousGroups.contains(pair)) {
                    numberOfAdjacents += 1
                    previousGroups.add(pair)
                }

                isAdjacent || isSmallerThanNext
            }

        return meetsGeneralCriteria && numberOfAdjacents >= 1
    }

    private fun areTwoAdjacentNumbers(numbers: Pair<Int, Int>) = numbers.first == numbers.second

    private fun areTwoNumbersInOrder(numbers: Pair<Int, Int>) = numbers.first < numbers.second

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

    /*
    123444

    12
    23
    34
    44
    44
     */
}