package subtask3

import java.lang.Math.abs

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var numArray = ArrayList<Int>()
        var negativeArray = ArrayList<Int>()
        var positiveArray = ArrayList<Int>()

        itemsFromArray.forEach {
            if (it is Number) {
                var value = it.toInt()
                numArray.add(value)
                if (value > 0) {
                    positiveArray.add(value)
                } else if (value < 0) {
                    negativeArray.add((value))
                }
            }
        }

        if(numArray.count() == 0) return 0

        if(numberOfItems > numArray.count()){
            var result = 1;
            for(it in numArray){
                result *= it
            }
            return result
        }

        var canUseNegative = numberOfItems % 2 == 0 && negativeArray.count() >= 2
        var sortedArray : ArrayList<Int>
        if(!canUseNegative){
            sortedArray = positiveArray
            sortedArray.sort()
        } else{
            sortedArray = numArray
            sortedArray.sortWith(compareBy{ kotlin.math.abs(it) })
        }

        sortedArray.reverse()
        var numberOfItemsMutable = numberOfItems
        var result = 1
        var iterator = sortedArray.iterator()
        while (numberOfItemsMutable > 0){
            result *= iterator.next()
            numberOfItemsMutable--
        }

        return result
    }
}
