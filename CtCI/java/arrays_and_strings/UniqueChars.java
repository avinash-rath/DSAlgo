package arrays_and_strings;

import java.util.*;

/*
    1.1
    Is Unique - Implement an algorithm to determine if a string has all unique characters
    What if you cannot use additional data structures?
*/

/*
    Special cases - 
    1. if considering only ASCII characters, 
    if the string length is over 128 characters, there is no way chars aren't repeated.
             
*/
public class UniqueChars {
    public boolean isUnique(String str) {
        /**
         * Time complexity - O(n), n-> str.length()
         * space complexity - O(n), n-> str.length()
         */
        if (str.length() > 128) return false; // special case 1
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i<str.length(); i++) {
            if(set.contains(str.charAt(i))) {
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }

    // public boolean isUnique(String str) {
    //     /**
    //      * Using bit vectors can reduce space complexity
    //      * 
    //      */
    //     int checker = 0;
    //     for(int i = 0; i <str.length(); i++) {
    //         int val = str.charAt(i) - 'a';
    //         if((checker & (1 << val)) > 0){
    //             return false;
    //         }
    //         checker |= (1 << val);
    //     }
    //     return true;
    // }
}