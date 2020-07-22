'''
1224. Maximum Equal Frequency
Hard

154

18

Add to List

Share
Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.

If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).

 

Example 1:

Input: nums = [2,2,1,1,5,3,3,5]
Output: 7
Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
Example 2:

Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
Output: 13
Example 3:

Input: nums = [1,1,1,2,2,2]
Output: 5
Example 4:

Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6]
Output: 8
 

Constraints:

2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
'''

from collections import Counter
class Solution:
    def maxEqualFreq(self, nums: List[int]) -> int:
      
      def isValid(dp: List[int]):
        c = Counter(dp)
        cVal = Counter(c.values())
        
        if len(cVal) > 2 :
          return False
        
        if len(cVal) == 1 :
          if (1 in cVal) or (1 in list(cVal.values())):
            return True
          else:
            return False
        
        k = list(cVal.keys())
        v = list(cVal.values())
        b = False
        if cVal[k[0]] > cVal[k[1]]:
          if k[1] - k[0] == 1:
            b = True
        else:
          if k[0] - k[1] ==1:
            b = True
        
        if (b or 1 in k) and (1 in v):
          return True
        return False
        
      dp = []
      ans = 0
      for i in nums:
        dp.append(i)
        if isValid(dp):
          ans = len(dp)
      return ans
          

          
          
