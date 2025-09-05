package dynamicProgramming;

//Rod Cutting a Variation of Unbounded Knapsack

public class Question7 {

    public static void main(String[] args) {
        int[] length={1,2,3,4,5,6,7,8};
        int[] price={1,5,8,9,10,17,17,20};
        int rodLen=8;

        System.out.println("Maximum Price one can get after cutting rodes into pieces and selling is : "+rodCutting(length,price,rodLen));
        System.out.println("Maximum Price one can get through optimized approach  : "+rodCuttingOptimized(length,price,rodLen));
    }

    //Tabulation Solution TC-O(n*rodLength) SC-O(n*rodLength)

    private static int rodCutting(int[] length,int[] price,int totLen){

        int n=price.length;
        //Creating DP
        int[][] dp=new int[n+1][totLen+1];

        // i=> is no. of pieces we can use
        //j=> is length of the rod

        //Initialising it
        //When totLen allowed is 0 and when we have 0 pieces
        for(int i=0;i<=n;i++){
            for(int j=0;j<=totLen;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

       //Filling from bottom to up
        for(int i=1;i<=n;i++){
            for(int j=1;j<=totLen;j++){

                if(length[i-1] <= j){// j is current length of the rod
                    //Valid case
                    dp[i][j]=Math.max(price[i-1] + dp[i][j-length[i-1]] , dp[i-1][j]);


                }else{
                    //Invalid
                    //Exclusion
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        return dp[n][totLen];

    }


    //Space Optimised Approach SC-O(rodLength)

    private static int rodCuttingOptimized(int[] length,int[] price,int totLen){

        int n=length.length;
        int[] dp= new int[totLen+1];

        dp[0]=0;

        for(int i=0;i<n;i++){
            //Going in increasing order
            for(int j=length[i];j<=totLen;j++){

                dp[j]=Math.max(dp[j],price[i]+dp[j-length[i]]);

            }
        }
        return dp[totLen];
    }

}
