package gfg.arrays;

import java.util.Arrays;

/**
 * Sort an array of 0s, 1s and 2s 
Easy Accuracy: 51.36% Submissions: 100k+ Points: 2
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2
 */

public class SortArray012 {
    // cheesy solution
    public void sort012(int a[], int n) {
        int [] f = new int[3];
        for(int i = 0; i < n; i++) {
            f[a[i]]++;
        } 
        int i = 0;
        while(f[0]-- > 0) {
            a[i] = 0;
            i++;
        }
        while(f[1]-- > 0) {
            a[i] = 1;
            i++;
        }
        while(f[2]-- > 0) {
            a[i] = 2;
            i++;
        }
    }

    public static void main(String...s) {
        SortArray012 obj = new SortArray012();
        int [] arr = new int[] {0,1,2,0,2,1,2,1};
        obj.sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
