package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if(numbers.count() == 0) return null

        val powerMax = numbers.count() - 1
        val result = StringBuilder()
        var j = 0
        for(currentPower in powerMax downTo 0){
            var currentNumber = numbers[j]
            j++
            if(currentNumber == 0) continue;
            var negative = currentNumber < 0

            if(result.length == 0) {
                if(negative)
                    result.append("-")
            } else {
                result.append(if(negative)  " - " else " + ")
            }

            result.append(convertNumToString(currentNumber) + convertPowerToString(currentPower))
        }

        return  result.toString()
    }

    fun convertNumToString(number: Int) : String{
        var result = kotlin.math.abs(number)

        if(result == 1) return ""
        return result.toString()
    }

    fun convertPowerToString(power: Int) : String{
        if(power > 1) return String.format("x^%d", power);
        if(power == 1) return "x";
        return "";
    }

    }
