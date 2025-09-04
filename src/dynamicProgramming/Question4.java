package dynamicProgramming;

//Target Sum Subset

import java.util.Arrays;

public class Question4 {

    public static void main(String[] args) {
       int[] nums={4,2,7,1,3};
       int targetSum=18;
       int n=nums.length;
       Boolean[][] memo=new Boolean[n+1][targetSum+1];

        System.out.println("Target Sum through Tabulation : "+targetsumTab(nums,targetSum));
        System.out.println("Target Sum through Memoization : "+targetsumMemo(nums,targetSum,memo,n));
        System.out.println("Target Sum through Tabulation Optimized one  : "+targetSumOptimized(nums,targetSum));
    }


    //Tabulation TC-O(N*TargetSum)

    private static boolean targetsumTab(int[] nums,int targetSum){
        int n=nums.length;
        //Create dp Array
        boolean[][] dp=new boolean[n+1][targetSum+1];


        //Meaning of dp[i[j]=By using i numbers can we form a subset which could give us target sum=j
        //Initialise it

        //When there will be 0 target sum

        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        //When there will be 0 items { store false }

        for(int j=1;j<=targetSum;j++){
            dp[0][j]=false;
        }

        //Start filling from bottom to top

        for(int i=1;i<=n;i++){

            for(int j=1;j<=targetSum;j++){

                int val=nums[i-1];

                //Case of inclusion

                if(val<=j && dp[i-1][j-val]){
                    dp[i][j]=true;

                }else if(dp[i-1][j]){
                    //Case of exclusion

                    dp[i][j]=true;
                }

            }
        }

        return dp[n][targetSum];
    }


    //Through Memoization TC-O(N*TargetSum)

    private static boolean targetsumMemo(int[] nums,int targetSum,Boolean[][] memo,int n){

        //Base Cases
        //When we have to achieve 0 targetSum
        if(targetSum==0)return true;
        //When we have 0 numbers it is not possible to achieve any +ve target sum
        if(n==0)return false;

       //If value already calculated
        if(memo[n][targetSum]!=null) return memo[n][targetSum];

        if(nums[n-1]<=targetSum){
            //2 Options
            //Include OR  Exclude
            return  memo[n][targetSum]=(targetsumMemo(nums,targetSum-nums[n-1],memo,n-1) ||
                    targetsumMemo(nums,targetSum,memo,n-1) );

        }else{

            //Exclude
            return  memo[n][targetSum]=targetsumMemo(nums,targetSum,memo,n-1);

        }

    }

    private static boolean targetSumOptimized(int[] nums,int targetSum){

        boolean[] dp=new boolean[targetSum+1];
        dp[0]=true;

        for(int x : nums){

             for(int s=targetSum;s>=x;s--){
                 if(dp[s-x]) dp[s]=true;

             }

             //Early optimization
            if(dp[targetSum])return true;

        }
        return dp[targetSum];
    }
}
