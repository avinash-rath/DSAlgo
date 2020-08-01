/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

 

Example 1:

Input: "USA"
Output: True

 

Example 2:

Input: "FlaG"
Output: False

 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/

/*
Extremely slow regex solution

class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2) {
            return true;
        }
        boolean isCap= false, flag = true;
        
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {isCap = true;}
        
        for(int i = 1; i<word.length(); i++) {
            if((isCap && Character.isUpperCase(word.charAt(i))) || (!isCap && Character.isLowerCase(word.charAt(i)))) {
                continue;
            } else {
                flag = false; break;
            }
        }
        return flag;
    }
}
