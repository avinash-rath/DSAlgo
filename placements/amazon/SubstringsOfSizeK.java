
package amazon;

import java.util.*;
/**
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

Example 1:

Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]

Example 2:

Input: s = "abacab", k = 3
Output: ["bac", "cab"]

Example 3:

Input: s = "awaglknagawunagwkwagl", k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
Explanation: 
Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
"wagl" is repeated twice, but is included in the output once.

Constraints:

    The input string consists of only lowercase English letters [a-z]
    0 ≤ k ≤ 26

 */
public class SubstringsOfSizeK {
    public List<String> substrings(String s, int k) {
        List<String> ans = new ArrayList<>();
        Set<String> ansStrs = new HashSet<>();
        int [] table = new int[26];
        int start=0,end=0;
        while(start<=end && end < s.length()) {
            table[s.charAt(end) - 'a']++;
            while(table[s.charAt(end)-'a']!=1) {
                table[s.charAt(start)-'a']--;
                start++;
            }
            if(end-start+1 == k) {
                ansStrs.add(s.substring(start,end+1));
                table[s.charAt(start)-'a']--;
                start++;
            }
            end++;
        }
        for(String str : ansStrs) {
            ans.add(str);
        }
        return ans;
    }

    public static void main(String...s) {
        SubstringsOfSizeK obj = new SubstringsOfSizeK();
        System.out.println(obj.substrings("awaglknagawunagwkwagl",4));
    }
}
