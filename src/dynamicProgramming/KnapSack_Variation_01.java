package dynamicProgramming;

public class KnapSack_Variation_01 {
//Ones and Zeroes

    public static void main(String[] args) {

        String[] strs = {"10","0","1"};

        KnapSack_Variation_01 obj=new KnapSack_Variation_01();

        System.out.println(obj.findMaxForm(strs,1,1));
        System.out.println(obj.findMaxForm1(strs,1,1));


    }


    int[][][] memo=new int[101][101][601];

    public int findMaxForm(String[] strs, int m, int n) {


        int[][] count=new int[strs.length][2];

        for(int i=0;i<strs.length;i++) {

            int ones=0;
            int zeroes=0;
            for(char ch:strs[i].toCharArray()){
                if(ch=='1')ones++;
                else{
                    zeroes++;
                }


            }
            count[i][0]=zeroes;
            count[i][1]=ones;
        }

        //Initialise memo

        for(int[][] twoD:memo){

            for(int[] oneD : twoD){

                java.util.Arrays.fill(oneD,-1);

            }

        }


        return  solve(count,m,n,0);


    }

    private int solve(int[][]count,int m,int n,int i ){

        //Base case

        if(i>=count.length ||( m==0 && n==0))return 0;

        if(memo[m][n][i]!=-1)return memo[m][n][i];

        //Take

        int take=0;
        if(count[i][0]<=m && count[i][1]<=n){

            take=1+solve(count,m-count[i][0],n-count[i][1],i+1);

        }



        //skip

        int skip=solve(count,m,n,i+1);


        return memo[m][n][i]= Math.max(take,skip);

    }

    //Using Tabulation

    public int findMaxForm1(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {

            int ones = 0;
            int zeros = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '1')
                    ones++;
                else {
                    zeros++;
                }

            }

            for (int t = m; t >= zeros; t--) {
                for (int j = n; j >= ones; j--) {

                    dp[t][j] = Math.max(dp[t][j], 1 + dp[t - zeros][j - ones]);

                }

            }

        }

        return dp[m][n];

    }




}
