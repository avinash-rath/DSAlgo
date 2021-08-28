package machine_coding.game_2048;

import java.util.ArrayList;
import java.util.Collections;

public class Moves {

    private ArrayList<Integer> mergeTiles(ArrayList<Integer> tilesToMerge, int reqdArrayLength) {
        ArrayList<Integer> mergedTiles = new ArrayList<>();
        int j = 0;
        while(j < tilesToMerge.size()) {
            if(j < tilesToMerge.size()-1 && tilesToMerge.get(j) == tilesToMerge.get(j+1)) {
                mergedTiles.add(tilesToMerge.get(j) + tilesToMerge.get(j+1));
                j += 2;
            } else {
                mergedTiles.add(tilesToMerge.get(j));
                j++;
            }
        }
        int zeroesToAdd = reqdArrayLength - mergedTiles.size();
        while(zeroesToAdd-- > 0) {
            mergedTiles.add(0);
        }
        return mergedTiles;
    }

    public void left(Grid gridObj) {
        int [][] grid= gridObj.getGrid();
        for(int i = 0; i < gridObj.getGridDimensionX(); i++) {
            ArrayList<Integer> nonZeroNums = new ArrayList<>();
            for(int j : grid[i]) {
                if(j != 0) nonZeroNums.add(j);
            } 
            if(nonZeroNums.size() == 0) continue;
            grid[i] = mergeTiles(nonZeroNums, grid[i].length)
                        .stream()
                        .mapToInt(Integer::intValue)
                        .toArray();            
        }
        gridObj.changeState(grid);
    }

    public void right(Grid gridObj) {
        int [][] grid= gridObj.getGrid();
        for(int i = 0; i < gridObj.getGridDimensionX(); i++) {
            ArrayList<Integer> nonZeroNums = new ArrayList<>();
            for(int j : grid[i]) {
                if(j != 0) nonZeroNums.add(j);
            } 
            if(nonZeroNums.size() == 0) continue;
            Collections.reverse(nonZeroNums);
            ArrayList<Integer> merged = mergeTiles(nonZeroNums, grid[i].length);
            Collections.reverse(merged);
            grid[i] = merged.stream().mapToInt(Integer::intValue).toArray();       
        }
        gridObj.changeState(grid);
    }
    
    public void top(Grid gridObj) {
        int [][] grid = gridObj.getGrid();
        for(int j = 0; j < gridObj.getGridDimensionY(); j++) {
            ArrayList<Integer> nonZeroNums = new ArrayList<>();
            for(int i = 0; i < gridObj.getGridDimensionX(); i++) {
                if(grid[i][j] != 0) nonZeroNums.add(grid[i][j]);
            }
            if(nonZeroNums.size() == 0) continue;
            ArrayList<Integer> merged = mergeTiles(nonZeroNums, gridObj.getGridDimensionX());
            for(int i = 0; i < gridObj.getGridDimensionX(); i++) {
                grid[i][j] = merged.get(i);
            }
        }
        gridObj.changeState(grid);
    }

    public void bottom(Grid gridObj) {
        int [][] grid = gridObj.getGrid();
        for(int j = 0; j < gridObj.getGridDimensionY(); j++) {
            ArrayList<Integer> nonZeroNums = new ArrayList<>();
            for(int i = 0; i < gridObj.getGridDimensionX(); i++) {
                if(grid[i][j] != 0) nonZeroNums.add(grid[i][j]);
            }
            if(nonZeroNums.size() == 0) continue;
            Collections.reverse(nonZeroNums);
            ArrayList<Integer> merged = mergeTiles(nonZeroNums, gridObj.getGridDimensionX());
            Collections.reverse(merged);
            for(int i = 0; i < gridObj.getGridDimensionX(); i++) {
                grid[i][j] = merged.get(i);
            }
        }
        gridObj.changeState(grid);
    }

    // TODO: maybe later
    // coordinate system,
    // if 0, (0,-1)
    // if 1, (0,1)
    // if 2, (-1,0)
    // if 3, (1,0)
}
