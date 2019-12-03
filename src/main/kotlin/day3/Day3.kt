package day3

import java.io.File
import kotlin.math.abs
import kotlin.math.min

class Day3 {
    fun minIntersectionDistance(wire1Path: String, wire2Path: String): Int {
        val wire1Coordinates = parsePath(wire1Path)
        val wire2Coordinates = parsePath(wire2Path)
        val referencePoint = Pair(0, 0)

        val intersectingCoordinates = wire1Coordinates.keys.intersect(wire2Coordinates.keys) - referencePoint

        var minDistance = Int.MAX_VALUE
        intersectingCoordinates.forEach { coordinate ->
            val manhattanDistance =
                abs(coordinate.first - referencePoint.first) + abs(coordinate.second - referencePoint.second)

            minDistance = min(minDistance, manhattanDistance)
        }

        return minDistance
    }

    fun minIntersectionSteps(wire1Path: String, wire2Path: String): Int {
        val wire1Coordinates = parsePath(wire1Path)
        val wire2Coordinates = parsePath(wire2Path)
        val referencePoint = Pair(0, 0)
        var minTotalSteps = Int.MAX_VALUE

        val intersectingCoordinates = wire1Coordinates.keys.intersect(wire2Coordinates.keys) - referencePoint

        intersectingCoordinates.forEach { intersection ->
            minTotalSteps =
                min(minTotalSteps, (wire1Coordinates[intersection] ?: 0) + (wire2Coordinates[intersection] ?: 0))
        }

        return minTotalSteps
    }

    private fun parsePath(path: String): Map<Pair<Int, Int>, Int> {
        var currentPosition = Pair(0, 0)
        val pathCoordinates = mutableMapOf<Pair<Int, Int>, Int>()

        var steps = 0
        path.split(",").forEach { direction ->
            val directionSpecifier = direction.substring(0, 1)
            val directionLength = Integer.parseInt(direction.substring(1))

            val xy = when (directionSpecifier) {
                "R" -> Pair(1, 0)
                "L" -> Pair(-1, 0)
                "U" -> Pair(0, 1)
                "D" -> Pair(0, -1)
                else -> throw Exception("Unknown direction specifier")
            }

            repeat(directionLength) {
                val newCoordinate = Pair(currentPosition.first + xy.first, currentPosition.second + xy.second)
                currentPosition = newCoordinate
                steps += 1
                pathCoordinates[newCoordinate] = steps
            }
        }

        return pathCoordinates
    }
}

fun main() {
    val solver = Day3()
    val inputFile = File(solver.javaClass.getResource("input1.txt").toURI())
    val pathLines = inputFile.readLines()

    val minDistance = solver.minIntersectionDistance(pathLines[0], pathLines[1])

    println("Min distance is $minDistance")

    val minTotalSteps = solver.minIntersectionSteps(pathLines[0], pathLines[1])

    println("Min total steps is $minTotalSteps")
}