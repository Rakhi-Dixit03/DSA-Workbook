package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Graph.DirectedGraphImpl.*;


class Pair{

    int node ;
    int dis;

    public Pair(int n,int d){
        node=n;
        dis=d;

    }

}


public class Dijkstra_Algo {

    public static void main(String[] args) {

        int[][] edges={{0,1,2},{0,2,4},{1,2,1},{1,3,7},{2,4,3},{4,3,2},{3,5,1},{4,5,5}};

        DirectedGraphImpl graph=new DirectedGraphImpl(6);
        graph.buildGraph(edges);

        dijkstraAlgo(graph.graph,0);

    }

    //TC-O((V+E)(logV))->O(E(logV))
    //Shortest Path from a single Source to all other vertices

    public static void dijkstraAlgo(ArrayList<Edge>[] graph,int src){

        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.dis));
        boolean[] vis=new boolean[graph.length];
        int[] dis=new int[graph.length];

        //initially distance array will be populated with infinity to indicate we don't know the distance yet

        for(int i=0;i< dis.length;i++){

            if(i==src)continue;
            dis[i]=Integer.MAX_VALUE;

        }

        pq.add(new Pair(src,0));//As distance from source to source is 0


        while(!pq.isEmpty()){

            Pair curr=pq.poll();

            int u=curr.node;//curr node that we are processing
            int d= curr.dis;//distance from the source

            if(d>dis[u])continue;//skipping the stale entries

            if(!vis[u]){

                vis[u]=true;

                //Go over all of its neighbours

                for(Edge e : graph[u]){

                    int v=e.des;
                    int wt_u_to_v=e.wt;


                    //This is the relaxation step

                    if(d+wt_u_to_v<dis[v]){

                        dis[v]=d+wt_u_to_v;

                        //Also Add updated value in the PQ
                        pq.add(new Pair(v,dis[v]));

                    }

                }

            }

        }


        for(int i=0;i<dis.length;i++){

            System.out.println("Shortest Distance : From "+src+" -> "+i +" is "+dis[i]);

        }

    }


}
