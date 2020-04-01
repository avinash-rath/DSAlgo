class Solution:
    def singleNumber(self, nums: List[int]) -> int:
      
      # using XOR function's property, which goes like
      # n^0 = n
      # n^n = 0
      # now n^x^n = (n^n)^x = x. Thus in the end all we 
      # get is the number that isn't repeated. (This works 
      # because it is told that the numbers are repeated twice.)
      
      
      
