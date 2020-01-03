class Solution:
    def isPalindrome(self, x: int) -> bool:
        x = str(x)
        if x == x[::-1] :
            return True
        else :
            return False

#runs in 56 ms (75.96% faster) and 12.9MB space (100% less space)
