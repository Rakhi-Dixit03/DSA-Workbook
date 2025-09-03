package dynamicProgramming;

import java.util.Arrays;

public class Question5 {

    public static void main(String[] args) {
        int[] val={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        int W=7;//Capacity of bag
        int n=val.length;

        int[][] memo=new int[n+1][W+1];

        //Initialising memo Table
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }


        System.out.println("Through Tabulation Maximum Profit is : "+unboundKnapSack(val,wt,W));
        System.out.println("Through Memoization Maximum Profit is : "+unboundMemo(val,wt,W,memo,n));

    }

    private static int unboundKnapSack(int[] val,int[] wt,int W){

        int n=val.length;
        //Creating DP Array
        int[][] dp=new int[n+1][W+1];

        //Initialising

        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }

        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }

        //Filling DP from bottom to up

        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){

                int w=wt[i-1];
                int v=val[i-1];

                if(w<=j){
                    //Inclusion
                    dp[i][j]=Math.max(v+dp[i][j-w],dp[i-1][j]);

                }else{
                    //Exclusion
                    dp[i][j]=dp[i-1][j];

                }
            }
        }

        return dp[n][W];
    }


    //Through Memoization

    private static int unboundMemo(int[] val,int[] wt,int W,int[][] memo,int n){

        //Base Case
        if(n==0 || W==0)return 0;

        if(memo[n][W]!=-1)return memo[n][W];

        int w=wt[n-1];

        if(w <= W){
            //Inclusion
            int include=val[n-1]+unboundMemo(val, wt, W-w, memo, n);
            //Exclude
            int exclude=unboundMemo(val, wt, W, memo, n-1);

           return  memo[n][W]=Math.max(include,exclude);

        }else{

            //Exclude
            int exclude=unboundMemo(val, wt, W, memo, n-1);
           return  memo[n][W]=exclude;
        }

    }

}
