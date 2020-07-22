'''
1003. Check If Word Is Valid After Substitutions
Medium

We are given that the string "abc" is valid.
From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.
If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
Return true if and only if the given string S is valid.

Example 1:

Input: "aabcbc"
Output: true
Explanation: 
We start with the valid string "abc".
Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".

Example 2:

Input: "abcabcababcc"
Output: true
Explanation: 
"abcabcabc" is valid after consecutive insertings of "abc".
Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".

Example 3:

Input: "abccba"
Output: false

Example 4:

Input: "cababc"
Output: false

 

Note:

    1 <= S.length <= 20000
    S[i] is 'a', 'b', or 'c'

'''
class Solution:
    def isValid(self, S: str) -> bool:
        #from the note S[i] can be either 'a','b' or 'c'
        mymap = {'a':1,'b':2,'c':3}
        last = ''
        isRep = None #Bool value
        lastRep = ''
        isRev = None
        counter = -1
        for i in S:
            counter += 1
            if last == '' : 
                last = i
                if i!='a':return False
                continue
            if mymap[i] > mymap[last]:
                if mymap[i]-mymap[last]!=1:
                    return False
                if isRev == True : 
                    isRev = False
            if mymap[i]==mymap[last]:
                if isRep == True:
                    print('here at i =',i,counter)
                    return False
                if lastRep == '':
                    lastRep=i
                    continue
                if lastRep == i:
                    continue
                isRep = True
            if mymap[i] < mymap[last]:
                if isRev == True:
                    return False
                isRev = True
            last = i
        return True
