package dynamicProgramming;

// 0/1 Knapsack Problem

import java.util.Arrays;

public class Question3 {

    public static void main(String[] args) {

        int[] val={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        int W=7;
        int n=val.length;

        int[][] dp=new int[n+1][W+1];


        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        System.out.println("Maximum Profit through recursive solution : "+knapsackRecursive(val,wt,W,n));
        System.out.println("Maximum Profit through memoization solution : "+knapsackMemo(val,wt,W,n,dp));
        System.out.println("Maximum Profit through tabulation solution : "+knapsackTab(val,wt,W));
        System.out.println("Maximum Profit through tabulation Optimized solution : "+knapsackOptimized(val,wt,W));

    }

    //Through Recursion
    // W there is Capacity of Bag
    private static int knapsackRecursive(int[] val, int[] wt, int W, int n){

        //Base Case

        if(W==0 || n==0)return 0;

        //Valid Case
        if(wt[n-1]<=W){

            //Case1: Include the item

            int include=val[n-1]+knapsackRecursive(val,wt,W-wt[n-1],n-1);

            //Case2: Exclude the item

            int exclude=knapsackRecursive(val,wt,W,n-1);

            return Math.max(include,exclude);//This is going to be the maximum profit


        }else{
            //Invalid Case

            return knapsackRecursive(val,wt,W,n-1);

        }

    }



    //Through Memoization
    private static int knapsackMemo(int[] val,int[] wt,int W,int n,int[][] dp){

       // Memoization = Recursion + Storage

        //Base Case
        if(W==0 || n==0)return 0;

        //Check if we have already calculated the value

       // dp[n][W] means maxProfit we can get by using n items with a bag of capacity W

        if(dp[n][W]!=-1)return dp[n][W];

        //Valid Case
        if(wt[n-1]<=W){
            //Case 1 : Inclusion

            int include=val[n-1]+knapsackMemo(val, wt, W-wt[n-1], n-1, dp);

            //Case 2 : Exclusion

            int exclude=knapsackMemo(val, wt, W, n-1, dp);

            dp[n][W]=Math.max(include,exclude);

            return dp[n][W];

        }else{
            //Invalid Case
            dp[n][W]=knapsackMemo(val,wt,W,n-1,dp);
            return dp[n][W];


        }

    }


    //Through Tabulation

    private static int knapsackTab(int[] val,int[] wt,int W){

        int n=val.length;
        //Create a Table

        int[][] dp=new int[n+1][W+1];

        //Initialising dp

        //Meaning of dp[i][j] : Maximum profit we can get by using first i items and a bag of capacity j

        // Making 1st column 0 as with 0 items we cannot get any profit
        for(int i=0;i<=n;i++){

            dp[i][0]=0;
        }
        // Making 1st row 0 as with 0 Capacity of bag  we cannot store any item

        for(int j=0;j<=W;j++){

            dp[0][j]=0;
        }

       //Filling dp from bottom to up

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){

                //Valid Case
                if(wt[i-1]<=j){

                    //Include

                   int  include =val[i-1]+dp[i-1][j-wt[i-1]];

                   //Exclude
                   int exclude=dp[i-1][j];

                   dp[i][j]=Math.max(include,exclude);

                }else{
                    //Invalid Case
                    dp[i][j]=dp[i-1][j];

                }

            }
        }

        return dp[n][W];
    }



    private static int knapsackOptimized(int[] val,int[] wt,int W){

        int n=val.length;

        int[] dp=new int[W+1];

        dp[0]=0;

        for(int i=0;i<n;i++){

            //Decreasing loop to avoid taking same item multiple times
            for(int s= W;s>=wt[i];s--){

                dp[s]=Math.max(dp[s],val[i]+dp[s-wt[i]]);

            }

        }
        return dp[W];
    }

}