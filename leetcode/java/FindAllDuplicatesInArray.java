package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/


/*
//slow solution with set
class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i: nums) {
            if(set.contains(i)) ans.add(i);
            else set.add(i);
        }
        return ans;
    }
}

*/

class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] counts = new int[nums.length + 1];// given in problem statement that elements are smaller than the length of the array.
        for(int i: nums) {
            counts[i]++;
        }
        for(int i = 0; i< counts.length; i++) {
            if(counts[i]==2) {
                ans.add(i);
            }
        }
        return ans;
    }
}
