package Graph;

import java.util.ArrayList;
import Graph.GraphImpl.*;

public class HasPath {

    public static void main(String[] args) {


        GraphImpl graph = new GraphImpl(7);//building a graph

        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {3, 5}, {5, 6}};

        graph.buildGraph(edges);//passing edges as arguments

        boolean[] vis=new boolean[7];

        System.out.println("Does Path exists from source to destination which is 0-6 : "+hasPath(0,6, graph.graph,vis));



    }

    public static boolean hasPath(int src,int des,ArrayList<Edge>[] graph,boolean[] vis){

        if(src==des){
            return true;

        }

        //mark curr source  as visited

        vis[src]=true;

        for(Edge e:graph[src]){

            if(!vis[e.des] && hasPath(e.des,des,graph,vis)){

                return true;


            }

        }

        return false;

    }




}
