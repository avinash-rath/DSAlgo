class Solution:
    def reverse(self, x: int) -> int:
        if x < 0 :
            x = -x 
            x = str(x)
            x = x[::-1]
            x = int(x)
            x = - x
            if x < -2 ** 31 :
                return 0
            else :
                return x
        else :
            x = str(x)
            x = x[::-1]
            x = int(x)
            if x > 2 ** 31 - 1 :
                return 0
            else :
                return x

            
# runs in 28 ms (77.39% faster) and uses 12.7 mb, (less than 100% submissions, WTF!)  
