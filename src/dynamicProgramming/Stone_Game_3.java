package dynamicProgramming;

public class Stone_Game_3 {

    public static String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = Integer.MIN_VALUE;
            int sum = 0;

            for (int j = i; j < Math.min(n, i + 3); j++) {

                sum += stoneValue[j];

                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }

    public static void main(String[] args) {
        System.out.println("Winner : "+stoneGameIII(new int[]{1,2,3,7}));
    }

}
