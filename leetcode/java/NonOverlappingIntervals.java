package leetcode.java;

import java.util.Arrays;

/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
*/

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (i1, i2) -> (i1[1]-i2[1]));
      
      int last=Integer.MIN_VALUE, ans=0;
      for(int [] interval: intervals) {
        if(interval[0]<last) ans++;
        else last = interval[1];
      }
      return ans;
    }
}
