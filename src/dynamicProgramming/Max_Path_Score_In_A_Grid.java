package dynamicProgramming;

//TC- O(M*N*K)
//SC - O(M*N*N)

public class Max_Path_Score_In_A_Grid {

    int m, n;
    int[][][] t;

    public int solve(int i, int j, int cost, int k, int[][] grid) {

        if (i >= m || i < 0 || j >= n || j < 0) {
            return Integer.MIN_VALUE;
        }

        int newCost = cost + (grid[i][j] == 0 ? 0 : 1);
        if (newCost > k) {
            return Integer.MIN_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (t[i][j][cost] != -1) {
            return t[i][j][cost];
        }

        int right = solve(i, j + 1, newCost, k, grid);
        int down = solve(i + 1, j, newCost, k, grid);

        int bestScore = Math.max(right, down);

        if (bestScore == Integer.MIN_VALUE) {
            return t[i][j][cost] = Integer.MIN_VALUE;
        }

        return t[i][j][cost] = grid[i][j] + bestScore;

    }

    public int maxPathScore(int[][] grid, int k) {

        this.m = grid.length;
        this.n = grid[0].length;
        t = new int[m + 1][n + 1][k + 1];

        for (int[][] mat : t) {
            for (int[] row : mat) {
                java.util.Arrays.fill(row, -1);
            }
        }

        int score = solve(0, 0, 0, k, grid);

        return score == Integer.MIN_VALUE ? -1 : score;
    }


    public static void main(String[] args) {

        int[][] grid = {{0, 1},{2,0}};
        Max_Path_Score_In_A_Grid obj = new Max_Path_Score_In_A_Grid();

        System.out.println("Maximum Path Score in a Grid : "+obj.maxPathScore(grid,1));
    }

}

//Bottom-Up DP Approach is left