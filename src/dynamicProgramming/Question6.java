package dynamicProgramming;

import java.util.Arrays;

//Coin change Problem
public class Question6 {

    public static void main(String[] args) {

        int[] coins={2,5,3,6};
        int change=10;

        System.out.println("Total ways to make a change are : "+coinChange(coins,change));
        System.out.println("Total ways to make a change using optimized approach  are : "+coinChangeOptimized(coins,change));
        System.out.println("Minimum coins required to make a change : "+coinChangeMin(coins,change));
    }


    //Through Tabulation TC-O(N*change) N is number of coins
    //SC-O(N*change)
    private static int coinChange(int[] coins,int change ){
        int n=coins.length;
       //Creating dp Array

         int[][] dp=new int[n+1][change+1];

         //Meaning of dp[i][j] - i-coins,j-change value (i,j) stores ways to make a change j with i coins
         //Initialising

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        //Bottom-up filling

        for(int i=1;i<=n;i++) {

            for (int j = 1; j <= change; j++) {

                if (coins[i - 1] <= j) {
                    //include and exclude both cases ways
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];

                } else {
                    // exclude
                    dp[i][j] = dp[i - 1][j];

                }

            }
        }
        return dp[n][change];
    }


    //Optimized one
    //SC-O(change)

    private static int coinChangeOptimized(int[] coins,int change ){

        int[] dp=new int[change+1];
        dp[0]=1;//one way to make change 0 means choose  nothing

        //As this is variation of Unbounded knapsack we will run an ascending loop to allow repetition of coins

        for(int coin : coins){
            for(int s=coin;s<=change;s++){

                dp[s]=dp[s]+dp[s-coin];

            }
        }

        return dp[change];
    }

    //Variation of Coin Change - Minimum coins required to make a change

    private static int coinChangeMin(int[] coins,int change){
        int INF=1_000_000;//Largest value to initialise dp
        int[] dp=new int[change+1];

        Arrays.fill(dp,INF);

        dp[0]=0;

        for(int coin:coins){
            for(int s=coin;s<=change;s++){

                dp[s]=Math.min(dp[s],1+dp[s-coin]);
            }

        }
        return dp[change]==INF ? -1 : dp[change];
    }

}


