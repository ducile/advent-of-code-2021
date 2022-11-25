import utils.Solver
import utils.readInputLines
import kotlin.math.abs

class Day5 : Solver(5) {
    override fun solvePart1(input: String): Any {
        val lines = readInputLines(input)
        val board = Array(1000) { IntArray(1000) { 0 } }

        for (coords in lines) {
            val split = coords.split("->")
            val p1 = split[0].split(",")
            val p2 = split[1].split(",")

            val x1 = p1[0].trim().toInt()
            val x2 = p2[0].trim().toInt()
            val y1 = p1[1].trim().toInt()
            val y2 = p2[1].trim().toInt()

            if (x1 == x2) {
                var start = 0
                var end = 0

                if (y1 > y2) {
                    start = y2
                    end = y1
                } else {
                    start = y1
                    end = y2
                }

                for (i in start..end) {
                    board[x1][i] += 1
                }
            }

            if (y1 == y2) {
                var start = 0
                var end = 0
                if (x1 > x2) {
                    start = x2
                    end = x1
                } else {
                    start = x1
                    end = x2
                }

                for (i in start..end) {
                    board[i][y1] += 1
                }
            }
        }

        var c = 0

        board.forEach {
            it.forEach {
                if (it > 1) {
                    c++
                }
            }
        }

        return c
    }

    override fun solvePart2(input: String): Any {
        val lines = readInputLines(input)
        val board = Array(1000) { IntArray(1000) { 0 } }

        for (coords in lines) {
            val split = coords.split("->")
            val p1 = split[0].split(",")
            val p2 = split[1].split(",")

            val x1 = p1[0].trim().toInt()
            val x2 = p2[0].trim().toInt()
            val y1 = p1[1].trim().toInt()
            val y2 = p2[1].trim().toInt()

            if (x1 == x2) {
                var start = 0
                var end = 0

                if (y1 > y2) {
                    start = y2
                    end = y1
                } else {
                    start = y1
                    end = y2
                }

                for (i in start..end) {
                    board[x1][i] += 1
                }
            } else if (y1 == y2) {
                var start = 0
                var end = 0
                if (x1 > x2) {
                    start = x2
                    end = x1
                } else {
                    start = x1
                    end = x2
                }

                for (i in start..end) {
                    board[i][y1] += 1
                }
            } else {
                if (x1 <= x2) {
                    for (i in x1..x2) {
                        val step = i - x1

                        if (y1 < y2) {
                            board[i][y1 + step] += 1
                        } else {
                            board[i][y1 - step] += 1
                        }
                    }
                } else {
                    for (i in x1 downTo x2) {
                        val step = x1 - i

                        if (y1 < y2) {
                            board[i][y1 + step] += 1
                        } else {
                            board[i][y1 - step] += 1
                        }
                    }
                }
            }
        }

        var c = 0

        board.forEach {
            it.forEach {
                if (it > 1) {
                    c++
                }
            }
        }

        return c
    }

}

fun main() {
    val testString = """
        0,9 -> 5,9
        8,0 -> 0,8     
        9,4 -> 3,4
        2,2 -> 2,1
        7,0 -> 7,4
        6,4 -> 2,0
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8
        5,5 -> 8,2
    """.trim()

    Day5().verifyAndSolve(testString, 5, "#1")
    Day5().verifyAndSolve(testString, 12, "#2")
}