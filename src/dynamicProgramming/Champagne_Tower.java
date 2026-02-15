package dynamicProgramming;

public class Champagne_Tower {

    double[][] memo;

    private double solve(int poured, int i, int j) {

        if (i < 0 || j < 0) return 0.0;

        if (i == 0 && j == 0) return poured;//Base Case
        if (memo[i][j] != -1) return memo[i][j];

        double left_contrib = Math.max(0.0, (solve(poured, i - 1, j - 1) - 1) / 2.0);
        double right_contrib = Math.max(0.0, (solve(poured, i - 1, j) - 1) / 2.0);

        return memo[i][j] = left_contrib + right_contrib;

    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        memo = new double[101][101];
        for (double[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        return Math.min(1.0, solve(poured, query_row, query_glass));
    }



    //Bottom-Up

    double[][] dp;

    public double champagneTower2(int poured, int query_row, int query_glass) {
        dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;

        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {

                double leftPar = 0.0;
                double rightPar = 0.0;

                if (j - 1 >= 0) {
                    leftPar = Math.max(0, (dp[i - 1][j - 1] - 1) / 2.0);
                }

                if (j < i) {
                    rightPar = Math.max(0, (dp[i - 1][j] - 1) / 2.0);

                }

                dp[i][j] = leftPar + rightPar;


            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
