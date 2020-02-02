class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        sg = None
        for item in nums:
          try:
            sg = item
            if nums[nums.index(item)+1] == item:
              nums[nums.index(item)] = None
            else: pass
          except :
            if nums[-1] == nums[nums.index(item)-1]:
              nums[nums.index(item)] = None
        while(None in nums) :
          nums.remove(None)
        if len(nums) == 0:
          nums.append(sg)
        while(None in nums) :
          nums.remove(None)
        return len(nums)
#very very slow 5028ms 5% and 14.4mb 99.18%
