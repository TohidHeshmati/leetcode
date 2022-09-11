package k013

fun main() {
    val romanInteger = RomanInteger()
    println("1:     " + romanInteger.romanToInt("I"))
    println("2:     " + romanInteger.romanToInt("II"))
    println("3:     " + romanInteger.romanToInt("III"))
    println("4:     " + romanInteger.romanToInt("IV"))
    println("9:     " + romanInteger.romanToInt("IX"))
    println("40:    " + romanInteger.romanToInt("XL"))
    println("90:    " + romanInteger.romanToInt("XC"))
    println("400:   " + romanInteger.romanToInt("CD"))
    println("900:   " + romanInteger.romanToInt("CM"))
    println("58:    " + romanInteger.romanToInt("LVIII"))
    println("1994:  " + romanInteger.romanToInt("MCMXCIV"))
    println("-1:    " + romanInteger.romanToInt("MadsfadsfCIV"))
}

class RomanInteger {
    fun romanToInt(s: String): Int {
        var result = 0
        for (c in s) {
            result = if (letters.keys.contains(c) && s.isNotBlank()) 0 else return -1
        }

        s.forEachIndexed { index, character ->
            val value = if ((s.length > index + 1)) {
                when (character) {
                    'I' -> if (s[index + 1] == 'V' || s[index + 1] == 'X') -1 else 1
                    'X' -> if (s[index + 1] == 'L' || s[index + 1] == 'C') -10 else 10
                    'C' -> if (s[index + 1] == 'D' || s[index + 1] == 'M') -100 else 100
                    else -> letters[character]
                }
            } else letters[character]
            result += value!!
        }
        return result
    }
    companion object {
        val letters = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
    }
}
