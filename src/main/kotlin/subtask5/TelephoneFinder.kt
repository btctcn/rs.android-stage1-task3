package subtask5

import java.util.HashMap
import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var regex = Regex("[^0-9]")
        if (regex.find(number) != null) return null

        var map = hashMapOf(
            1 to listOf("2", "4"),
            2 to listOf("1", "3", "5"),
            3 to listOf("2", "6"),
            4 to listOf("1", "5", "7"),
            5 to listOf("2", "4", "6", "8"),
            6 to listOf("3", "5", "9"),
            7 to listOf("4", "8"),
            8 to listOf("5", "7", "9", "0"),
            9 to listOf("6", "8"),
            0 to listOf("8")
        )
        var result = ArrayList<String>()
        number.forEach {
            for (i in 0..map[it.toString().toInt()]!!.size-1) {
                result.add(number)
            }
        }
        changeSymbolforLinesAndDictionaryStartingFrom(0, result, map, 0)
        return result.toTypedArray()
    }

    private fun changeSymbolforLinesAndDictionaryStartingFrom(
        position: Int,
        lines: java.util.ArrayList<String>,
        map: HashMap<Int, List<String>>,
        startFrom: Int
    ) {
        var startFromBlock = startFrom
        if (position == lines[0].length) return

        var idx = -1
        for(line in lines){
            if(++idx < startFrom) continue
            var currentNumbers = map[line[position].toString().toInt()]
            lines[idx] = line.replace(line[position].toString(), currentNumbers!![idx-startFrom])

            if(idx-startFrom + 1 == currentNumbers.count()){
                startFromBlock += currentNumbers.count()
                changeSymbolforLinesAndDictionaryStartingFrom(position+1, lines, map, startFromBlock)
                break
            }
        }
    }
}
