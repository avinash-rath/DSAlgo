'''
633. Sum of Square Numbers
Easy

Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5

 

Example 2:

Input: 3
Output: False
'''

class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        if (c**0.5 == int(c**0.5)) : return True
        myrange = range(1,int(c**0.5)+1)
        for i in myrange:
            j = c - i**2
            j = j ** 0.5
            if j == int(j) and j in myrange:
                return True
        return False
