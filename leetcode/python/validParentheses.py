'''
20. Valid Parentheses
Easy

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true


'''
# works for all inputs with expressions. Not necessarily just inputs with parantheses
class Solution:
    def isValid(self, s: str) -> bool:
        tracker = []
        for i in s:
            if i == '(' or i == '[' or i == '{':
                tracker.append(i)
            if len(tracker) == 0:
                if i == ']' or i == ')' or i=='}':
                    return False
            if len(tracker) > 0:
                if i == ')':
                    var = tracker.pop()
                    if var!='(':return False
                if i == ']':
                    var = tracker.pop()
                    if var!='[':return False
                if i == '}':
                    var = tracker.pop()
                    if var!='{':return False
        return True if len(tracker) == 0 else False
#Runtime: 32 ms, faster than 35.44%     Memory Usage: 13.1 MB, less than 88.70%

'''
#Works only for the specific problem but significantly faster

#Runtime: 28 ms, faster than 71.47% of Python3 online submissions for Valid Parentheses.
#Memory Usage: 13.1 MB, less than 93.91% of Python3 online submissions for Valid Parentheses.

class Solution:
    def isValid(self, s: str) -> bool:
        pointer = 0
        last = []
        openers={'(':')','[':']','{':'}'}
        for i in s:
            if i == '(' or i == '[' or i == '{':
                pointer += 1
                last.append(i)
            if pointer == 0:
                return False
            if pointer > 0:
                if i == ')' or i == ']' or i == '}':
                    if i!=openers[last.pop()]:
                        return False
                    else : pointer-=1
        return True if pointer == 0 else False
'''
