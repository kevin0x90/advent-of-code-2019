package day1

import java.io.File


class Day1 {
    fun fuel(mass: Int) = mass / 3 - 2

    fun totalFuel(fuel: Int): Int {
        var total = 0
        var additionalFuel = fuel

        do {
            total += additionalFuel
            additionalFuel = fuel(additionalFuel)
        } while (additionalFuel > 0)

        return total
    }
}

fun main() {
    val solver = Day1()
    val inputFile = File(solver.javaClass.getResource("input1.txt").toURI())
    var fuelSum = 0
    var totalFuelSum = 0
    inputFile.forEachLine { line ->
        val parsedLine = Integer.parseInt(line)
        val fuel = solver.fuel(parsedLine)

        fuelSum += fuel
        totalFuelSum += solver.totalFuel(fuel)
    }

    println("Required fuel $fuelSum")

    println("Sum of fuel requirements $totalFuelSum")
}


