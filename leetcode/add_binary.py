'''
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
'''



class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        ans = ''
        for i in range(min(len(a), len(b))):
          bita, bitb = int(a[-1-i]), int(b[-1-i])
          res = bita ^ bitb ^ carry
          carry = 1 if bita+bitb+carry > 1 else 0
          ans = str(res) + ans
        i += 1
        if len(a) > len(b):
          while i < len(a):
            bit = int(a[-1-i])
            res = carry ^ bit 
            carry = bit & carry
            ans = str(res) + ans
            i += 1
        elif len(b) > len(a):
          while i < len(b):
            bit = int(b[-1-i])
            res = carry ^ bit 
            carry = bit & carry
            ans = str(res) + ans
            i += 1
            
        print(ans)
        if carry == 1: ans = str(carry) + ans
        return ans
            
          
          
          
