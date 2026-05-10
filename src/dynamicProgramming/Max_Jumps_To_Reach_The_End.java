package dynamicProgramming;

//Using bottom-up dynamic programming to find the maximum number of valid jumps
// by checking all previous reachable indices.
//2770
//TC-O(N)
public class Max_Jumps_To_Reach_The_End {


    public static int maximumJumps(int[] arr, int target) {

        //Bottom-Up DP Approach
        int n = arr.length;
        int[] dp = new int[n];

        java.util.Arrays.fill(dp, Integer.MIN_VALUE);


        dp[0] = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {

                if (Math.abs(arr[j] - arr[i]) <= target && dp[i] != Integer.MIN_VALUE) {

                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1] == Integer.MIN_VALUE ? -1 : dp[n - 1];


    }


    public static void main(String[] args) {

        System.out.println("Maximum Jumps to reach the end of the Array : "+maximumJumps(new int[]{1,3,6,4,1,2},2));
    }
}
