package leetcode.java;

import java.util.Arrays;

/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/

/* O(n) - but slower than sorting. smh
class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(k - nums[i]) && map.get(k-nums[i]) > 0) {
                ans++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                map.merge(nums[i], 1, Integer::sum);
            }
        }
        return ans;
    }
}
*/
class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        
        return count;
    }
}
