package dynamicProgramming;

public class Predict_The_Winner {

    public boolean predictTheWinner(int[] A) {
        int n = A.length;
        if ((n & 1) == 0) return true;

        int[][] dp = new int[n][n];
        for (int[] r : dp)
            java.util.Arrays.fill(r, -1);

        return maxDiff(0, n - 1, A, dp) >= 0;
    }

    private int maxDiff(int i, int j, int[] A, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == j) return dp[i][j] = A[i];

        return dp[i][j] = Math.max(A[i] - maxDiff(i + 1, j, A, dp), A[j] - maxDiff(i, j - 1, A, dp));
    }


    public static void main(String[] args) {
        Predict_The_Winner obj = new Predict_The_Winner();
        System.out.println("First Player is the  Winner : "+obj.predictTheWinner(new int[]{1,5,2}));
    }
}
