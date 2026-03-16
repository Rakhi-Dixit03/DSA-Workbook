package matrix;

import java.util.*;
public class Rhombus_Sum_In_Grid {

    // TC - O(M∗N∗min(M,N))
    public static int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]);

                if (set.size() > 3) {
                    set.pollFirst();
                }

                for (int s = 1; r - s >= 0 && r + s < m && c - s >= 0 && c + s < n; s++) {
                    int sum = 0;

                    for (int k = 0; k <= s - 1; k++) {

                        sum += grid[r - s + k][c + k]; // top -> right
                        sum += grid[r + k][c + s - k]; // right -> bottom
                        sum += grid[r + s - k][c - k]; // bottom -> left
                        sum += grid[r - k][c - s + k];// left -> top

                    }

                    set.add(sum);
                    if (set.size() > 3) {

                        set.pollFirst();

                    }

                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort((a, b) -> b - a);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
