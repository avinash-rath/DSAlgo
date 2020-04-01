
#Fastest solution.

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
      mydict = dict()
      for i in nums:
        if i in mydict.keys():
          mydict[i]+=1
        else:
          mydict[i]=1
      for i in mydict:
        if mydict[i]==1:
          return i
          
'''

#Not so fast, also takes the same amount of memory. 

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
      nums.sort()
      i = 0
      while i < len(nums)-1 :
        if nums[i] == nums[i+1]:
          i+=3
        else:
          return nums[i]
      return nums[-1]
'''  

'''
#Slowest. Aso takes the same amount of memory.

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return int((3*sum(set(nums)) - sum(nums))/2)
'''
