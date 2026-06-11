package Graph;

import java.util.*;
//TC - O(N) N-number of nodes in the tree
//SC-O(V + E) + O(H) stack space
public class Num_Of_Ways_To_Assign_Edge_Weights {

    static long mod = 1_000_000_007;

    int binaryExpo(long expo) {

        long base =2;
        long result = 1;

        while (expo > 0) {

            if ((expo & 1) == 1) {//check if odd number

                result = (result * base) % mod;

            }

            base = (base * base) % mod;

            expo >>= 1;//right shift to move to next bit

        }

        return (int) result;
    }

    int getMaxDepth(HashMap<Integer, List<Integer>> adjList, int root, int par) {

        int maxDepth = 0;

        for (int neigh : adjList.getOrDefault(root, Collections.emptyList())) {

            if (neigh == par)
                continue;

            maxDepth = Math.max(maxDepth, (getMaxDepth(adjList, neigh, root) + 1));

        }

        return maxDepth;

    }

    public int assignEdgeWeights(int[][] edges) {

        //Create Adjacency List using HashMap
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

        }

        int maxDepth = getMaxDepth(adjList, 1, -1);//root,parent

        if (maxDepth == 1) return 1;

        return binaryExpo( maxDepth - 1);
    }

    public static void main(String[] args) {

        Num_Of_Ways_To_Assign_Edge_Weights obj=new Num_Of_Ways_To_Assign_Edge_Weights();

        System.out.println("Number of ways to assign edge weights are  : "+obj.assignEdgeWeights(new int[][]{{1,2},{1,3},{3,4},{3,5}}));
    }
}
