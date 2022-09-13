package k014

fun main() {
    val solution = Solution()
    println(solution.longestCommonPrefix(arrayOf("f")))
}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        var shortestWordLength = Integer.MAX_VALUE
        strs.forEach { if (it.length < shortestWordLength) shortestWordLength = it.length }

        for (i in 0 until shortestWordLength) {
            val c = strs[0][i]
            for (j in 1 until strs.size) {
                if (i >= strs[j].length || strs[j][i] != c) {
                    return result
                }
            }
            result += c
        }
        return result
    }
}
