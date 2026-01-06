package Graph;

import java.util.ArrayList;

public class DirectedGraphImpl {

    static class Edge {

        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

    }

    ArrayList<Edge>[] graph;

    public DirectedGraphImpl(int v) {

        graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();//initialising with empty Arraylists
        }


    }

    public void buildGraph(int[][] edgeInfo) {

        for (int[] edge : edgeInfo) {

            int u = edge[0];
            int v = edge[1];
            int wt=1;

            if(edge.length==3){
                wt=edge[2];
            }

            graph[u].add(new Edge(u, v, wt));

        }

    }

    public void printGraph() {

        for (int i = 0; i < graph.length; i++) {

            System.out.print("Neighbours of vertex " + i + " : { ");

            for (Edge e : graph[i]) {

                System.out.print(e.des + " ");


            }

            System.out.println("}");
        }

    }


    public static void main(String[] args) {

        DirectedGraphImpl graph1 = new DirectedGraphImpl(5);//passing number of vertices

        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 2}, {2, 4}};//directed edges

        graph1.buildGraph(edges);
        graph1.printGraph();


    }

}

