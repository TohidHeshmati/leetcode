package k001

fun main() {
    // IntArray == intArrayOf(2, 7, 11, 15), arrayOf(2, 7, 11, 15) == Array<Int>
    val example1 = intArrayOf(3, 2, 4)
    val target1 = 6
    val example2 = intArrayOf(9, 2, 7, 11, 15)
    val target2 = 9
    val example3 = intArrayOf(2, 7, 11, 15)
    val target3 = 9
    val solution = Solution()
    println("input: ${example1.contentToString()}, result: ${solution.twoSum(example1, target1).contentToString()}")
    println("input: ${example2.contentToString()}, result: ${solution.twoSum(example2, target2).contentToString()}")
    println("input: ${example3.contentToString()}, result: ${solution.twoSum(example3, target3).contentToString()}")
}

// 250 mil - mine
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index, number ->
            for (i in index + 1 until nums.size) {
                if (number + nums[i] == target) {
                    return intArrayOf(index, i)
                }
            }
        }
        return intArrayOf()
    }
}

// 235 mil - readable and efficient
// class Solution {
//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        val map = mutableMapOf<Int, Int>()
//        for ((i,value) in nums.withIndex()) {
//            if(map.containsKey(target - value)) {
//                return intArrayOf(map[target - value]!!, i)
//            }
//            map[value] = i
//        }
//        return intArrayOf()
//    }
// }

// 211 mill i like the return type
// class Solution {
//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        var map = HashMap<Int, Int>()
//        nums.forEachIndexed { index, value ->
//            var diff = target - value
//            if (map[diff] != null) {
//                return intArrayOf(map[diff]!!, index)
//            }
//            map[value] = index
//        }
//        return intArrayOf(-1, -1)
//    }
// }
