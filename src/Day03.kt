fun Char.asInt(): Int {
    return "$this".toInt()
}

fun main() {

    fun part1(input: List<String>) =
        input.sumOf { line ->
            line.indices
                .flatMap { i -> (i + 1 until line.length).map { j -> "${line[i]}${line[j]}".toInt() } }
                .maxOrNull() ?: 0
        }


    fun findMax(
        line: String
    ): Long {
        val stack = ArrayDeque<Int>()
        var numbersToRemove = line.length - 12
        for (i in line.indices) {
            val currentValue = line[i].asInt()
            while (!stack.isEmpty() && stack.last() < currentValue && numbersToRemove > 0) {
                stack.removeLast()
                numbersToRemove--
            }
            stack.add(currentValue)
        }

        while (numbersToRemove > 0) {
            stack.removeLast()
            numbersToRemove--
        }
        return stack.map { it.toString() }.reduce { acc, string -> acc + string }.toLong()
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { findMax(it) }
    }

    val testInput = readInput("test_input")
    check(part1(testInput) == 357)
    check(part2(testInput) == 3121910778619L)

    val testInput2 = readInput("input")
    part1(testInput2).println()
    part2(testInput2).println()
}
