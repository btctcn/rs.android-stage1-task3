package subtask4

import kotlin.math.floor
import kotlin.math.sqrt

class SquareDecomposer {

    private fun ArrayList<Int>.squaredSum() : Long{
        var result : Long = 0
        forEach{
            result += it*it.toLong()
        }
        return result
    }

    private fun ArrayList<Int>.removeAfter(index : Int) : Unit{
        if(index >= count()) throw IllegalArgumentException()

        while (count() > index + 1){
            removeAt(index+1)
        }
    }

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        var num : Long = number.toLong()
        var squaredNum : Long = number*number.toLong()
        if(number < 5) return null

        var result = ArrayList<Int>()
        var dec = num - 1
        result.add((num-1).toInt())

        getCurrentSum(result, 1, squaredNum, squaredNum - dec*dec)
        result.sort()
        return result.toTypedArray()
    }

    private fun getCurrentSum(result: ArrayList<Int>, level: Int, num: Long, reminder: Long) {
        var numSqrt = floor(sqrt(reminder.toDouble())).toInt()
        if(numSqrt == 0) return
        if(result.contains(numSqrt)) return
        if(result.count() >= level+1){
            result[level] = numSqrt
        } else{
            result.add(numSqrt)
        }

        while (true){
            var reminderMutable = num - result.squaredSum()
            if(reminderMutable == 1L) return;
            getCurrentSum(result, level+1, num, reminderMutable)
            if(result.squaredSum() == num) return
            if(numSqrt == 1)return
            numSqrt--
            if(result.contains(numSqrt))return
            result[level] = numSqrt
            result.removeAfter(level)
        }
    }
}
