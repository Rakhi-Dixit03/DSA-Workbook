package Graph;

import Graph.DirectedGraphImpl.*;

import java.util.ArrayList;

public class CycleDetection_in_Directed_Graph {


    public static void main(String[] args) {

        int[][] edges={{0,1},{1,2},{2,4}};//Answer should be true for this graph
        DirectedGraphImpl graph = new DirectedGraphImpl (5);

        graph.buildGraph(edges);

        System.out.println("Does a Cycle exist in the graph ? : "+(isCycle(graph.graph)?"Yes":"No"));
    }

   public static boolean isCycle(ArrayList<Edge>[] graph){

        int v=graph.length;

        boolean[] vis=new boolean[v];
        boolean[] stack=new boolean[v];

        for(int i=0;i<v;i++){//Covering all components of the graph or all vertices

            if(!vis[i]){

                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }


        }

        return false;
   }

   public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,boolean[] stack){

        vis[curr]=true;
        stack[curr]=true;


        for(Edge e : graph[curr]){

            if(stack[e.des]){//if neighbour already in the stack
                return true;
            }

            if(!vis[e.des] && isCycleUtil(graph, e.des, vis, stack)){
                return true;
            }

       }
        stack[curr]=false;

        return false;

   }

}
