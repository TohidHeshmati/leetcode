package companyEmailChallange

import java.lang.StringBuilder
import kotlin.collections.HashSet

fun main() {
    val companyName = "Example"
    val companyName2 = "longerThanEightCharacters"
    val names = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brain Parker"
    val names2 = "John Doe; John Doe; John Doe; John Doe; Tohid waitforit Hesh-matilogy"
    val solution = Solution()
    println(solution.solution(names, companyName))
    println(solution.solution(names2, companyName2))
}
class Solution {
    fun solution(s: String, c: String): String {
        if (s.isBlank()) return ""
        val names = s.split("; ")
        val companyName = c.limitToEightCharacter().lowercase()
        val result = StringBuilder()
        val usernameBank = HashSet<String>()
        var fullName: String

        names.forEach { name ->
            fullName = name
            var emailUserName = name.split(" ").first().lowercase() +
                name.split(" ").last().replace("-", "").limitToEightCharacter().lowercase()

            var counter = 1
            while (usernameBank.contains(emailUserName)) {
                emailUserName = emailUserName.removeSuffix(counter.toString())
                counter++
                emailUserName = emailUserName.plus(counter.toString())
            }
            usernameBank.add(emailUserName)
            result.append("$fullName <$emailUserName@$companyName.com>; ")
        }
        return result.removeSuffix(" ").toString()
    }

    private fun String.limitToEightCharacter() = if (this.length > 7) this.removeRange(8 until this.length) else this
}
