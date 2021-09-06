package leetcode.java;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 */

public class Pow {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return 1;
        if(x == -1) return n % 2==0 ? 1 : -1;
        if(n > 0) {
            double res = myPow(x, n/2);
            if(n % 2 == 0) {
                return res * res;  
            } else {
                return res * res * x;
            }
        }
        else {
            double res = (1/x) * (1/myPow(x, -1 * (n+1)));
            return res;
        }
    }
}
