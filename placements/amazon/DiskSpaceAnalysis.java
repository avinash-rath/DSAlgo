package placements.amazon;

import java.util.*;

/*
Position: New Grad 2021

Amazon is performing an analysis on the computers at one of its offices.

The computers are spaced along a single row. The analysis is performed in the following way:
Choose a contiguous segment of a certain number of computers, starting from the beginning of the row.

Analyze the available hard disk space on each of the computers. Determine the minimum available disk space within this segment. After performing these steps for the first segment, it is then repeated for the next segment, continuing this procedure until the end of the row (i.e. if the segment size is 4, computers 1 to 4 would be analyzed, then 2 to 5, etc.)

Given this analysis procedure, write an algorithm to find the maximum available disk space among all the minima that are found during the analysis.

Input:

The input to the function/method consists of 3 arguments:
numComputer, an integer representing the number of computers;
hardDiskSpace, a list of integers representing the hard disk space of the computers;
segmentLength, an integer representing the length of the contiguous segment of computers to
be consider in each iterations.

Output:

Return an integer representing the maximum available disk space among all the minima that are found during the analysis.

Constraints:

1 ≤ numComputer ≤ 10^6
1 ≤ segmentLength ≤ numComputer
1 ≤ hardDiskSpace[i] ≤ 10^9
0 ≤ i < numComputer

Example:
Input:

numComputer = 3
hardDiskSpace = [8,2,4]
segmentLength = 2

Output:

2

Explanation:

In this array of computers, the subarrays of size 2 are [8,2] and [2,4].
Thus, the initial analysis returns 2 and 2 because those are the minima for the segmenets.
Finally the maximum of these values is 2.
Therefore, the answer is 2.
*/
public class DiskSpaceAnalysis {
    public int find(int numComputers, int[] hardDiskSpace, int segmentLength) {
        int ans = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<hardDiskSpace.length; i++) {
            while(!deque.isEmpty() && hardDiskSpace[deque.peekLast()] > hardDiskSpace[i]) {
                deque.pollLast();
            }
            if(!deque.isEmpty() && deque.peekFirst() <= i- segmentLength ) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if(i>= segmentLength-1)
            ans = Math.max(ans, hardDiskSpace[deque.peekFirst()]);
        }
        return ans;
    }

    public static void main(String ...s) {
        DiskSpaceAnalysis space = new DiskSpaceAnalysis();
        System.out.println(space.find(3, new int[] {8, 2, 4}, 2));
        System.out.println(space.find(6, new int[] {8, 2,4,3,7,6}, 2));//6
        System.out.println(space.find(6, new int[] {8, 2,4,3,7,6}, 3));//3
        System.out.println(space.find(7, new int[] {2,4,3,7,8,6,5}, 4));//5
        System.out.println(space.find(13, new int[] {2,4,3,7,8,6,5,16,19,33,32,34,35}, 5));
    }
}
