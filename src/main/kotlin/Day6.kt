import utils.Solver

class Day6 : Solver(6) {
    private var adjustFishes : MutableList<Long> = emptyList<Long>().toMutableList()

    override fun solvePart1(input: String): Any {
        val fishes = input.split(",")
        val days = 80

        adjustFishes = fishes.map { it.toLong() }.toMutableList()

        for (d in 0 until days) {
            for (i in adjustFishes.indices) {
                val daysToBreed = adjustFishes[i].toInt() - 1

                if (daysToBreed == -1) {
                    adjustFishes[i] = 6
                    adjustFishes.add(8)
                } else {
                    adjustFishes[i]--
                }
            }
        }

        return adjustFishes.count()
    }

    // 26984457539
    override fun solvePart2(input: String): Any {
        val fishes = input.split(",").map { it.toInt() }

        var count = LongArray(9)

        for (i in fishes) {
            count[i]++
        }

        repeat(256) {
            val g = LongArray(9)

            for (i in 0..8) {
                when {
                    i > 0 -> g[i - 1] += count[i]
                    i == 0 -> {
                        g[6] += count[i]
                        g[8] += count[i]
                    }
                }
            }
            count = g
        }

        return count.sum()
    }
}

fun main() {
    val testInput = "3,4,3,1,2"

    Day6().verifyAndSolve(testInput, 5934, "#1")
    Day6().verifyAndSolve(testInput, 26984457539, "#2")
}