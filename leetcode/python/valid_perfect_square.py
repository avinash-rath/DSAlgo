'''
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

'''

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        def bin(num, lo, hi):
          print(lo, hi)
          if lo > hi:
            return False
          mid = lo + (hi-lo)//2
          if mid ** 2 == num:
            return True
          if mid ** 2 > num:
            return bin(num, lo, mid - 1)
          else:
            return bin(num, mid + 1, hi)
          
        return bin(num, 1, num)
