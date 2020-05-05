'''
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

'''



class Solution:
    def firstUniqChar(self, s: str) -> int:
      myset = set()
      for i,c in enumerate(s):
        if c not in myset: myset.add(c)
        else : continue
        if c in s[i+1:] : continue
        else: return i
      return -1
