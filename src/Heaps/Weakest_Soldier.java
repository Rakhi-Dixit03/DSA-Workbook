package Heaps;

import java.util.PriorityQueue;
//we have to find the k weakest soldiers in this problem based on some conditions
public class Weakest_Soldier {

    static class Row{

        int soldierCount;
        int idx;

        public Row(int soldierCount, int idx) {
            this.soldierCount = soldierCount;
            this.idx = idx;
        }

    }

    public static void main(String[] args) {

        int[][] binGrid={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;

        weakestSoldier(binGrid,k);


    }

    public static void weakestSoldier(int[][] grid,int k){

        PriorityQueue<Row>pq=new PriorityQueue<>((a,b)->{

            if(a.soldierCount==b.soldierCount){
                return a.idx-b.idx;
            }

            return a.soldierCount-b.soldierCount;
        });

        for(int i=0;i< grid.length;i++){

            int count=0;

            for(int j=0;j< grid[0].length;j++){

                count+=grid[i][j]==1?1:0;

            }
            pq.add(new Row(count,i));

        }

        //Row numbers Where we find the k weakest soldiers
        System.out.println("Rows where we found the k weakest soldiers : ");
        for(int i=0;i<k;i++){

            System.out.println("R"+pq.remove().idx);

        }


    }

}
