package leetcode.java;

/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
*/

class PowerOf4 {
    public boolean isPowerOfFour(int num) {
      double a=Math.log(num)/Math.log(4);
      return ( a == (int)a );
    }
}
