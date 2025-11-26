package dynamicProgramming;

//Leetcode 2435
public class Path_in_Matrix_SumDivBy_K {

    public static void main(String[] args) {

      int[][] grid={{5,2,4},{3,0,5},{0,7,2}};


      Path_in_Matrix_SumDivBy_K obj=new Path_in_Matrix_SumDivBy_K();

        System.out.println("Number of paths where the sum of the elements on " +
                "the path divisible by k by using memoization is  : "+obj.numberOfPaths(grid,3));

        System.out.println("Number of paths where the sum of the elements on " +
                "the path divisible by k by using Tabulation is  : "+obj.numberOfPaths2(grid,3));

    }

    int m;
    int n;
    int[][][] memo;
    int[][][] dp;
    int M=1000_000_000+7;

    public int numberOfPaths(int[][] grid, int k) {

        m=grid.length;
        n=grid[0].length;
        memo =new int[m][n][k];

        //Initialising it with -1

        for(int[][] twoD : memo){

            for(int[] oneD : twoD){
                java.util.Arrays.fill(oneD,-1);

            }

        }
        return solve(grid,0,0,0,k);

    }

    int solve(int[][] grid,int r,int c,int rem,int k){

        //Base Case

        if(r>=m || c>=n)return 0;

        if(r==m-1 && c==n-1){

            return ((rem+grid[r][c])%k)==0?1:0;

        }

        if(memo[r][c][rem]!=-1){
            return memo[r][c][rem];
        }

        int down=solve(grid,r+1,c,(rem+grid[r][c])%k,k);
        int right=solve(grid,r,c+1,(rem+grid[r][c])%k,k);


        return memo[r][c][rem]=(down+right)%M;

    }

    //Bottom-Up Solution

    public int numberOfPaths2(int[][] grid, int k) {

        m = grid.length;
        n = grid[0].length;
        dp = new int[m+1][n+1][k];

        //Initialising with the  base case

        for (int rem = 0; rem <= k - 1; rem++) {

            dp[m - 1][n - 1][rem] = ((rem + grid[m - 1][n - 1]) % k) == 0?1:0;

        }

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                for (int rem = 0; rem <= k - 1; rem++) {

                    if(i==m-1 && j==n-1)continue;

                    int newRem = (rem + grid[i][j]) % k;

                    int down = dp[i + 1][j][newRem];
                    int right = dp[i][j + 1][newRem];

                    dp[i][j][rem] = (down + right) % M;

                }

            }

        }

        return dp[0][0][0];

    }






}
