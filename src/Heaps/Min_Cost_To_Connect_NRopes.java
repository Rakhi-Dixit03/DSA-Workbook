package Heaps;

import java.util.PriorityQueue;

public class Min_Cost_To_Connect_NRopes {


    public static void main(String[] args) {

        int[] ropes={4,3,2,6};

        System.out.println("Minimum Cost to Connect n ropes is : "+minCostToConnectRopes(ropes));


    }

    public static int minCostToConnectRopes(int[] ropes){

        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int cost=0;
        for(int rope:ropes){
            pq.add(rope);
        }

        while(pq.size()!=1){

            int r1=pq.remove();
            int r2=pq.remove();

            int r3=r1+r2;

            cost+=r3;
            pq.add(r3);

        }
        return cost;
    }


}
