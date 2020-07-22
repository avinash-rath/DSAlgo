class Solution:
    def isPalindrome(self, x: int) -> bool:
        x = str(x)
        if x == x[::-1] :
            return True
        else :
            return False

#runs in 56 ms (75.96% faster) and 12.9MB space (100% less space)

# one liner return str(x) == str(x)[::-1]
#runs in 32 ms (99.72% faster) and 12.7 Mb space (100% less space again).
