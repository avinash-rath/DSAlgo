'''
4. Median of Two Sorted Arrays
Hard

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
'''

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = []
        p1,p2 = 0,0
        mid = int((len(nums1)+len(nums2))/2)+1
        while (len(nums)<mid) :
            if p1<len(nums1) and p2<len(nums2):
                if nums1[p1]<nums2[p2] :
                    nums.append(nums1[p1])
                    p1+=1
                else:
                    nums.append(nums2[p2])
                    p2+=1
            elif p1 < len(nums1):
                nums.append(nums1[p1])
                p1+=1
            else:
                nums.append(nums2[p2])
                p2+=1
        print(nums)
        if((len(nums1) + len(nums2)) % 2 == 0):
            return (nums[-1] + nums[-2]) / 2
        else:
            return (nums[-1])
            
