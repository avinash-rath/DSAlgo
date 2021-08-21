/*
Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
 

Constraints:

-231 <= num <= 231 - 1


*/

/* Smart solution
class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        char[] vals = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        
        if (num == 0) {
            return "0";
        }
        
        while (num != 0) {
            sb.append(vals[num & 0xf]);
            num >>>= 4;
        }
        
        return sb.reverse().toString();
    }
}
*/
class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        StringBuilder strb = new StringBuilder();
        long quo;
        char [] hash = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num < 0) {
            quo = (long)Math.pow(2,32) - (long)Math.abs((long)num);
        } else {
            quo = num;
        }
        while(quo > 15) {
            long rem = quo % 16;
            strb.insert(0,hash[(int)rem]);
            //strb.insert(0, rem > 9 ? (char)(97 + rem - 10) : (char)(rem));
            quo = quo / 16;
        }
        //strb.insert(0, quo > 9 ? (char)(97 + quo - 10) : (char)(quo));
        strb.insert(0,hash[(int)quo]);
        return strb.toString();
    }
}
