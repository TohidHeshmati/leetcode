package k242
fun main () {
    println("hello")
    val s1 = "anagram"
    val t1 = "nagaram"
    val s2 = "rat"
    val t2 = "car"
    println(isAnagram(s1, t1)) // true
    println(isAnagram(s2, t2)) // false
}


fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val sChars = s.toCharArray()
    val tChars = t.toCharArray()
    val frequency = IntArray(26)
    for (index in s.indices) {
        frequency[sChars[index] - 'a']++
        frequency[tChars[index] - 'a']--
    }

    return frequency.all { it == 0 }
}