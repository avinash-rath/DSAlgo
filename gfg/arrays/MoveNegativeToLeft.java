package gfg.arrays;

import java.util.Arrays;

/**
 * Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy
Last Updated : 09 Jun, 2021
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
Note: Order of elements is not important here.
 */

public class MoveNegativeToLeft {
    public void moveToLeft(int [] arr) {
        int i = 0, j = 0;
        while( j < arr.length) {
            if(arr[j] >= 0) {
                j++;
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j++;
        }
    }

    public static void main(String...s) {
        MoveNegativeToLeft obj = new MoveNegativeToLeft();
        int [] arr = new int [] {1,2,3,-3,-2,5,6,-12};
        obj.moveToLeft(arr);
        System.out.println(Arrays.toString(arr));
    }
}
