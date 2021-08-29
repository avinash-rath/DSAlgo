package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:  

    1 is typically treated as an ugly number.
    n does not exceed 1690.

*/

class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n<=0) return n;
        List<Integer> ugly = new ArrayList<Integer>();
        ugly.add(1);
        
        int two =0, three = 0, five = 0;
        
        while(ugly.size() < n) {
            int by2 = ugly.get(two) * 2;
            int by3 = ugly.get(three) * 3;
            int by5 = ugly.get(five) * 5;
            int min = Math.min(by2, Math.min(by3, by5));
            ugly.add(min);
            if(by2 == min) two++;
            if(by3 == min) three++;
            if(by5 == min) five++;
        }
        
        return(ugly.get(ugly.size()-1));
    }
}