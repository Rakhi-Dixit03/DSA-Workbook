package dynamicProgramming;

//TC-O(N*M)
//SC-O(M)

public class Num_Of_ZigZag_Arrays_1 {

    private static final int MOD = 1000000007;

    public static int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        int[] dp = new int[m];
        java.util.Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            if ((i & 1) == 0)
                for (int j = 0; j < m; j++) {
                    int t = dp[j];
                    dp[j] = sum;
                    sum = (sum + t) % MOD;
                }
            else
                for (int j = m - 1; j >= 0; j--) {
                    int t = dp[j];
                    dp[j] = sum;
                    sum = (sum + t) % MOD;
                }
        }

        int res = 0;
        for (int j = 0; j < m; j++)
            res = (res + dp[j]) % MOD;

        return (res << 1) % MOD;
    }

    public static void main(String[] args) {

        System.out.println("Number of ZigZag Arrays : "+zigZagArrays(3,4,6));
    }
}


