fun main() {

    fun initRanges(input: List<String>): List<LongRange> {
        return input
            .takeWhile { it.isNotEmpty() }
            .map {
                val (a, b) = it.split("-")
                LongRange(a.toLong(), b.toLong())
            }
            .toList()
    }

    fun part1(input: List<String>): Long {
        val ranges = initRanges(input)

        return input
            .dropWhile { it.isNotEmpty() }
            .drop(1)
            .map { it.toLong() }
            .map { value -> if (ranges.any { value in it }) 1L else 0L }
            .sumOf { it }
    }

    fun part2(input: List<String>): Int {
        val ranges = initRanges(input)
        val set = mutableSetOf<Long>()

        ranges
            .flatMap { it.asSequence() }
            .map { set.add(it) }
        return set.size
    }
    
    val testInput = readInput("test_input")
    check(part1(testInput) == 3L)
    check(part2(testInput) == 14)

    val testInput2 = readInput("input")
    part1(testInput2).println()
    part2(testInput2).println()
}
