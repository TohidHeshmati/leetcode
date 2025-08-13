package k020

fun main() {
    val solution = Solution()
    println("s: ((())) and result: ${solution.isValid("((()))")}")
    println("s: () and result: ${solution.isValid("()")}")
    println("s: (] and result: ${solution.isValid("(]")}")
    println("s: ([]) and result: ${solution.isValid("([])")}")
    println("s: ([]){} and result: ${solution.isValid("([]){}}")}")
    println("s: ([]){}] and result: ${solution.isValid("([]){}}]")}")
}

class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false
        val pair = mapOf(')' to '(', ']' to '[', '}' to '{')
        val stack = ArrayDeque<Char>()

        for (c in s) {
            val opener = pair[c]
            if (opener == null) {
                stack.addLast(c)             // c is an opener
            } else if (stack.isEmpty() || stack.removeLast() != opener) {
                return false                 // mismatched closer
            }
        }
        return stack.isEmpty()
    }
}