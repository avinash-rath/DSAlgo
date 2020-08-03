/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
*/


class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char i: s.toCharArray()) {
          if(Character.isLetter(i)) str.append(Character.toLowerCase(i));   
          else if(Character.isDigit(i)) str.append(i);
        }
        String pal = str.toString();
      int l = pal.length();
      for(int i = 0; i<l/2; i++) {
        if(pal.charAt(i)==pal.charAt(l-i-1))continue;
        else return false;
      }
      return true;
    }
}
