package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(List.of(-1));
        triangle.add(Arrays.asList(2,3));
        triangle.add(Arrays.asList(1,-1,-3));
        int n=triangle.size();

        System.out.println("Minimum Path sum from Top to Bottom : "+minimumTotal(triangle));

        int[][] memo=new int[n][n];

        for(int[] row : memo){

            Arrays.fill(row,-1);
        }
        System.out.println("Minimum Path sum from Top to Bottom using memoization : "+solve(triangle,0,0,n,memo));
        System.out.println("Minimum Path sum from Top to Bottom using Tabulation : "+solve(triangle,n));

    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        return solve(triangle,0,0,n);


    }

    private static  int solve(List<List<Integer>> triangle, int row, int col, int n){
        //Base Case

        if(row==n-1)return triangle.get(row).get(col);


        return triangle.get(row).get(col) + Math.min(solve(triangle,row+1,col,n),solve(triangle,row+1,col+1,n));

    }

//Memoization
    private static  int solve(List<List<Integer>> triangle, int row, int col, int n,int[][] memo){
        //Base Case

        if(row==n-1)return triangle.get(row).get(col);

        if(memo[row][col]!=-1)return memo[row][col];

        int minPath=triangle.get(row).get(col) + Math.min(solve(triangle,row+1,col,n),solve(triangle,row+1,col+1,n));

        return  memo[row][col]= minPath;
    }


    //Bottom Up

    private static int solve(List<List<Integer>> triangle,int n){

        int[] dp=new int[n];

        //initialise with last row

        for(int j=0;j<n;j++){

            dp[j]=triangle.get(n-1).get(j);
        }


        for(int i=n-2;i>=0;i--){

            for(int j=0;j<=i;j++){

                dp[j]= triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);

            }

        }


        return dp[0];

    }






}
