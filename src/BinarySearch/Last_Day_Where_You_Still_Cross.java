package BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class Last_Day_Where_You_Still_Cross {

    public static void main(String[] args) {

        int[][] cells={{1,1},{2,1},{1,2},{2,2}};
        Last_Day_Where_You_Still_Cross obj=new Last_Day_Where_You_Still_Cross();
        System.out.println("Last Day When you can Still cross the grid from the top to bottom : "+obj.latestDayToCross(2,2,cells));

    }

    int n,m;
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        m=row;
        n=col;


        //Binary Search

        int l=0;
        int h=cells.length-1;
        int lastDay=0;

        while(l<=h){

            int mid=l+(h-l)/2;

            if(canCross(cells,mid)){
                l=mid+1;
                lastDay=mid+1;
            }else{

                h=mid-1;
            }

        }
        return lastDay;

    }


    private boolean canCross(int[][] cells,int mid){

        int[][] grid=new int[m][n];

        for(int i=0;i<=mid;i++){

            int row=cells[i][0]-1;
            int col=cells[i][1]-1;

            grid[row][col]=1;

        }

        for(int j=0;j<n;j++){

            if(grid[0][j]==0 && dfs(grid,0,j)){
                return true;

            }

        }

        return false;

    }


    private boolean dfs(int[][] grid,int row,int col){

        //Base Cases
        //Boundary Cross Condition

        if(row>=m || row<0 || col<0 || col>=n || grid[row][col]==1 )return false ;

        if((row==m-1))return true;//bottom row with cell having land

        grid[row][col]=1;//mark visited


        for(int[] dir : dirs){

            int x=row+dir[0];
            int y=col+dir[1];

            if(dfs(grid,x,y)){
                return true;

            }


        }
        return false;

    }


    private boolean bfs(int[][] grid,int row,int col){


        Queue<int[]>q=new LinkedList<>();

        q.add(new int[]{row,col});


        while(!q.isEmpty()){

            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            if(x==m-1){
                return true;
            }

            for(int[] dir:dirs){

                int new_x=x+dir[0];
                int new_y=y+dir[1];

                if(new_x>0 && new_x<m && new_y>0 && new_y<n && grid[new_x][new_y]==0){

                    q.add(new int[]{new_x,new_y});
                }


            }

        }
        return false;

    }

}
