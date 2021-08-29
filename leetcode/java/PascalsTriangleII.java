package leetcode.java;

import java.util.Arrays;
import java.util.List;

/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/
class PascalsTriangleII {
  /*
    Combinatorics -> 
    nth row of pascal's triangle is NC0 NC1 NC2 NC3 ..... NC(N-2) NC(N-1) NCN
    
    now NCR = N!/(N-R)! * R!                 - (1)
        NC(R-1)! = N!/(N-R+1)! * (R-1)!      - (2) 
        
        divide eq (1) and (2)
        
        NCR = NC(R-1) * (N-R+1)/R
  */
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex+1]; // length of nth row is n+1
        ans[0] = 1 ;// NC0 is always 1.
        for(int i=1; i<ans.length;i++) {
          ans[i] = (int)((long)ans[i-1] * (rowIndex - i + 1) / i);
        }
      return Arrays.asList(ans);
    }
}
