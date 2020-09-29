/*
200. Number of Islands
Medium

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Accepted
822,287
Submissions
1,738,553
*/

class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void dfs(int i, int j, char [][] grid) {
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length-1) {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j-1,grid);
            dfs(i,j+1,grid);
        }
        
    }
}
