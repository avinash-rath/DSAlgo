package machine_coding.game_2048;

import java.util.ArrayList;

public class Grid {
    private int baseNumber;
    private int gridDimensionX;
    private int gridDimensionY;
    private int [][] grid;
    private ArrayList<int[]> emptySpots;
    private int winNumber;
    private boolean isWinNumberAchieved;

    public Grid(int gridDimensionX, int gridDimensionY, int winNumber, int baseNumber) {
        this.baseNumber = baseNumber;
        this.gridDimensionX = gridDimensionX;
        this.gridDimensionY = gridDimensionY;
        this.winNumber = winNumber;
        this.grid = new int[gridDimensionX][gridDimensionY];
        this.emptySpots = new ArrayList<>();
        for(int i = 0; i < gridDimensionX; i++)
            for(int j = 0; j < gridDimensionY; j++) {
                emptySpots.add(new int[] {i, j});
            }
        this.isWinNumberAchieved = false;
    }

    public int getBaseNumber() {
        return baseNumber;
    }

    public int getGridDimensionX() { 
        return gridDimensionX ;
    }

    public int getGridDimensionY() {
        return gridDimensionY;
    }

    public ArrayList<int[]> getEmptySpots() {
        return emptySpots;
    }

    public int[][] getGrid() {
        return grid.clone();
    }

    public boolean getIsWinNumberAchieved() {
        return isWinNumberAchieved;
    }

    public boolean isPlayable() {
        boolean isPlayable = false;
        for(int i = 0; i < gridDimensionX - 1; i++) {
            if(isPlayable) break;
            for(int j = 0; j < gridDimensionY - 1; j++) {
                if(grid[i][j] == grid[i+1][j] || grid[i][j] == grid[i][j+1]) { 
                    isPlayable = true;
                    break;
                }
            }
        }
        return isPlayable;
    }

    public void changeState(int[][] newGrid) {
        if(newGrid.length != gridDimensionX || newGrid[0].length != gridDimensionY) {
            System.out.println("ERROR: New grid provided doesn't have the same dimensions as the one in the grid.");
            return;
        }
        emptySpots = new ArrayList<>();
        for(int i = 0; i < gridDimensionX; i++) {
            for(int j = 0; j < gridDimensionY; j++) {
                grid[i][j] = newGrid[i][j];
                if(grid[i][j] == winNumber) {
                    isWinNumberAchieved = true;
                }
                if(grid[i][j] == 0) {
                    // it's an empty spot
                    emptySpots.add(new int[] {i, j});
                }
            }
        }
    }

    public void insertNumAtPos(int x, int y, int num) {
        grid[x][y] = num;
        emptySpots.remove(new int[]{x, y});
    }

    @Override
    public String toString() {
        // shows the current state of the grid in string format.
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                str.append(grid[i][j] > 0 ? grid[i][j] : "_");
                str.append("\t");
            }
            str.append("\n");
        }
        return str.toString();

    }
}
