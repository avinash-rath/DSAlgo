package leetcode.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
*/

class GoatLatin {
    public String toGoatLatin(String S) {
      StringBuilder ans = new StringBuilder();
      StringBuffer ma = new StringBuffer("ma");
      Set<Character> vowels = new HashSet<Character>(Arrays.asList(new Character [] {'a','e','i','o','u','A','E','I','O','U'}));
      for(String i : S.split(" ")) {
        StringBuffer j = new StringBuffer(i);
        if(!(vowels.contains(i.charAt(0)))) { 
          j.append(j.charAt(0)); 
          j.deleteCharAt(0);
        }
        ma.append('a');
        j.append(ma);
        j.append(" ");
        ans.append(j);
      }
      ans.deleteCharAt(ans.length() - 1);
      return ans.toString();
    }
}
