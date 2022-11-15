import java.io.File

fun main() {
    val input = File("data/day2_input").readText().split("\n")

    var hPos = 0
    var dPos = 0

    for (c in input) {
        val command = c.split(" ")
        val key = command[0]
        val range = command[1].toInt()

        when(key) {
            "forward" -> hPos += range
            "down" -> dPos += range
            "up" -> dPos -= range
        }
    }

    println(hPos * dPos)

    // part 2
    var horizontalPos = 0
    var depthPos = 0
    var aim = 0

    for (c in input) {
        val command = c.split(" ")
        val key = command[0]
        val range = command[1].toInt()

        when(key) {
            "forward" -> {
                horizontalPos += range
                depthPos += aim * range
            }
            "down" -> aim += range
            "up" -> aim -= range
        }
    }

    println(depthPos * horizontalPos)
}