package Graph;

import java.util.ArrayList;
import Graph.GraphImpl.*;

public class Cycle_Detection_Undirected_Graph {

    public static void main(String[] args) {
        //Building Graph
        GraphImpl graph=new GraphImpl(8);

        int[][] edges={{0,1},{0,2},{0,3},{3,4}};

        graph.buildGraph(edges);

        System.out.println("Does Cycle Exist in the graph ?  "+detectCycle(graph.graph));


    }


    public static boolean detectCycle(ArrayList<Edge>[] graph){
        int v=graph.length;
        boolean[] vis=new boolean[v];

        for(int i=0;i<v;i++){

            if(!vis[i]){

                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,int curr,int par){

        vis[curr]=true;

        for(Edge e : graph[curr]){

            if(!vis[e.des]){

              if(detectCycleUtil(graph,vis,e.des,curr)){
                    return true;
                }

            }else if(vis[e.des] && e.des!=par){
                return true;

            }
        }

        return false;
    }


}
