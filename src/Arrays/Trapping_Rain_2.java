package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Trapping_Rain_2 {

    public static void main(String[] args) {
        int[][] heightMap={{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println("Water trapped : "+trapRainWater(heightMap));

    }

    public static int trapRainWater(int[][] heightMap) {

        int m=heightMap.length;
        int n=heightMap[0].length;

        //Sort on the basis of height
        PriorityQueue<int[]> boundaryCells=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        boolean[][] visited =new boolean[m][n];

        //Add Boundary cells into min-heap

        //top-bottom cells

        for(int col=0;col<n;col++){
            //top row
            boundaryCells.offer(new int[]{heightMap[0][col],0,col});

            visited[0][col]=true;

            //bottom row
            boundaryCells.offer(new int[]{heightMap[m-1][col],m-1,col});

            visited[m-1][col]=true;
        }


        //left-right cells

        for(int row=0;row<m;row++){
            //left part 1st col
            boundaryCells.offer(new int[]{heightMap[row][0],row,0});

            visited[row][0]=true;
            //right part last col
            boundaryCells.offer(new int[]{heightMap[row][n-1],row,n-1});

            visited[row][n-1]=true;
        }

        int water=0;

        int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};

        while(!boundaryCells.isEmpty()){

            int[] cell= boundaryCells.poll();

            int height=cell[0];
            int i=cell[1];
            int j=cell[2];

            for(int[] dir : directions){
                int i_=i+dir[0];
                int j_=j+dir[1];

                if(i_>=0 && i_<m  && j_<n && j_>=0 && !visited[i_][j_]){

                    water+=Math.max(height-heightMap[i_][j_],0);

                    //update neightbour's height
                    boundaryCells.offer(new int[]{Math.max(height,heightMap[i_][j_]),i_,j_});
                    visited[i_][j_]=true;

                }


            }


        }

        return water;

    }
}

