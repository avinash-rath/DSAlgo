/*
1432. Max Difference You Can Get From Changing an Integer
Medium

You are given an integer num. You will apply the following steps exactly two times:

    Pick a digit x (0 <= x <= 9).
    Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
    Replace all the occurrences of x in the decimal representation of num by y.
    The new integer cannot have any leading zeros, also the new integer cannot be 0.

Let a and b be the results of applying the operations to num the first and second times, respectively.

Return the max difference between a and b.

 

Example 1:

Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888

Example 2:

Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8

Example 3:

Input: num = 123456
Output: 820000

Example 4:

Input: num = 10000
Output: 80000

Example 5:

Input: num = 9288
Output: 8700

 

Constraints:

    1 <= num <= 10^8

Accepted
8,631
Submissions
20,069
*/
// clearly not a programmatic solution(but it's faster), check commented part below.
class Solution {
    public int maxDiff(int num) {
        String a = ""+num;
        String b = ""+num;
        for(int i = 0; i< a.length(); i++) {
            if(a.charAt(i) != '9') {
                a = a.replace(a.charAt(i),'9');
                break;
            }
        }
        if(b.charAt(0) != '1') b = b.replace(b.charAt(0),'1');
        else {
            for(int i = 1; i<b.length(); i++) {
                char bc = b.charAt(i);
                if(bc != '0' && bc!='1') {
                    b = b.replace(b.charAt(i),'0');
                    break;
                }
            }
        }
        return Integer.parseInt(a.toString()) - Integer.parseInt(b.toString());
    }
}



/*
// When you think StringBuffer will be faster but it's not
// Just use .toCharArray(), would be way faster.
class Solution {
    public int maxDiff(int num) {
        StringBuffer a = new StringBuffer(""+num);
        StringBuffer b = new StringBuffer(""+num);
        char as = 'a', bs='b';
        String bn="0";
        for(int i =0; i<a.length(); i++) { // make a
            char ac = a.charAt(i);
            if(ac != '9' && as == 'a') {
                as = ac;
                a.replace(i,i+1,"9");
                // break;
            }
            if(ac == as) {
                a.replace(i,i+1,"9");
            }
        }
        if(b.charAt(0) != '1') {
            bs = b.charAt(0);
            bn = "1";
            b.replace(0,1,bn);
        }
        for(int i=1; i<b.length(); i++) {
            char bc = b.charAt(i);
            if(bn.equals("0") && (bc != '0' && bc != '1') && bs == 'b') {
                bs = bc;
                b.replace(i,i+1,bn);
                // break;
            }
            if(bc == bs) {
                b.replace(i,i+1,bn);
            }
        }
        // System.out.println(" "+a.toString()+" "+b.toString());
        return Integer.parseInt(a.toString()) - Integer.parseInt(b.toString());
    }
}
*/
