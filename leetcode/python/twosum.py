class TwoSums:
    def twoSum(self, nums: List[int], target: int) -> List[int] :
        my_map = {}
        for i in range(len(nums)):
            num = nums[i]
            pair = target - num
            if pair in my_map:
                return [my_map[pair],i]
            my_map[num] = i
        return None
# takes 44ms and 13.9mb (96.06% faster , 66.05 % less size)


# for i in range(0,len(nums)-2) : 
#     for j in range(i+1,len(nums)-1) :
#         if nums[i] + nums[j] == target:
#             return [i,j]
# takes 5996 ms and 13.8mb (8.86% faster , 71.86% less size)   