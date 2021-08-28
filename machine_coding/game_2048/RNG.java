package machine_coding.game_2048;

import java.util.ArrayList;
import java.util.Random;

// Random Number Generator
public class RNG {
    public static int[] generateNumberInEmptySpot(ArrayList<int[]> emptySpots, int baseNumber) {
        // follows a format [x,y,number]
        int[] num = new int[3];
        Random random = new Random();
        int randIdx = random.nextInt(emptySpots.size());
        num[0] = emptySpots.get(randIdx)[0];
        num[1] = emptySpots.get(randIdx)[1];
        int randNum = (int)(Math.pow(baseNumber, random.nextInt(2)+1));
        num[2] = randNum;
        return num;
    }

    public static void insertNumberAtEmptySpot(Grid grid) {
        if(grid.getEmptySpots().size() == 0) return;
        int[] num  = generateNumberInEmptySpot(grid.getEmptySpots(), grid.getBaseNumber());
        grid.insertNumAtPos(num[0], num[1], num[2]);
    }

    public static void insertInitialNumbers(Grid grid) {
        int [] num = generateNumberInEmptySpot(grid.getEmptySpots(), grid.getBaseNumber());
        int [][] newGrid = grid.getGrid();
        newGrid[num[0]][num[1]] = num[2];
        ArrayList<int[]> emptySpots = grid.getEmptySpots();
        emptySpots.remove(new int[]{num[0],num[1]});
        num = generateNumberInEmptySpot(grid.getEmptySpots(), grid.getBaseNumber());
        newGrid[num[0]][num[1]] = num[2];
        grid.changeState(newGrid);
    }

    // public static void main(String...s) {
    //     Grid grid = new Grid(4, 4, 2048, 2);
    //     insertInitialNumbers(grid);
    //     System.out.println(grid.toString());
    //     insertNumber(grid);
    //     insertNumber(grid);
    //     insertNumber(grid);
    //     insertNumber(grid);
    //     insertNumber(grid);
    //     System.out.println(grid.toString());
    // }
}
