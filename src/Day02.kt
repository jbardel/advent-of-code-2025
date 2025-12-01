fun main() {

    fun valid(v: String): Long {
        if (v.length % 2 == 0) {
            val first = v.substring(0 until v.length / 2)
            val second = v.substring(v.length / 2)

            if (first == second) {
                return v.toLong()
            }
        }
        return 0
    }

    fun isRepeated(v: String): Boolean {
        var t = v
        (0 until v.length - 1).forEach { i ->
            val firstChar = t[0]
            t = t.substring(1) + firstChar
            if (t == v) {
                return true
            }
        }

        return false
    }

    fun part1(input: List<String>): Long {
        var count = 0L
        for (range in input) {
            val firstId = range.substring(0 until range.indexOf("-")).toLong()
            val secondId = range.substringAfter("-").toLong()

            for (v in firstId..secondId) {
                count += valid(v.toString())
            }
        }
        return count
    }

    fun part2(input: List<String>): Long {
        var count = 0L
        for (range in input) {
            val firstId = range.substring(0 until range.indexOf("-")).toLong()
            val secondId = range.substringAfter("-").toLong()

            for (v in firstId..secondId) {
                count += if (isRepeated(v.toString())) v else 0
            }
        }
        return count
    }

    val testInput = readCommaSeparatedInput("test_input")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    val testInput2 = readCommaSeparatedInput("input")
    part1(testInput2).println()
    part2(testInput2).println()
}
