package Graph;

import java.util.*;

//TC - O(V+E)
//SC - O(V+E)
public class Count_The_Num_Of_Complete_Components {

    public static int countCompleteComponents(int n, int[][] edges) {
        @SuppressWarnings("unchecked")

        List<Integer>[] graph = (List<Integer>[]) new ArrayList[n];
        int compCount=0;

        //Initialise empty Adjacency Lists

        for(int i=0; i< n;i++){

            graph[i] = new ArrayList<>();

        }

        //Build the Graph

        for(int[] e : edges){

            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);

        }

        //Keep a visited Array
        boolean[] vis=new boolean[n];

        //Apply DFS over each unvisited component

        for(int i=0;i<n;i++){

            if(vis[i])continue;


            int[] compInfo=new int[2];

            dfs(i,vis,graph,compInfo);

            //check if component is complete  i.e. - edges = v*(v-1)

            if(compInfo[0]*(compInfo[0]-1)==compInfo[1]){
                compCount++;
            }

        }

        return compCount;

    }

    public static void dfs(int curr,boolean[] vis, List<Integer>[] graph,int[] compInfo){

        vis[curr]=true;

        compInfo[0]++;//vertex count
        compInfo[1] += graph[curr].size();//add edges formed by current vertex

        //explore unvisited neighbours

        for(int neigh : graph[curr]){

            if(!vis[neigh]){

                dfs(neigh,vis,graph,compInfo);

            }


        }



    }

    public static void main(String[] args) {
        System.out.println("Number of Complete  Components are : "
                +countCompleteComponents(6,new int[][]{{0,1},{0,2},{1,2},{3,4}}));
    }

}
