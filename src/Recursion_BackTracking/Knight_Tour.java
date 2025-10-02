package Recursion_BackTracking;

public class Knight_Tour {

    public static void main(String[] args) {

        int n=3;
        int[][] grid={{0,3,6},{5,8,1},{2,7,4}};

        System.out.println("Result of Knight Tour for checking configuration : "+knightTour(grid,0,0,0,n));

    }

    public static boolean knightTour(int[][] grid,int r,int c,int expVal,int n){

        //Base Case
        if(r>=n || c>=n || r<0 || c<0 || grid[r][c]!=expVal){
            return false;
        }

        if(expVal==n*n-1)return true;


        if(knightTour(grid,r-2,c+1,expVal+1,n)){
            return true;
        }else if(knightTour(grid,r-1,c+2,expVal+1,n)){
            return true;
        }else if(knightTour(grid,r+1,c+2,expVal+1,n)){
            return true;
        }else if (knightTour(grid,r+2,c+1,expVal+1,n)){
            return true;
        }else if(knightTour(grid,r+2,c-1,expVal+1,n)){
            return true;
        }else if(knightTour(grid,r+1,c-2,expVal+1,n)){
            return true;
        }else if(knightTour(grid,r-1,c-2,expVal+1,n)){
            return true;
        }

        return knightTour(grid, r - 2, c - 1, expVal + 1, n);

    }



}
