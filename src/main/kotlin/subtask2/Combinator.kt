package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var posters = array[0]
        var colorsCount = array[1]

        for (groupCount in 1..colorsCount - 1) {
            var combinations = getBinCoefByNandK(colorsCount, groupCount)
            if (combinations >= posters) {
                return groupCount
            }
        }
        return null
    }

    fun getBinCoefByNandK(N: Int, K: Int): Long {
        var r: Long = 1
        var d: Long = 1
        var mutableN = N
        if (K > N) return 0

        for (d in 1..K) {
            r *= mutableN--
            r /= d
        }
        return r
    }
}
