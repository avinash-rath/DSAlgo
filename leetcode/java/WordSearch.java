/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 

Constraints: 

    board and word consists only of lowercase and uppercase English letters.
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3


*/

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && search(visited, word, 0, board,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(boolean [][] visited, String word, int idx, char [][] board, int i, int j) {
        if((i > board.length-1) || (i<0) || (j < 0) || (j > board[0].length - 1)) {
            return false;
        }
        // System.out.println(word.charAt(idx)+" "+board[i][j]+" "+ i+" "+ j);
        if(!visited[i][j] && board[i][j] == word.charAt(idx)) {
            visited[i][j] = true;
            if(idx == word.length() -1) {
                return true;
            }
            idx ++;
            boolean b = search(visited, word, idx, board, i+1,j) || search(visited, word, idx, board, i-1,j) || search(visited, word, idx, board, i,j+1) || search(visited, word, idx, board, i,j-1);
            visited[i][j] = false;
            return b;
        }
        return false;
    }
}