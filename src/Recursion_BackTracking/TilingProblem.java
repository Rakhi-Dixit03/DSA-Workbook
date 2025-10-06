package Recursion_BackTracking;

public class TilingProblem {

    public static void main(String[] args) {


        System.out.println("All possible ways to place tiles of size 2*1 on a 2*4 board :"+tiling(4));
    }


    public static int tiling(int n){

        //Base case
        if(n==0 || n==1)return 1;

        int vertical=tiling(n-1);
        int horizontal=tiling(n-2);
        return vertical+horizontal;

    }
}
