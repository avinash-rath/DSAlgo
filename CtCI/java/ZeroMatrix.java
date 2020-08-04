import java.util.*;

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