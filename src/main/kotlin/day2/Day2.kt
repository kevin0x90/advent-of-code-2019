package day2

import java.io.File
import kotlin.system.exitProcess

class Day2 {
    fun parse(sampleProgram: String, prepareInput: (programArray: MutableList<Int>) -> Unit = {}): String {
        val programArray = sampleProgram
            .split(",")
            .map { it -> Integer.parseInt(it) }
            .toMutableList()

        prepareInput(programArray)

        val programSize = programArray.size
        var currentPosition = 0

        while (currentPosition < programSize) {
            currentPosition = when (programArray[currentPosition]) {
                1 -> add(currentPosition, programArray)
                2 -> multiply(currentPosition, programArray)
                99 -> halt(programSize)
                else -> currentPosition + 1
            }
        }

        return programArray.joinToString(",")
    }

    private fun add(currentPosition: Int, programArray: MutableList<Int>) =
        binaryOperation(Int::plus)(currentPosition, programArray)

    private fun multiply(currentPosition: Int, programArray: MutableList<Int>) =
        binaryOperation(Int::times)(currentPosition, programArray)

    private fun halt(programSize: Int) = programSize

    private fun binaryOperation(operation: (Int, Int) -> Int): (Int, MutableList<Int>) -> Int {
        return { currentPosition, programArray ->
            val inputA = programArray[programArray[currentPosition + 1]]
            val inputB = programArray[programArray[currentPosition + 2]]
            val resultPosition = programArray[currentPosition + 3]

            programArray[resultPosition] = operation(inputA, inputB)

            currentPosition + 4
        }
    }
}

fun main() {
    val solver = Day2()
    val inputFile = File(solver.javaClass.getResource("input1.txt").toURI())
    val lines = inputFile.readLines()

    lines.forEach { line ->
        val result = solver.parse(line) { programArray ->
            programArray[1] = 12
            programArray[2] = 2
        }

        println(result)
    }

    val askedOutput = 19690720
    for (noun in 0..99) {
        for (verb in 0..99) {
            lines.forEach { line ->
                val result = solver.parse(line) { programArray ->
                    programArray[1] = noun
                    programArray[2] = verb
                }
                    .split(",")
                    .map { it -> Integer.parseInt(it) }
                    .first()

                if (result == askedOutput) {
                    println("Noun: $noun and Verb: $verb result in $askedOutput")
                    println("Result number: ${100 * noun + verb}")
                    exitProcess(0)
                }
            }
        }
    }
}