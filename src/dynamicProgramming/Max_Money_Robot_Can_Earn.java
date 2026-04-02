package dynamicProgramming;

//Ques : 3418
public class Max_Money_Robot_Can_Earn {
    int m;
    int n;
    Integer[][][] memo;
     //TC-O(3*m*n)
    //SC-(3*m*n)

    public static void main(String[] args) {
        Max_Money_Robot_Can_Earn obj=new Max_Money_Robot_Can_Earn();
         int[][] coins={{0,1,-1},{1,-2,3},{2,-3,4}};
        System.out.println("Maximum Money Robot can earn is : "+obj.maximumAmount(coins));
    }
       int solve(int[][] coins, int i, int j, int k, Integer[][][] memo) {
        //Base Cases
        if (i == m - 1 && j == n - 1) {

            if (coins[i][j] < 0 && k > 0) {//skip only in the -ve val case and when k>0
                return 0;
            }

            return coins[i][j];
        }

        if (i > m - 1 || j > n - 1) {

            return Integer.MIN_VALUE;//out of bounds
        }

        if (memo[i][j][k] != null) {

            return memo[i][j][k];
        }
        //take that cell no matter +ve or -ve coins [exploring all possibilities]
        int take = coins[i][j] + Math.max(solve(coins, i + 1, j, k, memo), solve(coins, i, j + 1, k, memo));

        //skip if coins' val<0 and  k>0
        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && k > 0) {

            int skipDown = solve(coins, i + 1, j, k - 1, memo);//After skip moving down
            int skipRight = solve(coins, i, j + 1, k - 1, memo);//After skipping moving right
            skip = Math.max(skipDown, skipRight);

        }

        return memo[i][j][k] = Math.max(take, skip);
    }

    public int maximumAmount(int[][] coins) {

        m = coins.length;
        n = coins[0].length;
        memo = new Integer[m][n][3];

        return solve(coins, 0, 0, 2, memo);
    }

    //We can Write Bottom-Up Dp solution too.
}

