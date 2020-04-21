'''
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

'''

# don't necessarily need to find a pivot. Can directly go for binary searching the element.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) ==0 :
            return -1
        if len(nums) == 1:
            return 0 if target == nums[0] else -1
        def loop (compare, hi, lo):
            mid = lo + (hi-lo)//2
            if mid < 0:
                return 1
            if not mid<len(nums) : 
                return 0
            if (compare < nums[mid]):
                return loop(compare,mid+1,hi)
            else :
                if nums[mid-1]>nums[mid]:
                    return mid
                return loop(compare,lo,mid-1)
        
        pivot = loop(nums[0],0,len(nums)-1)
        n = len(nums)
        def binary(target,lo,hi,nums):
            print(lo,hi)
            if lo > hi:
                return -1
            wm = (lo + (hi-lo)//2)
            mid = wm % n
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                return binary(target,lo,wm-1,nums)
            else : 
                return binary(target,wm+1,hi,nums)
        return binary(target,pivot,pivot + n,nums) if pivot !=0 else binary(target,0,n-1,nums)
