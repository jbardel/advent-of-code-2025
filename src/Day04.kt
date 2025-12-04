fun main() {

    fun countNeighbours(input: List<CharArray>, lIdx: Int, cIdx: Int): Int {
        var count = 0
        for (i in lIdx - 1..lIdx + 1) {
            for (j in cIdx - 1..cIdx + 1) {
                if (i in 0 until input.size && j in 0 until input[i].size) {
                    if (input[i][j] == '@') {
                        count++
                    }
                }
            }
        }
        return count
    }

    fun part1(input: List<CharArray>): Int {
        var accessible = 0
        for (lineIdx in input.indices) {
            for (cIdx in input[lineIdx].indices) {
                if (input[lineIdx][cIdx] == '@') {
                    val neighbours = countNeighbours(input, lineIdx, cIdx)
                    if (neighbours <= 4) {
                        accessible += 1
                    }
                }
            }
        }
        return accessible
    }

    fun part2(input: List<CharArray>): Int {
        var allRemoved = 0
        do {
            var removed = 0
            for (lineIdx in input.indices) {
                for (cIdx in input[lineIdx].indices) {
                    if (input[lineIdx][cIdx] == '@') {
                        val neighbours = countNeighbours(input, lineIdx, cIdx)
                        if (neighbours <= 4) {
                            input[lineIdx][cIdx] = '.'
                            removed++
                        }
                    }
                }
            }
            allRemoved += removed
        } while ((removed > 0))
        return allRemoved
    }

    val testInput = readInputToArray("test_input")
    check(part1(testInput) == 13)
    check(part2(testInput) == 43)

    val testInput2 = readInputToArray("input")
    part1(testInput2).println()
    part2(testInput2).println()
}
