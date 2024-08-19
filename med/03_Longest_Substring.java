package med;
import java.util.HashMap;
/* 
3. Longest Substring Without Repeating Characters
* * *  Level: MEDIUM

Problem Description:
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces */

public class Longest_Substring {

        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int result = 0; // result
            int i = 0;
    
            // initialize hash map to store the last positions of occurrence
            HashMap<Character, Integer> lastIndex = new HashMap<>();
    
            // Starting from the beginning of the string
            for (int j = 0; j < n; j++) {
                // If this character is seen before, then update i
                if (lastIndex.containsKey(s.charAt(j))) {
                    i = Math.max(i, lastIndex.get(s.charAt(j)) + 1);
                }
    
                // Update result if needed
                result = Math.max(result, j - i + 1);
    
                // Update the last occurrence of the current character
                lastIndex.put(s.charAt(j), j);
            }
            return result;
    }
 }
