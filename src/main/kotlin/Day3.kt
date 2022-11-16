import java.io.File

fun main () {
    val input = File("data/day3_input").readText().split("\n")

    println(getPart1(input))
    println(getPart2(input))
}

fun getPart1(input : List<String>) : Long {
    var sumZero = 0
    var sumOne = 0

    var gammaBinaryRate = ""
    var epsilonBinaryRate = ""

    var index = 0

    while(index < input[0].count()) {
        for (binary in input) {
            if (binary[index].toString() == "0") {
                sumZero ++
            } else {
                sumOne ++
            }
        }

        if (sumZero > sumOne) {
            gammaBinaryRate += 0
        } else {
            gammaBinaryRate += 1
        }

        if (sumZero < sumOne) {
            epsilonBinaryRate += 0
        } else {
            epsilonBinaryRate += 1
        }

        sumZero = 0
        sumOne = 0

        index ++
    }

    return gammaBinaryRate.toLong(2) * epsilonBinaryRate.toLong(2)
}

fun getPart2(input : List<String>) : String {
    return (getRating(input, true) * getRating(input, false)).toString()
}

fun getRating(input : List<String>, oxygen : Boolean): Long {
    var sumZero = 0
    var sumOne = 0

    var zeroList : MutableList<String> = arrayListOf()
    var oneList : MutableList<String> = arrayListOf()

    var currentList = input

    var rating = ""

    var index = 0
    val length = input[0].count()

    while (index <= length) {
        if (currentList.count() == 1) {
            rating = currentList[0]

            break
        }

        for (binary in currentList) {
            if (binary[index].toString() == "0") {
                sumZero ++
                zeroList.add(binary)
            } else {
                sumOne ++
                oneList.add(binary)
            }
        }

        if (oxygen) {
            if (sumZero <= sumOne) {
                currentList = oneList
            } else {
                currentList = zeroList
            }
        } else {
            if (sumZero <= sumOne) {
                currentList = zeroList
            } else {
                currentList = oneList
            }
        }

        zeroList = arrayListOf()
        oneList = arrayListOf()

        sumZero = 0
        sumOne = 0

        index ++
    }

    return rating.toLong(2)
}