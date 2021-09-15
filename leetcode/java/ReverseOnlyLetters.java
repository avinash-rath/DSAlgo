package leetcode.java;

/**
 * Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
 */

class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char [] a = s.toCharArray();
        int i = 0; int j = a.length - 1;
        while(i < j) {
            boolean isAlphaI = isAlpha(a[i]);
            boolean isAlphaJ = isAlpha(a[j]);
            if(isAlphaI && isAlphaJ) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++; j--;
            } else if (!isAlphaI) {
                i++;
            } else if (!isAlphaJ) {
                j--;
            }
        }
        return new String(a);
    }
    private boolean isAlpha(char c) {
        int ascii = c;
        return (ascii >= 65 && ascii <= 90) || (ascii >= 97);
    }
}