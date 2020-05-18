'''
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

'''

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        letters = [0] * 26
        res = []
        for char in p:
            letters[ord(char) - 97] += 1

        j = 0
        remaining = len(p)

        for i in range(0, len(s)):
            while j < len(s) and j - i < len(p):
                freq = letters[ord(s[j]) - 97]
                if freq > 0:
                    remaining -= 1
                    
                letters[ord(s[j]) - 97] -= 1
                j += 1
            
            index = ord(s[i]) - 97
            
            if remaining == 0 and j - i == len(p):
                res.append(i)
     
            if letters[index] >= 0:
                remaining += 1
            letters[index] += 1
            
        return res
