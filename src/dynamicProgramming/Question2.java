package dynamicProgramming;

//Climbing Stairs or
//Count Ways to Climb nth Stair

public class Question2 {

    public static void main(String[] args) {

        int n=5;
        int[] dp=new int[n+1];//Storing ways to reach at each ith stair

        System.out.println("Through recursion Ways are : "+countWays1(n));
        System.out.println("Through memoization Ways are : "+countWays2(n,dp));
        System.out.println("Through tabulation Ways are : "+countWays3(n));

    }

    //Through Recursion TC-O(2^N)

    private static int countWays1(int n){
        //Base Case
        if(n==0 || n==1) return 1;//There is one way to be at the same position

        return countWays1(n-1)+countWays1(n-2);

    }

    //Through Memoization TC-O(N)

    private static int countWays2(int n,int[] dp){
        //Base Case
        if(n==0 || n==1) return 1;


      if(dp[n]!=0)return dp[n];

      //First store the value then return
      return dp[n]=countWays1(n-1)+countWays1(n-2);


    }

    //Through Tabulation TC-O(N)

    private static int countWays3(int n){

        //Create a dp array
        int[] dp=new int[n+1];

        //initialize it
        dp[0]=1;

        for(int i=1;i<=n;i++){

            if(i==1) {
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }


        }
        return dp[n];
    }

}
