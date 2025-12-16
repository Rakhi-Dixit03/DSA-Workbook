package Graph;
import Graph.GraphImpl.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Connected_Components_Traversals {
//A Graph can consist of multiple  components { in a component we can go from one vertex to another}
// {But not any  outside vertex }
// Think of it as a distinct "island" or "subgraph" within a larger, potentially disconnected graph,
// where you can travel between any two points on the island, but you can't get to another island.

    public static void main(String[] args) {

        //Building Graph
        GraphImpl graph=new GraphImpl(8);

        int[][] edges={{0,1},{0,2},{1,2},{0,3},{3,4},{5,6}};

        graph.buildGraph(edges);
        System.out.println("DFS Sequence : ");
        dfs(graph.graph);
        System.out.println();
        System.out.println("BFS Sequence : ");
        bfs(graph.graph);



    }

    public static void dfs(ArrayList<Edge>[] graph){

            int v= graph.length;
            boolean[] vis=new boolean[v];
            for(int i=0;i<graph.length;i++){
                //call dfsUtil method for traversal
                if(!vis[i]){

                    dfsUtil(i,graph,vis);

                }


            }


   }

public static void dfsUtil(int curr,ArrayList<Edge>[] graph,boolean[] vis){

    //visit curr node
    System.out.print(curr+" ");
    vis[curr]=true;

    for(Edge e: graph[curr]){//traverse neighbours

        if(!vis[e.des]){

            dfsUtil(e.des,graph,vis);
        }


    }

}



public static void bfs(ArrayList<Edge>[] graph){
    int v= graph.length;
    boolean[] vis = new boolean[v];

    for(int i=0;i<graph.length;i++){
        //call bfsUtil method for traversal
        if(!vis[i]){
            bfsUtil(graph,vis,i);
        }


    }

}
// BFS FOR ALL Components of Graph


    public static void bfsUtil(ArrayList<Edge>[] graph,boolean[] vis,int start) {

        Queue<Integer> q = new LinkedList<>();


        q.add(start);//starting from vertex 0

        while (!q.isEmpty()) {

            int curr = q.poll();


            if (!vis[curr]) {//all tasks we do only if curr is not visited

                //Print curr vertex where we are

                System.out.print(curr + " ");

                vis[curr] = true;//mark curr vertex as visited

                //Add neighbours of curr vertex in the queue
                ArrayList<Edge> neigh = graph[curr];

                for (Edge e : neigh) {

                    q.add(e.des);

                }


            }

        }
    }

}
