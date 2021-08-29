package leetcode.java;

import java.util.HashSet;
import java.util.Set;

/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

/*
class Solution {
    public int longestPalindrome(String s) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for(char i : s.toCharArray()) {
          map.merge(i, 1, Integer::sum);
      }
      int ans = 0;
      int odd = 0;
      boolean takenOdd=false;
      for(int i : map.values()) {
        if(i%2==0) ans += i;
        else {ans += i - 1; takenOdd = true;}
      }
      ans += takenOdd? 1: 0;
      return ans;
    }
}
*/

class Solution {
    public int longestPalindrome(String s) {
      int ans = 0;
      Set<Character> set = new HashSet<Character>();
      for(char i : s.toCharArray()) {
        if(set.contains(i)) { set.remove(i); ans += 2; }
        else set.add(i);
      }
      return set.size() > 0 ? ans + 1: ans;
    }
}
