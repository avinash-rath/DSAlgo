'''
200. Number of Islands
Medium

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

'''

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) <1:
            return 0
        islands = 0
        rows,cols = len(grid),len(grid[0])
        def dfs(row,col):
            if row>=0 and (row<rows) and col>=0 and (col<cols) and (grid[row][col] == '1'):
                grid[row][col] = '2'
                dfs(row+1,col)
                dfs(row-1,col)
                dfs(row,col+1)
                dfs(row,col-1)
        for r in range(rows):
            for c in range(cols):
                cell = grid[r][c]
                if cell == '1':
                    print("row=",r,"col",c)
                    islands+=1
                    dfs(r,c)
                else : 
                    continue
        for i in grid:
            print(i)
        return islands
       
