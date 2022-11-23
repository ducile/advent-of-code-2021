import java.io.File

fun main() {
    val numbers = listOf(90,4,2,96,46,1,62,97,3,52,7,35,50,28,31,37,74,26,59,53,82,47,83,80,19,40,68,95,34,55,54,73,12,78,30,63,57,93,72,77,56,91,23,67,64,79,85,84,76,10,58,0,29,13,94,20,32,25,11,38,89,21,98,92,42,27,14,99,24,75,86,51,22,48,9,33,49,18,70,8,87,61,39,16,66,71,5,69,15,43,88,45,6,81,60,36,44,17,41,65)

    val input = File("data/day4_input").readText().lines()

    var players = emptyList<MutableList<String>>().toMutableList()

    for (line in input) {
        var l = line.split(" ").toMutableList()
        l.removeIf { it == "" }

        players.add(l)
    }

    println(checkBingos(players, numbers))
}

fun checkBingos(players : MutableList<MutableList<String>>, numbers : List<Int>): Int {
    var currentPlayer : MutableList<MutableList<String>> = emptyList<MutableList<String>>().toMutableList()

    // Iterate through numbers
    for (number in numbers) {

        // iterate through players
        for (line in players) {
            val currentLine = line

            if (line.isEmpty()) {
                if (isBingo(currentPlayer)) {
                    return calculateBingo(currentPlayer, number)
                }

                currentPlayer = emptyList<MutableList<String>>().toMutableList()
                continue
            }

            // Cross numbers
            for (c in line.indices) {
                if (line[c] == "x") {
                    continue
                }

                if (line[c].toInt() == number) {
                    currentLine[c] = "x"
                }
            }

            currentPlayer.add(currentLine)
        }
    }

    return 0
}

fun isBingo(playerResult : MutableList<MutableList<String>>) : Boolean {
    var rowCount = 0

    // check row bingo
    for (row in playerResult.indices) {
        rowCount = 0

        for (column in playerResult[row]) {
            if (column == "x") {
                rowCount ++
            }
        }

        if (rowCount == 5) {
            return true
        } else {
            rowCount = 0
        }
    }

    // check column bingo
    for (i in 0..4) {
        if (playerResult[0][i] == "x" &&
            playerResult[1][i] == "x" &&
            playerResult[2][i] == "x" &&
            playerResult[3][i] == "x" &&
            playerResult[4][i] == "x") {
            return true
        }
    }

    return false
}

fun calculateBingo(playerResult : MutableList<MutableList<String>>, calledNumber : Int) : Int {
    var sum = 0

    for (row in playerResult) {
        for (column in row) {
            if (column != "x") {
                sum += column.toInt()
            }
        }
    }

    return sum * calledNumber
}