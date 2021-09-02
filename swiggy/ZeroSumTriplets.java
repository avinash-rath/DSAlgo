package swiggy;

import java.util.HashSet;
import java.util.Set;
/**
 * Find all triplets with zero sum
Difficulty Level : Medium
Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.

Examples : 

Input : arr[] = {0, -1, 2, -3, 1}
Output : (0 -1 1), (2 -3 1)

Explanation : The triplets with zero sum are
0 + -1 + 1 = 0 and 2 + -3 + 1 = 0  

Input : arr[] = {1, -2, 1, 0, 5}
Output : 1 -2  1
Explanation : The triplets with zero sum is
1 + -2 + 1 = 0 
*/

/**
 * APPROACH
 * It is like two sum with a target that is 0. However, You have to find 3 numbers here. 
 * So, add two numbers and find out if the negative of that number exists in your hashSet.
 * If the number exists in your hashSet, then you've find three numbers that add up to 0.
 * In case you don't find the negative of your sum, you save one number in the hashSet.
 * 
 * This takes O(n^2) time and O(n) space.
 * 
 * 
 * 
 * Another approach to have O(1) space and O(n^2) time is to sort array and then for each 
 * element at index i, have two pointers l = i+1 and r = n - 1. 
 * Then if arr[r] + arr[l] + arr[i] < 0, do l++
 * else if arr[r] + arr[l] + arr[i] > 0, do r--
 * until l < r.
*/


public class ZeroSumTriplets {
    // prints the triplets in console
    public void findTriplets(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for(int j = i + 1; j < arr.length; j++) {
                int sum = -1 * (arr[i] + arr[j]);
                if(hashSet.contains(sum)) {
                    System.out.println(arr[i] + " " + sum + " " + arr[j]);
                } else {
                    hashSet.add(arr[j]);
                }
            }
        }
    }

    public static void main (String...s) {
        ZeroSumTriplets obj = new ZeroSumTriplets();
        obj.findTriplets(new int[] {1, -2, 1, 0, 5});
    }
}
