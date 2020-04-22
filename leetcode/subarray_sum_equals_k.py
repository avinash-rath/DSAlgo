'''
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
'''

'''
sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
Can we use this property to optimize it?

Make a hashmap and save as {sum:frequency}. Now following the formula sum(i,j) = sum(0,j)-sum(0,i)  

if sum(i,j) == k, add it's frequency to the the count.
'''

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mydict = defaultdict(int)
        count,add=0,0
        mydict[0] = 1
        for i in nums:
          add += i
          if (add-k) in mydict.keys():
            count += mydict[add-k]
          if add in mydict.keys():
            mydict[add] += 1
          else: 
            mydict[add] = 1
        return count
