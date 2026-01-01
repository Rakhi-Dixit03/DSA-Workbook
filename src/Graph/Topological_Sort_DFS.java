package Graph;

import java.util.ArrayList;
import java.util.Stack;

import Graph.DirectedGraphImpl.*;

public class Topological_Sort_DFS {

//It is the linear ordering of vertices where for each edge(u->v) vertex u always comes before v in this ordering
//To Perform Topological Sort Graph Should be DAG(Directed Acyclic Graph)
    public static void main(String[] args) {

        DirectedGraphImpl graph1 = new DirectedGraphImpl(6);//passing number of vertices

        int[][] edges = {{5,0}, {4, 0}, {5, 2}, {2, 3}, {3, 1},{4,1}};//directed edges

        graph1.buildGraph(edges);

        topologicalSort(graph1.graph);


    }

    public static void  topologicalSort(ArrayList<Edge>[]graph){

        int v= graph.length;
        Stack<Integer>st=new Stack<>();
        boolean[] vis=new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,i,vis,st);
            }
        }

        while(!st.isEmpty()){

            System.out.print(st.pop()+" ");

        }

    }


    public static void dfs(ArrayList<Edge>[]graph,int curr,boolean[] vis,Stack<Integer>st){

        vis[curr]=true;

        for(Edge e:graph[curr]){

            if(!vis[e.des]){

                dfs(graph, e.des, vis, st);


            }

        }

        st.add(curr);

    }
}
