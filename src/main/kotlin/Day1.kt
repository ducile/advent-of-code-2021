import java.io.File

fun main() {
    val input = File("data/day1_input").readText().split("\n").map{ it.toLong() }

    var count = 0
    var currentDepth = input[0]

    for (n in input) {
        if (n > currentDepth) {
            count ++
        }

        currentDepth = n
    }

    println(count)

    println(input.windowed(3) { it.sum() }.zipWithNext().count { (a,b) -> b > a })
}
