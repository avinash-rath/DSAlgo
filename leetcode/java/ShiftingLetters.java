package leetcode.java;

/**
 * You are given a string s of lowercase English letters and an integer array shifts of the same length.

Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.

 

Example 1:

Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: We start with "abc".
After shifting the first 1 letters of s by 3, we have "dbc".
After shifting the first 2 letters of s by 5, we have "igc".
After shifting the first 3 letters of s by 9, we have "rpl", the answer.
Example 2:

Input: s = "aaa", shifts = [1,2,3]
Output: "gfd"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
shifts.length == s.length
0 <= shifts[i] <= 109
 */

public class ShiftingLetters {
    //fast boi
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }
        char [] ret = new char[shifts.length];
        for(int i = 0; i < s.length(); i++) {
            ret[i] = (char)((s.charAt(i) + shifts[i] - 'a') % 26 + 'a');
        }
        return new String(ret);
    }
    /*
    // more memory optimized in terms of using a char Array
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            b.append((char)((s.charAt(i) + shifts[i] - 'a') % 26 + 'a'));
        }
        return b.toString();
    }
    */
    
    /*
    // slow and unoptimized solution
    public String shiftingLetters(String s, int[] shifts) {
        int [] changes = new int[s.length()];
        changes[changes.length-1] = shifts[changes.length-1] % 26;
        for(int i = shifts.length-2; i >= 0; i--) {
            changes[i] = (shifts[i] + changes[i+1]) % 26;
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i); int a = 'a'; int z = 'z';
            num += changes[i];
            if(num > z) num = num - z + a-1;
            builder.append((char)num);
        }
        return builder.toString();
    }
    */
}
