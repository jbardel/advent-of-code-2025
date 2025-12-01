fun main() {

    fun part1(input: List<String>): Int {

        var curr = 50
        var pass = 0

        for (l in input) {
            val direction = l.first()
            val ticks = l.substring(1).toInt()

            val step = if (direction == 'L') -1 else 1

            for (i in 1..ticks) {
                curr = (curr + step + 100) % 100
            }

            if (curr == 0) pass++
        }
        return pass
    }

    fun part2(input: List<String>): Int {
        var curr = 50
        var pass = 0

        for (l in input) {
            val direction = l.first()
            val ticks = l.substring(1).toInt()

            val step = if (direction == 'L') -1 else 1

            for (i in 1..ticks) {
                curr = (curr + step + 100) % 100
                if (curr == 0) pass++
            }

        }
        return pass
    }
    
    val testInput = readInput("test_input")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)
    
    val testInput2 = readInput("input")
    part1(testInput2).println()
    part2(testInput2).println()
}
