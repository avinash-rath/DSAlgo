package leetcode.java;
/**
 * 
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation:
row 1: 0
row 2: 01
Example 4:

Input: n = 3, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01
row 3: 0110
 

Constraints:

1 <= n <= 30
1 <= k <= 2n - 1

Hint #1  
Try to represent the current (N, K) in terms of some (N-1, prevK). What is prevK ?
 */
public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        /*
                               0
                              0 1
                             01 10
                           0110 1001
                      0110 1001 1001 0110
            0110 1001 1001 0110 1001 0110 0110 1001
        */
        if(n == 1) return 0;
        int res = kthGrammar(n-1, k / 2 + k % 2);
        if(k % 2 == 0) {
            return res == 0 ? 1 : 0;
        } else {
            return res == 0 ? 0 : 1; 
        }
    }
}
