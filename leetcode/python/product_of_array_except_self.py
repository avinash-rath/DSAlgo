'''
238. Product of Array Except Self
Medium

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
'''

'''
# slow and elementary solution
import math
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [None] * len(nums)
        for i in range(0,len(nums)):
            temp = nums[:]
            temp.pop(i)
            output[i] = math.prod(temp)
        return output
'''

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [1] * len(nums)
        left,right=1,1
        for i in range(0,len(nums)):
            output[i] *= left
            output[-1-i] *= right
            left *= nums[i]
            right *= nums[-1-i]
        return output
