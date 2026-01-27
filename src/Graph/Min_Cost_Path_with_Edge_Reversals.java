package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import Graph.DirectedGraphImpl.*;

public class Min_Cost_Path_with_Edge_Reversals {

    static class Pair{

        int node;
        int dis;

        public Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }

    }

    //A Good Variation of Dijkstra Algorithm

    public static void main(String[] args) {

//        int[][] edges={{0,1,3},{1,0,6},{0,2,2},{2,0,4},{3,1,1},{1,3,2},{2,3,4},{3,2,8}};

        int[][] edges={{0,2,1},{2,0,2},{2,1,1},{1,2,2},{1,3,1},{3,1,2},{2,3,3},{3,2,6}};

        DirectedGraphImpl graph=new DirectedGraphImpl(4);

        graph.buildGraph(edges);
        graph.printGraph();

        System.out.println(getMinCostPath(4, graph.graph));


    }

    public static int getMinCostPath(int n, ArrayList<Edge>[] graph){

        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(a->a.dis));
        int[] dis=new int[n];

        //initialise distance Array

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0]=0;
        boolean[] vis=new boolean[n];

        pq.add(new Pair(0,0));//distance from 0 to 0


        while(!pq.isEmpty()){

            Pair p=pq.poll();

            int d=p.dis;
            int node=p.node;

           if(d>dis[node]){
               continue;
           }

           if(!vis[node]){

               vis[node]=true;

               //iterate over all of its neighbours

               for(Edge e : graph[node]){

                  int v=e.des;
                  int wt=e.wt;

                  if(d+wt<dis[v]){

                      dis[v]=d+wt;

                      pq.add(new Pair(v,dis[v]));

                  }


               }

           }

        }

        for(int i=0;i<dis.length;i++){

            System.out.println("Shortest Distance : From "+0+" -> "+i +" is "+dis[i]);

        }

        return dis[n-1];
    }

}
