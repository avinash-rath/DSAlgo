/*
313. Super Ugly Number
Medium

Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.

Note:

    1 is a super ugly number for any given primes.
    The given numbers in primes are in ascending order.
    0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
    The nth super ugly number is guaranteed to fit in a 32-bit signed integer.


*/
class Solution {
    public int nthSuperUglyNumber(int n, int[] p) {
        int [] index = new int[p.length];
        int [] dp = new int[n];
        int [] uglies = new int[p.length];
        Arrays.fill(uglies, 1);
        dp[0] = 1;
        int last_ugly = 1;
        for(int i=1; i<n; i++) {
            for(int j =0; j< p.length; j++) {
                if(uglies[j] == last_ugly) {
                    uglies[j] = dp[index[j]] * p[j];
                    index[j] += 1;
                }   
            }
            last_ugly = uglies[0];
            for(int j: uglies) last_ugly = Math.min(last_ugly,j);
            dp[i] = last_ugly;
        }
        return dp[n-1];
    }
    
}
