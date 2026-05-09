package matrix;

import java.util.*;

//TC-O(M*N)
//SC-(M+N)
public class Cyclically_Rotating_Grid {


    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m / 2, n / 2);

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> nums = new ArrayList<>();
            int top = layer;
            int bottom = m - 1 - layer;

            int left = layer;
            int right = n - 1 - layer;

            //Top Row

            for (int j = left; j <= right; j++) {

                nums.add(grid[top][j]);

            }

            //Right Column

            for (int i = top + 1; i < bottom; i++) {
                nums.add(grid[i][right]);
            }

            //Bottom Row

            for (int j = right; j >= left; j--) {

                nums.add(grid[bottom][j]);

            }

            //left Column

            for (int i = bottom - 1; i > top; i--) {
                nums.add(grid[i][left]);
            }

            int rot = k % nums.size();
            //Rotate list By K positions

            Collections.rotate(nums, -rot);//Left rotation

            //Inserting back the rotated list in the grid

            int idx = 0;
            //Top Row

            for (int j = left; j <= right; j++) {

                grid[top][j] = nums.get(idx);
                idx++;

            }

            //Right Column

            for (int i = top + 1; i < bottom; i++) {
                grid[i][right] = nums.get(idx);
                idx++;
            }

            //Bottom Row

            for (int j = right; j >= left; j--) {

                grid[bottom][j] = nums.get(idx);
                idx++;

            }

            //left Column

            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = nums.get(idx);
                idx++;
            }

        }

        return grid;

    }



}
