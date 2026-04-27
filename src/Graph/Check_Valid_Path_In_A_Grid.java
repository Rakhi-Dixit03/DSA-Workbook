package Graph;

import java.util.*;

public class Check_Valid_Path_In_A_Grid {
    //Using DFS
   //TC-O(M*N)

    int m, n;
    Map<Integer, int[][]> directions = new HashMap<>();

    public Check_Valid_Path_In_A_Grid() {

        directions.put(1, new int[][]{{0, -1}, {0, 1}});
        directions.put(2, new int[][]{{1, 0}, {-1, 0}});
        directions.put(3, new int[][]{{0, -1}, {1, 0}});
        directions.put(4, new int[][]{{0, 1}, {1, 0}});
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});
        directions.put(6, new int[][]{{0, 1}, {-1, 0}});

    }

    public boolean hasValidPath(int[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        return dfs(0, 0, vis, grid);

    }

    boolean dfs(int i, int j, boolean[][] vis, int[][] grid) {

        if (i == m - 1 && j == n - 1) {
            return true;
        }

        vis[i][j] = true;//mark curr cell visited

        for (int[] dir : directions.get(grid[i][j])) {// this is  telling us where we can move

            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (new_i < 0 || new_i > m - 1 || new_j < 0 || new_j > n - 1 || vis[new_i][new_j]) {
                continue;//skip this invalid case
            }

            //check if new cell connects back to the curr cell or not

            for (int[] backDir : directions.get(grid[new_i][new_j])) {

                if (new_i + backDir[0] == i && new_j + backDir[1] == j) {

                    if (dfs(new_i, new_j, vis, grid)) {
                        return true;
                    }

                }

            }

        }

        return false;
    }

    public static void main(String[] args) {

        int[][] grid = {{2,4,3},{6,5,2}};
        Check_Valid_Path_In_A_Grid obj = new Check_Valid_Path_In_A_Grid();

        System.out.println("Does a valid path exists : "+obj.hasValidPath(grid));
    }
}
