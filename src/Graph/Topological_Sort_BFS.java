package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Graph.DirectedGraphImpl.*;

public class Topological_Sort_BFS {
//Kahn's Algorithm  using in-degree,out-degree concept
    public static void main(String[] args) {

        DirectedGraphImpl graph1 = new DirectedGraphImpl(6);//passing number of vertices

        int[][] edges = {{5,0}, {4, 0}, {5, 2}, {2, 3}, {3, 1},{4,1}};//directed edges

        graph1.buildGraph(edges);
       topologicalSort(graph1.graph);


    }

  public static void calculateInDegree(ArrayList<Edge>[] graph,int[] inDegree){

      for (ArrayList<Edge> edges : graph) {

          for (var e : edges) {

              inDegree[e.des]++;

          }


      }

  }

    public static void topologicalSort(ArrayList<Edge>[] graph){
        int v= graph.length;
        int[] inDegree=new int[v];

        calculateInDegree(graph,inDegree);

        Queue<Integer>q=new LinkedList<>();

        for(int i=0;i<v;i++){

            if(inDegree[i]==0){//add vertices in the queue whose in-degree is 0
                q.add(i);
            }

        }

        while(!q.isEmpty()){

            int curr=q.poll();
            System.out.print(curr+" ");

            for(Edge e: graph[curr]){

                inDegree[e.des]--;//decrease in-degree of each neighbour vertex

                if(inDegree[e.des]==0){

                    q.add(e.des);
                }


            }

        }

    }
}
