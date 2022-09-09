package j005;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String example1 = "eeee";
        String example2 = "";
        String example3 = "baba";
        String example4 = "dfasgsfgdfhybetygrtygfsdfssf";
        String example5 = null;
        Solution solution = new Solution();
        System.out.printf("input: %s,   result: %s\n", example1, solution.longestPalindrome(example1));
        System.out.printf("input: %s,   result: %s\n", example2, solution.longestPalindrome(example2));
        System.out.printf("input: %s,   result: %s\n", example3, solution.longestPalindrome(example3));
        System.out.printf("input: %s,   result: %s\n", example4, solution.longestPalindrome(example4));
        System.out.printf("input: %s,   result: %s\n", example5, solution.longestPalindrome(example5));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isBlank()) return "";
        int longestFound = 0, palindromeEnd = 0, palindromeBegin = 0;

        for (int end = 0; end < s.length() + 1; end++) {
            for (int start = 0; start <= end ; start++) {
                if ((end - start > longestFound) && isPalindrome(s.substring(start, end))) {
                    longestFound = end - start;
                    palindromeEnd = end;
                    palindromeBegin = start;
                }
            }
        }
        return s.substring(palindromeBegin, palindromeEnd);
    }

    private boolean isPalindrome(String string) {
        if (string.isBlank()) return true;
        int length = string.length();
        for (int i = 0; i < (length / 2) + 1; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
