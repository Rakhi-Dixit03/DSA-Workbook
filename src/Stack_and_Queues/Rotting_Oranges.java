package Stack_and_Queues;

import java.util.LinkedList;

public class Rotting_Oranges {

    public static void main(String[] args) {

        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};

        System.out.println("Minutes required to turn all fresh oranges into rotten are : "+orangesRotting(grid));



    }

    static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        //Initialisation
        int fresh=0;
        int totTime=0;

        java.util.Queue<int[]>q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }


            }
        }

        if(fresh==0)return 0;

        while(!q.isEmpty()){

            int[] curr=q.poll();

            int i=curr[0];
            int j=curr[1];
            int t=curr[2];

            for(int[] dirs:directions){

                int newi=i+dirs[0];
                int newj=j+dirs[1];

                if(newi>=0 && newi<m && newj>=0 && newj<n){

                    if(grid[newi][newj]==1){

                        q.add(new int[]{newi,newj,t+1});
                        //make curr orange rotten and decrease fresh count
                        fresh--;
                        grid[newi][newj]=2;
                        totTime=Math.max(t+1,totTime);

                    }

                }

            }


        }

        return fresh==0? totTime : -1;
    }


}
