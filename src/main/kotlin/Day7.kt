import utils.Solver
import kotlin.math.abs

class Day7 : Solver(7) {
    override fun solvePart1(input: String): Any {
        val crabPositions = input.split(",").map { it.toInt() }

        var fuel = 0

        val highestOccurrences = crabPositions.groupingBy { it }.eachCount().toList().sortedBy { (key, value) -> value }.reversed()
        val highestOccurrence = highestOccurrences[0].first

        for (pos in crabPositions) {
            fuel += abs(pos - highestOccurrence)
        }

        for (spot in highestOccurrences) {
            val currentSpot = spot.first
            var currentFuel = 0

            for (pos in crabPositions) {
                currentFuel += abs(pos - currentSpot)
            }

            if (currentFuel < fuel) {
                fuel = currentFuel
            }
        }

        return fuel
    }

    override fun solvePart2(input: String): Any {
        val crabPositions = input.split(",").map { it.toInt() }

        var fuel = 0

        val highestNumber = crabPositions.max()

        val highestOccurrence = crabPositions.groupingBy { it }.eachCount().toList().sortedBy { (key, value) -> value }.reversed()[0].first

        for (pos in crabPositions) {
            val delta = abs(pos - highestOccurrence)
            var tempFuel = 0

            for (i in 0..delta) {
                tempFuel += i
            }

            fuel += tempFuel
        }

        for (spot in 0..highestNumber) {
            var currentFuel = 0

            for (pos in crabPositions) {
                val delta = abs(pos - spot)
                var tempFuel = 0

                for (i in 0..delta) {
                    tempFuel += i
                }

                currentFuel += tempFuel
            }

            if (currentFuel < fuel) {
                fuel = currentFuel
            }
        }

        return fuel
    }

}

fun main() {
    val testData = "16,1,2,0,4,2,7,1,2,14"

    Day7().verifyAndSolve(testData, 37, "#1")
    Day7().verifyAndSolve(testData, 168, "#2")
}