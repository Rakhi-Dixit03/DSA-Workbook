package matrix;

import java.util.*;
import java.util.stream.Collectors;

//TC-O(size)
public class Rotate_2D_Grid {

    int n, m, size;

    void reverse(int[][] grid, int i, int j) {

        while (i < j) {

            int temp = grid[i / n][i % n];
            grid[i / n][i % n] = grid[j / n][j % n];
            grid[j / n][j % n] = temp;
            i++;
            j--;

        }

    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        m = grid.length;
        n = grid[0].length;
        size = m * n;
        k = k % size;

        reverse(grid, 0, size - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, size - 1);

        return Arrays.stream(grid)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());

    }



}
