'''
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

 

Constraints:

    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.

'''


'''
#Slow recursive DP
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        def solve(p1,p2):
            if p1 == len(text1) or  p2 == len(text2):
                return 0
            if text1[p1] == text2[p2]:
                return 1+solve(p1+1,p2+1)
            else:
                return max(solve(p1+1,p2),solve(p1,p2+1))
        return solve(0,0)
        
'''
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        n1,n2 = len(text1),len(text2)
        dp = [[0 for i in range(n2+1)] for j in range(n1+1)]
        text1 = " "+text1
        text2 = " "+text2
        for i in range(1,n1+1):
            for j in range(1,n2+1):
                if text1[i] == text2[j]:
                    dp[i][j] = 1+dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return dp[-1][-1]
        



