package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Graph.GraphImpl.*;

public class Bipartite_Graph {


    public static void main(String[] args) {

        //Building Graph
        GraphImpl graph=new GraphImpl(8);

        int[][] edges={{0,1},{1,2},{2,3},{3,4},{4,0}};

        graph.buildGraph(edges);

        System.out.println("Is the given graph Bipartite or Not ? : "+isBipartite(graph.graph));
        boolean ans=false;

        if(isCycle(graph.graph)){
            if(cycleNodes % 2 == 0){//if cycle exists cycle node count should be even
                ans=true;
            }

        }else{
            //if cycle doesn't exist then by default it is a bipartite
            ans=true;
        }

        System.out.println("Is the given graph Bipartite or Not using 2nd method ? : "+ans);

    }

    //Using Graph Coloring Algo(BFS)
    public static boolean isBipartite(ArrayList<Edge>[] graph){

        int v= graph.length;
        Queue<Integer>q=new LinkedList<>();
        int[] col=new int[v];//storing color of each vertex either yellow or blue

        java.util.Arrays.fill(col,-1);

        for (int i = 0; i < v; i++) {//Covering all connected components

            if (col[i] == -1) {//Means not visited yet

                q.add(i);
                col[i] = 0;//Yellow

                while (!q.isEmpty()) {

                    int curr = q.poll();

                    for (Edge e : graph[curr]) {//processing neighbours

                        int neigh = e.des;

                        if (col[curr] == col[neigh]) {
                            return false;

                        } else if (col[neigh] == -1) {

                            int newCol = col[curr] == 0 ? 1 : 0;//0 means yellow and 1 means blue

                            col[neigh] = newCol;
                            q.add(neigh);

                        }

                    }
                }

            }

        }
        return true;
    }

    static int cycleNodes;
    public static boolean isCycle(ArrayList<Edge>[] graph){

        int v=graph.length;
        int[] parent =new int[v];
        Arrays.fill(parent,-1);
        boolean[] vis = new boolean[v];

        for(int i=0;i<v;i++){

            if(!vis[i]){

               if(dfs(i,graph,vis,parent,-1)){
                 return true;
               }

            }
        }

        return false;

    }

    //Through Cycle detection logic ,if a graph contains a cycle then we have to calculate the number of nodes in the cycle

    public static boolean dfs(int curr,ArrayList<Edge>[] graph,boolean[] vis,int[] parent,int par){

        vis[curr]=true;
        parent[curr] = par;

        for(Edge e : graph[curr]){

            if(!vis[e.des]){
                if(dfs(e.des,graph,vis,parent,curr)){
                    return true;
                }

            }else if(vis[e.des] && par!=e.des){//back edge

                countCycleNodes(curr,e.des,parent);
                return true;

            }
        }

    return false;
    }

    public static void countCycleNodes(int st,int end,int[] parent){
       cycleNodes=1;
        int curr=st;

        while(curr!=end){

            curr=parent[curr];
            cycleNodes++;

        }
    }

}
