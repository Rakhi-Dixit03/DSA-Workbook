package Graph;

import Graph.GraphImpl.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Traversals {

    public static void main(String[] args) {

        GraphImpl graph = new GraphImpl(7);//building a graph

        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {3, 5}, {5, 6}};

        graph.buildGraph(edges);//passing edges as arguments

        boolean[] vis=new boolean[7];


        System.out.println("BFS - Breadth First Search Sequence of graph : ");

         bfs(graph.graph);

        System.out.println();

        System.out.println("DFS - Depth First Search Sequence of graph : ");

        dfs(0,graph.graph,vis);



    }

    public static void bfs(ArrayList<Edge>[] graph) {

        int vertices = graph.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[vertices];

        q.add(0);//starting from vertex 0

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


    public static void dfs(int curr,ArrayList<Edge>[] graph,boolean[] vis){

          vis[curr]=true;
          System.out.print(curr+" ");


          for(Edge e : graph[curr]){//traverse over neighbours

              if(!vis[e.des]){

                  //call dfs for it
                  dfs(e.des,graph,vis);

              }

          }

    }

}