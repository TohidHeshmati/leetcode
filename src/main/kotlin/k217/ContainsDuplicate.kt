package k217

fun main() {
    println("hello")
    val numsFalse1 = intArrayOf(1, 2, 3, 4)
    val numsTrue1 = intArrayOf(1, 2, 3, 1)
    val numsTrue2 = intArrayOf(1, 1, 1, 2, 3, 3, 3, 4, 2)
    println(containsDuplicate(numsFalse1))
    println(containsDuplicate(numsTrue1))
    println(containsDuplicate(numsTrue2))
}

fun containsDuplicate(nums: IntArray): Boolean = nums.toSet().size != nums.size