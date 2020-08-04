package arrays_and_strings;

import java.util.*;
/**
 * 1.2
 * Given two strings, write a method to decide if one is a permutation of the other.
 * 
 */
public class CheckPermutation {
    public boolean isPermutation(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        Map<Character,Integer> map1 = new HashMap<Character, Integer>();
        Map<Character,Integer> map2 = new HashMap<Character, Integer>();
        for(char i : str1.toCharArray()) {
            map1.merge(i,1,(v1,v2)-> v1+v2); // BiFunction equivalent to lambda functions in python
            // map1.merge(i,1,Integer::sum);
            // alternatively do 
            // map.computeIfPresent(i, (k,v) -> v+1);
            // map.putIfAbsent(i, 1);
        }
        for(char i: str2.toCharArray()) {
            map2.merge(i,1,Integer::sum);
        }
        return map1.equals(map2);
    }
}