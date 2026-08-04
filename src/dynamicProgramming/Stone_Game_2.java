package dynamicProgramming;

public class Stone_Game_2 {

    int n;
    int[][][] memo;

    int solve(int person, int i, int M, int[] nums) {

        if (i >= n)
            return 0;

        if (memo[person][i][M] != -1)
            return memo[person][i][M];

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int score = 0;

        for (int x = 1; x <= Math.min(n - i, 2 * M); x++) {
            score += nums[i + x - 1];

            if (person == 1) {//Alice

                result = Math.max(result, score + solve(0, i + x, Math.max(x, M), nums));

            } else {//Bob

                result = Math.min(result, solve(1, i + x, Math.max(x, M), nums));

            }

        }

        return memo[person][i][M] = result;

    }

    public int stoneGameII(int[] piles) {

        n = piles.length;
        memo = new int[2][n + 1][n + 1];

        for (int[][] twoD : memo) {

            for (int[] row : twoD) {
                java.util.Arrays.fill(row, -1);
            }

        }

        return solve(1, 0, 1, piles);

    }

    public static void main(String[] args) {
        Stone_Game_2 obj = new Stone_Game_2();
        System.out.println("Alice's Score : "+obj.stoneGameII(new int[]{1,2,3,7}));
    }

}
