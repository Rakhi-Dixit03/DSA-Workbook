package dynamicProgramming;

import java.util.Arrays;

//Longest Common Subsequence

public class Question8 {

    public static void main(String[] args) {

        String str1="abcde";
        String str2="acde";

        int n=str1.length();
        int m=str2.length();

        int[][] memo=new int[n+1][m+1];
        //Initialising
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }


        System.out.println("Length of Longest Common Subsequence is : "+lcs(str1,str2,n,m));
        System.out.println("Length of Longest Common Subsequence Through memoization approach is : "+lcsMemoization(str1,str2,n,m,memo));
        System.out.println("Length of Longest Common Subsequence Through Tabulation is  : "+lcsTab(str1,str2,n,m));

    }

    // Recursive Approach

    private static int lcs(String str1,String str2,int n,int m){

        //Base Case

        if(n==0 || m==0)return 0;

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            //Same Characters
            return lcs(str1,str2,n-1,m-1)+1;


        }else {
            //Different Characters
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);

        }

    }
 // Through Memoization

    private static int lcsMemoization(String str1,String str2,int n,int m,int[][] memo){

        //Base Case
        if(n==0 || m==0) return 0;

        if(memo[n][m]!=-1)return memo[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)){

            return memo[n][m]=lcsMemoization(str1,str2,n-1,m-1,memo)+1;

        }else{

            int ans1=lcsMemoization(str1,str2,n-1,m,memo);
            int ans2=lcsMemoization(str1,str2,n,m-1,memo);

            return memo[n][m]=Math.max(ans1,ans2);
        }

    }

    //Through Tabulation

    private static int lcsTab(String str1,String str2,int n,int m){

        //Creating a DP Array

        int[][] dp=new int[n+1][m+1];

        //Initialising it

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
//Meaning of (i,j)=> Longest Common Subsequence of two strings one string of length i and another of length j

      //Filling from bottom to up

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++) {

                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    //Same chars
                    dp[i][j]=dp[i-1][j-1]+1;

                }else{
                    //Different chars

                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];

                    dp[i][j]=Math.max(ans1,ans2);

                }

            }
        }
        return dp[n][m];
    }

}



