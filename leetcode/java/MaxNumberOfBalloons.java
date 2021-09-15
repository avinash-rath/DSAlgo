package leetcode.java;

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Set;


/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.
 */
class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];
        int[] balloon = new int[26];
        
        String bal = "balloon";
        
        
        // freq in balloons
        for(Character c : bal.toCharArray()) {
            balloon[c - 'a']++;
        }
        
        // freq in text
        for(Character c : text.toCharArray()) {
            hash[c-'a']++;
        }
        
        int min = Integer.MAX_VALUE;
        // compare
        for(int i = 0; i < 26; i++) {
            if(balloon[i] == 0) continue;
            min = Math.min(hash[i]/balloon[i], min);
        }
        return min;
    }
    // works but slow. meh!
    // public int maxNumberOfBalloons(String text) {
    //     HashMap<Character, Integer> freq = new HashMap<>();
    //     Set<Character> charSet = new HashSet<>(Arrays.asList(new Character [] {'b','a','l','o','n'}));
    //     for(char c : text.toCharArray()) {
    //         if(charSet.contains(c))
    //         freq.merge(c,1,Integer::sum);
    //     }
    //     for(Character c : charSet) {
    //         int n = freq.getOrDefault(c,0);
    //         if(c == 'l' || c =='o') n /= 2;
    //         freq.put(c,n);
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(Integer i : freq.values()) {
    //         min = Math.min(min, i);
    //     }
    //     return min;
    // }
}