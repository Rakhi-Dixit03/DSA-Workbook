package Graph;

import java.util.ArrayList;
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

}
