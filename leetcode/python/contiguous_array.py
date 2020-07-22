'''
525. Contiguous Array
Medium

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000. 
'''

class Solution:
    def findMaxLength(self, numbers: List[int]) -> int:
        sum_index = {} # KEY : Sum and VALUE : Index at which the sum occurs
        prefix_sum = 0
        count = 0
        for index, number in enumerate(numbers):
            prefix_sum += 1 if number == 1 else -1 
            if prefix_sum == 0: # If equal number of 0&1 is present ex: [1,0,0,1] here count = 4
                count = index + 1
            elif(prefix_sum not in sum_index):# if the sum is not already obtained add the sum along with 
                sum_index[prefix_sum] = index # the index where the sum was obtained.
            else:
                count = max(count,index-sum_index[prefix_sum]) #if the sum is already obtained then find the 
        return(count)                                          #difference between index of current sum and index  of previous sum this gives the total numbers.  
