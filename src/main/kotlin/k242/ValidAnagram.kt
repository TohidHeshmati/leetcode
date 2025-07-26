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
// my solution
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val smap = mutableMapOf<Char, Int>()

    s.forEach { letter ->
        smap[letter] = smap.getOrDefault(letter, 0) + 1
    }

    t.forEach { letter ->
        val toBeReduced = smap.getOrDefault(letter, 0)
        if (toBeReduced == 0) return false
        smap[letter] = toBeReduced - 1
    }

    return true
}

// best solution
fun isAnagram2(s: String, t: String): Boolean {
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