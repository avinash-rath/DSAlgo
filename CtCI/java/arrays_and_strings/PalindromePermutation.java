package CtCI.java.arrays_and_strings;

import java.util.*;

/**
 * 1.4
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A 
 * permutation is a rearrangement of letters. The palindrome does not need to be 
 * limited to just dictionary words.
 * 
 */
public class PalindromePermutation {
    public boolean isPerm(String str) {
        Map<Character, Integer> map = new HashMap<Character,Integer>(); 
        for(char i : str.toLowerCase().toCharArray()) {
            if(i==' ') continue;
            map.merge(i, 1, Integer::sum);
        }
        int count = 0;
        for(int i : map.values()) {
            if(i%2==1) count++;
        }
        return count <=1;
    }
}