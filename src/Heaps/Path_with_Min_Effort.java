package Heaps;

import java.util.PriorityQueue;

public class Path_with_Min_Effort {

    public static void main(String[] args) {

        int[][] grid={{1,2,2},{3,8,2},{5,3,5}};
        Path_with_Min_Effort obj=new Path_with_Min_Effort();

        System.out.println("Minimum effort required : "+obj.minimumEffortPath(grid));


    }

    //Dijkstra Algorithm Variation

    int m;
    int n;
    private final int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static class Pair {

        int diff;
        int[] coord;

        public Pair(int diff, int[] coord) {
            this.diff = diff;
            this.coord = coord;

        }



    }

    private boolean isSafe(int x, int y) {

        return (x >= 0 && x < m && y >= 0 && y < n);

    }

    public int minimumEffortPath(int[][] heights) {

        m=heights.length;
        n=heights[0].length;

        int[][] result=new int[m][n];
        //initialising result with maxValues
        for(int[] row:result){
            java.util.Arrays.fill(row,Integer.MAX_VALUE);

        }

        result[0][0]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.diff-b.diff);

        pq.add(new Pair(0,new int[]{0,0}));//initial position

        while(!pq.isEmpty()){

            Pair curr=pq.poll();

            int diffSoFar=curr.diff;
            int x =curr.coord[0];
            int y=curr.coord[1];

            if(diffSoFar>result[x][y])continue;//avoid stale values

            if(x==m-1 && y==n-1 )return diffSoFar;

            for(int[] dir:dirs){

                int new_x=x+dir[0];
                int new_y=y+dir[1];

                if(isSafe( new_x, new_y)) {

                    int stepDiff=Math.abs(heights[x][y]- heights[new_x][new_y]);

                    int newEffort= Math.max(diffSoFar,stepDiff);

                    if(result[new_x][new_y]>newEffort){

                        result[new_x][new_y]=newEffort;

                        pq.add(new Pair(newEffort,new int[]{new_x,new_y}));

                    }

                }



            }

        }
        return result[m-1][n-1];

    }



}
