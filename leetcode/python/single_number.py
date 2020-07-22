class Solution:
    def singleNumber(self, nums: List[int]) -> int:
      
      # using XOR function's property, which goes like
      # n^0 = n
      # n^n = 0
      # now n^x^n = (n^n)^x = x. Thus in the end all we 
      # get is the number that isn't repeated. (This works 
      # because it is told that the numbers are repeated twice.)
      return reduce(lambda x,y:x^y,nums)
  '''
This takes a lot of space and is slow

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        mymap = dict()
        for i in nums :
          if i in mymap.keys() :
            mymap[i] += 1
          else :
            mymap[i] = 1
        for i in mymap :
          if mymap[i] == 1 : return i
''' 

'''
This takes a lot of space too

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return 2*(sum(set(nums))) - sum(nums)
'''    
      
