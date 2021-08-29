package leetcode.java;

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:

Input: "aba"
Output: False

Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


*/

class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int l = n/2; l > 0; l--) {
            if(n % l == 0) {
                int i = 0;
                while(((i+l) < n) && s.charAt(i) == s.charAt(i+l)) {
                    i++;
                }
                if(i+l == n) return true;
            }
        }
        return false;
    }
}
