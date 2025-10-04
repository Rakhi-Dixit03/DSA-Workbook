package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class M_Coloring {

    public static void main(String[] args) {

        int vertices=4;
        int[][] edges={{0,1},{1,3},{2,3},{3,0},{0,2}};
        int m=3;

        List<Integer>[] graph=new List[vertices];
        int n= graph.length;
        int[] colArr=new int[n];
        //Initialise graph array of ArrayList

        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();

        }

        for(int[] e: edges){

            int u=e[0];
            int v=e[1];
            //As it is undirected Graph
            graph[u].add(v);
            graph[v].add(u);

        }

        System.out.println("Is it possible to color all the vertices of a graph by m different colors ? "+mColoring(graph,0,n,m,colArr));


    }


    public static boolean isPossible(List<Integer>[] G,int node,int color,int[] colArr){

        for(int neigh:G[node]){

            if(colArr[neigh]==color){
                return false;
            }

        }

        return true;

    }
    public static boolean mColoring(List<Integer>[] G,int node,int n,int m,int[] colArr){

        //Base Case
        if(node==n){
            return true;
        }


        for(int i=1;i<=m;i++){

            if(isPossible(G,node,i,colArr)){
                colArr[node]=i;

                if(mColoring(G,node+1,n,m,colArr)){
                    return true;
                }
                //BackTrack
                colArr[node]=0;
            }


        }

        return false;
    }





}
