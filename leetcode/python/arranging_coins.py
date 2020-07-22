'''
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
'''
class Solution:
    def arrangeCoins(self, n: int) -> int:
        # Arithmetic progression sum
        return int(((1+8*n)**0.5-1)//2)

'''
class Solution:
    def arrangeCoins(self, n: int) -> int:
        # Arithmetic progression sum
        i = 1
        while i <= n+1:
          if int((i/2)*(2 + (i-1))) > n:
            return i-1
          i+=1
'''
