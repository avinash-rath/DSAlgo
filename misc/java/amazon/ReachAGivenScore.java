package amazon;
/*

Reach a given score
Easy Accuracy: 52.75% Submissions: 18379 Points: 2

Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find the number of distinct combinations to reach the given score.

Input:
The first line of input contains an integer T denoting the number of test cases. T test cases follow. The first line of each test case is n.

Output:
For each testcase, in a new line, print the number of ways/combinations to reach the given score.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ T ≤ 100
1 ≤ n ≤ 1000

Example:
Input:
3
8
20
13

Output:
1
4
2

Explanation
For 1st example when n = 8
{ 3, 5 } and {5, 3} are the two possible permutations but these represent the same cobmination. Hence output is 1.

*/
public class ReachAGivenScore {
    public int [] reachScores(int [] nums) {
        int [] ans = new int[nums.length];
        int k = 0;
        for(int n : nums) {
            int [] dp = new int [n+1];
            dp[0] =1;
            for(int i = 3; i<n+1; i++) dp[i] += dp[i-3];
            for(int i = 5; i<n+1; i++) dp[i] += dp[i-5];
            for(int i = 10; i<n+1; i++) dp[i] += dp[i-10];
            for(int i: dp) System.out.print(i+" ");
            System.out.println("");
            ans[k] = dp[n];
            k++;
        }
        return ans;
    }

    public static void main(String...s) {
        ReachAGivenScore test = new ReachAGivenScore();
        int [] ans = test.reachScores(new int [] {8,20,13});
        for(int i: ans) System.out.print(i+" ");
    }
}
