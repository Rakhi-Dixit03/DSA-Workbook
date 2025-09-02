package dynamicProgramming;

//Fibonacci Series

public class Question1 {

    public static void main(String[] args){

        int n=7;
        int[] dp=new int[n+1];//Covering 0-n numbers
        System.out.println("Nth fibonacci term through recursion is : "+fib1(n));
        System.out.println("Nth fibonacci term through memoization is : "+fib2(n,dp));
        System.out.println("Nth fibonacci term through Tabulation is : "+fib3(n));


    }

    //Method to find  nth fibonacci number through recursion TC-O(2^N)
    private static int fib1(int n){
        //Base Case
        if(n==0 || n==1)return n;

        return fib1(n-1)+fib1(n-2);//Recursive calls


    }

    //Method to find  nth fibonacci number through Memoization TC-O(N)

    private static int fib2(int n,int[] dp){
        //Base Case
        if(n==0 || n==1) return n;

        if(dp[n]!=0) return dp[n];


        return dp[n]=fib2(n-1,dp)+fib2(n-2,dp);
    }

    //Method to find  nth fibonacci number through Tabulation TC-O(N)

    private static int fib3(int n){

        int[] dp=new int[n+1];//Creating a Table/Array

        //Initializing it

        dp[0]=0;
        dp[1]=1;
        //Calculating answer by going from bottom to up

        for(int i=2;i<=n;i++){

            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

}
