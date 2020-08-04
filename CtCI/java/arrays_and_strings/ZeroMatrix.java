package arrays_and_strings;

import java.util.*;

/**
 * 1.8 Zero Matrix
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * it's entire row and column are set to 0.
 */

public class ZeroMatrix {
    public void makeZero(int [][] grid) {
        List<int[]> zeroes = new ArrayList<int[]>();
        for(int i =0; i<grid.length; i++){
            for(int j = 0; j< grid.length; j++) {
                if(grid[i][j] == 0){
                    zeroes.add(new int[]{i,j});
                }
            }
        }
        for(int[] coord: zeroes) {
            int x=coord[0], y = coord[1];
            for(int i=0; i<grid.length; i++ ) grid[i][y] = 0;
            for(int j=0; j<grid[0].length; j++ ) grid[x][j] = 0;
        }
    }
}