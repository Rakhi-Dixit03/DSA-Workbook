package dynamicProgramming;

//Problem Number 877
//Topics : Game Theory, DP,Maths
//TC-O(N^2)
//SC-O(N^2)
public class Stone_Game {

    int[][] memo;

    int solve(int i, int j, int[] piles) {//solve(i,j) reps. max Score diff current player can have over the opponent

        if (i == j) {
            return piles[i];
        }

        if (memo[i][j] != -1)
            return memo[i][j];

        int take_i = piles[i] - solve(i + 1, j, piles);
        int take_j = piles[j] - solve(i, j - 1, piles);

        return memo[i][j] = Math.max(take_i, take_j);

    }

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        memo = new int[n + 1][n + 1];

        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(0, n - 1, piles) > 0;

    }

    public static void main(String[] args) {
        Stone_Game obj = new Stone_Game();

        System.out.println("Does Alice Win ?  " + obj.stoneGame(new int[]{5, 3, 4, 5}));
        System.out.println("Does Alice Win ?  " + obj.stoneGame2(new int[]{5, 3, 4, 5}));
    }


    public boolean stoneGame2(int[] piles) {
        return true;//Due to Mathematical Reasoning
    }

}
