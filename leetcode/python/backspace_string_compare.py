'''
844. Backspace String Compare
Easy

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

Follow up:

    Can you solve it in O(N) time and O(1) space?


'''


class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        str1= ""
        str2= ""
        for i in range(0,len(S)):
            if S[i] != '#' :
                str1 += S[i]
                continue
            if (S[i] == '#'):
                str1 = str1[:-1]
                continue
            if (S[i] == '#') and i==0:
                continue
        for i in range(0,len(T)):
            if T[i] != '#' :
                str2 += T[i]
                continue
            if (T[i] == '#'):
                str2 = str2[:-1]
                continue
            if (T[i] == '#') and i==0:
                continue
        print("str1=",str1,"str2=",str2)
        return True if str1 == str2 else False
