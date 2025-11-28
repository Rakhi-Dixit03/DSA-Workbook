package Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Max_NumKDiv_Components {


    public static void main(String[] args) {

        Max_NumKDiv_Components obj=new Max_NumKDiv_Components();
        int[][] edges={{0,2},{1,2},{1,3},{2,4}};
        int[] values={1,8,1,4,4};

        System.out.println("Maximum number of components divisible by k :  "+obj.maxKDivisibleComponents(5,edges,values,6));

    }

    int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        //checking total sum first if %!=0 means cannot divide into divisible components
        long totSum = 0;

        for (int val : values)
            totSum += val;

        if (totSum % k != 0)
            return 0;//impossible to partition

        //Build adjacency List
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = (List<Integer>[]) new List[n];

        for (int i = 0; i < n; i++) {

            adj[i] = new ArrayList<>();

        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);

        }

        //call dfs from root node
        dfs(0, -1, values, adj, k);

        return count;//it will have the number of maximum possible components

    }

    private int dfs(int node, int par, int[] values, List<Integer>[] adj, int k) {

        int subTotal = 0;
        //going deep to it's children

        for (int child : adj[node]) {

            if (child != par) {

                subTotal += dfs(child, node, values, adj, k);
                subTotal %= k; //Ensure the sum stays within bounds
            }

        }

        subTotal += values[node];//extracting value at a curr node

        subTotal %= k;

        //if subtree total divisible by k ,cut it
        if (subTotal == 0) {
            count++;
        }

        return subTotal;//otherwise pass the computed sum for the subtree up to parent

    }

}
