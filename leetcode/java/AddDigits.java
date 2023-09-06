package leetcode.java;

import java.util.HashSet;

/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/

class AddDigits {
    public int addDigits(int num) {
        int n = 0;
        while(num/10 != 0) {
            n += num%10;
            num /= 10;
            // System.out.println(num+ " "+ n);
            if(num/10 == 0) {num += n; n =0;}
        }
        return num;
    }
}
