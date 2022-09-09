package k005

fun main() {
    val example1 = "eeee"
    val example2 = ""
    val example3 = "baba"
    val example4 = "dfasgsfgdfhybetygrtygfsdfssf"
    val solution = Solution()
    System.out.printf("input: %s,   result: %s\n", example1, solution.longestPalindrome(example1))
    System.out.printf("input: %s,   result: %s\n", example2, solution.longestPalindrome(example2))
    System.out.printf("input: %s,   result: %s\n", example3, solution.longestPalindrome(example3))
    System.out.printf("input: %s,   result: %s\n", example4, solution.longestPalindrome(example4))
}
class Solution {
    fun longestPalindrome(s: String): String {
        var longestFound = 0
        var palindromeEnd = 0
        var palindromeBegin = 0

        for (end in 0..s.length) {
            for (start in 0 until end) {
                if (end - start > longestFound && s.substring(start, end).isPalindrome()) {
                    longestFound = end - start
                    palindromeEnd = end
                    palindromeBegin = start
                }
            }
        }
        return s.substring(palindromeBegin, palindromeEnd)
    }

    private fun String.isPalindrome(): Boolean {
        if (this.isBlank()) return true
        val length = this.length
        for (i in 0 until length / 2 + 1) {
            if (this[i] != this[this.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
