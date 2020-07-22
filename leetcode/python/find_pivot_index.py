'''
724. Find Pivot Index
Easy

957

222

Add to List

Share
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
 

Example 2:

Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
 

Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].

'''

#leftsum and rightsum compared together
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
      right = sum(nums)
      left = 0
      for i in range(len(nums)):
        right -= nums[i]
        if left == right:
          return i
        left += nums[i]
      return -1
     
'''
#O(n) time and O(n) space solution

class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
      
      n=len(nums)
      if n ==0:
        return -1
      left=[0]*n
      add = 0
      for i in range(1,n):
        add += nums[-i]
        left[-1-i]=add
      add = 0
      if add == left[0]:
        return 0
      for i in range(1,n):
        add += nums[i-1]
        if add == left[i]:
          return i
      return -1
'''
