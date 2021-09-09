package leetcode.java;

import java.util.Arrays;

public class LargestPlusSign {
    //optimized
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int [][] dp = new int[n][n];
        int ans = 0;
        
        // n, because we consider the largest possible plus is of order n
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], n); 
        
        for(int [] mine: mines) dp[mine[0]][mine[1]] = 0;
        
        for(int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1, l = 0, u = 0, r = 0, d = 0; j < n && k >= 0; j++, k--) {
                dp[i][j] = Math.min(dp[i][j], l = (dp[i][j] == 0 ? 0 : l + 1));
                dp[j][i] = Math.min(dp[j][i], u = (dp[j][i] == 0 ? 0 : u + 1));
                dp[i][k] = Math.min(dp[i][k], r = (dp[i][k] == 0 ? 0 : r + 1));
                dp[k][i] = Math.min(dp[k][i], d = (dp[k][i] == 0 ? 0 : d + 1));
            }
        }
        for(int[] row: dp) {
            for(int k : row) {
                // System.out.print(k+" ");
                ans = Math.max(ans,k);
            }
            // System.out.println("");
        }
        return ans;
    }
    
    
    // dp, but inefficient. Don't need to store all the left, right, up and, down values.
    // public int orderOfLargestPlusSign(int n, int[][] mines) {
    //     int [][][] dp = new int[n][n][4];
    //     int grid[][] = new int[n][n];
    //     for(int[] row: grid) 
    //         Arrays.fill(row, 1);
    //     for(int [] mine : mines) {
    //         grid[mine[0]][mine[1]] = 0;
    //     }
    //     int ans = 0;
    //     // for dp. 
    //     // 0 - up
    //     // 1 - left
    //     // 2 - right
    //     // 3 - down
        
    //     for(int i = 0; i < n; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if(grid[i][j] == 0) continue;
    //             if(j > 0)
    //                 dp[i][j][0] += grid[i][j] + dp[i][j-1][0];
    //             else
    //                 dp[i][j][0] += grid[i][j];
    //             if(i > 0)
    //                 dp[i][j][1] += grid[i][j] + dp[i-1][j][1]; 
    //             else
    //                 dp[i][j][1] += grid[i][j];
    //         }
    //     }
        
    //     for(int i = n-1; i >= 0; i--) {
    //         for(int j = n-1; j>= 0; j--) {
    //             if(grid[i][j] == 0) continue;
    //             if(j < n-1)
    //                 dp[i][j][2] += grid[i][j] + dp[i][j+1][2];
    //             else
    //                 dp[i][j][2] += grid[i][j];
    //             if(i < n-1)
    //                 dp[i][j][3] += grid[i][j] + dp[i+1][j][3];
    //             else
    //                 dp[i][j][3] += grid[i][j];
    //         }
    //     }
        
    //     for(int i = 0; i < n; i++) {
    //         for(int j = 0; j < n; j++) {
    //             // System.out.print(Arrays.toString(dp[i][j]));
    //             // System.out.print(" ");
    //             int cur = Arrays.stream(dp[i][j]).min().getAsInt();
    //             ans = Math.max(ans,cur);
    //         }
    //         // System.out.println("");
    //     }
    //     return ans;
    // }
}
