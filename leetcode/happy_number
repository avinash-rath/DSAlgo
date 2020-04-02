'''
202. Happy Number
Easy

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1**2 + 9**2 = 82
8**2 + 2**2 = 68
6**2 + 8**2 = 100
1**2 + 0**2 + 02 = 1

'''
# This is fast (32ms) but still slower than other solutions.
# no string to int conversions and shit.
class Solution:
    def isHappy(self, n: int) -> bool:
        def sumOfSquares( n:int) -> int:
            x = n
            digit,addSum = 0,0
            while x > 0:
                digit = x % 10
                addSum += digit**2
                x = x//10
            return addSum
        if n > 0 :
            x = n
            while(x!=1 and x!=7) :
                x = sumOfSquares(x)
                if x>1 and x<10 and x!=7:
                    return False
            return True
        else : 
            return False

'''
#Very slow but one liner brainfucker. :)
class Solution:
    def isHappy(self, n: int) -> bool:
        limit = 0
        while limit < 1000:
            n = sum(map(lambda x:x**2, [int(i) for i in list(str(n))] ))
            limit += 1
            if n == 1: return True
        return False
'''        
