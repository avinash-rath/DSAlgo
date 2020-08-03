/**
 * 1.7
 * Given an image represented by an NxN matrix, where each pixel in 
 * the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 */

public class RotateMatrix {
    public boolean rotate(int[][] grid) {
        // corner case : if the grid is not square
        if(grid.length == 0 || grid.length != grid[0].length) return false;

        for(int layer = 0; layer < grid.length; layer ++) {
            int first = layer;
            int last = grid.length - layer - 1;
            for(int i = first; i<last; i++) {
                int top = grid[first][i]; // saving the top left element
                int offset = i - first;
                // left to top 
                grid[first][i] = grid[last-offset][first];
                // bottom to left
                grid [last-offset][first] = grid[last][last-offset];
                // right to bottom
                grid[last][last-offset] = grid[i][last];

                // top to right
                grid[i][last] = top;

            }
        }
        return true;
    }
}