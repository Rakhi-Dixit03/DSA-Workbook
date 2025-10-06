package Recursion_BackTracking;

public class Power {
    public static void main(String[] args) {

        System.out.println("Power of x : "+pow(2,5));
        System.out.println("Power of x : "+pow1(3,3));


    }

    //O(N)
    public static int pow(int x,int n){

        //Base case
        if(n==0)return 1;

        return x*pow(x,n-1);

    }

    public static int pow1(int x,int n){

        //Base case
        if(n==0)return 1;

       int  halfPow=pow1(x,n/2);

       if(n%2==0){
           return halfPow*halfPow;
       }


       return x*halfPow*halfPow;

    }
}
