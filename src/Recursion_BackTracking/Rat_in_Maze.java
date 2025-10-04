package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Rat_in_Maze {

    static List<String>ans=new ArrayList<>();
//    static int[][] maze={{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
    static int[][] maze={{1,1,1},{1,0,1},{1,1,1}};

    static int n=maze.length;
    public static void main(String[] args) {

        mazeHelper(0,0,maze,"");
        System.out.println("Paths that Rat can take to reach at (n-1,n-1) cell : "+ans.toString());

    }
    public static boolean isValid(int i,int j,int[][] maze){

        return (i>=0 && i<n && j>=0 && j<n);

    }


    public static void mazeHelper(int i,int j,int[][] maze,String path){
        //Base Cases


        if(!isValid(i,j,maze) || maze[i][j]==0){
            return;
        }

        if(i==n-1 && j==n-1){
            ans.add(path);
            return;

        }

        maze[i][j]=0;//to avoid coming back on the same cell
        //Go left
        mazeHelper(i,j-1,maze,path+'L');

        //Go Right
        mazeHelper(i,j+1,maze,path+'R');
        //Go Up
        mazeHelper(i-1,j,maze,path+'U');
        //Go Down
        mazeHelper(i+1,j,maze,path+'D');
        //BackTracking
        maze[i][j]=1;//For other paths make it same again


    }

}