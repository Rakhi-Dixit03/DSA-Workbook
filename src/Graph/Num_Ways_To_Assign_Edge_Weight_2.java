package Graph;

import java.util.*;

public class Num_Ways_To_Assign_Edge_Weight_2 {

    static int[] binaryExponent;
    static final long mod = 1000000007L;

    static {
        binaryExponent = new int[100001];
        long pro = 1L;
        for (int i = 1; i < binaryExponent.length; i++) {
            binaryExponent[i] = (int) (pro);
            pro = (pro * 2L) % mod;
        }
    }

    int[][] ancestors;
    int[] ans, parent;
    int[] depth;
    boolean[] visited;

    private void buildAncestors(int[] parent, int numNodes) {
        ancestors = new int[(int) (Math.log(numNodes) / Math.log(2)) + 1][numNodes + 1];
        int n = ancestors.length, m = ancestors[0].length;
        System.arraycopy(parent, 0, ancestors[0], 0, m);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ancestors[i][j] = ancestors[i - 1][ancestors[i - 1][j]];
            }
        }
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length, q = queries.length;
        ans = new int[q];
        parent = new int[n + 2];
        visited = new boolean[n + 2];
        depth = new int[n + 2];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        parent[1] = 1;

        dfs(1, adj, 0);
        buildAncestors(parent, n + 1);

        for (int i = 0; i < q; i++) {
            ans[i] = binaryExponent[getPathCount(queries[i][0], queries[i][1])];
        }
        return ans;
    }

    private int getPathCount(int u, int v) {
        int depthU = depth[u], depthV = depth[v], lca;

        if (depthU > depthV)
            lca = LCA(u, v);
        else
            lca = LCA(v, u);

        return depth[u] + depth[v] - 2 * depth[lca];
    }

    private int LCA(int u, int v) {
        int depthU = depth[u];
        int depthV = depth[v];

        int diff = depthU - depthV;
        int mask = 1, idx = 0;

        while (mask <= diff) {
            if ((mask & diff) > 0) {
                u = ancestors[idx][u];
            }

            mask <<= 1;
            idx++;
        }

        if (u == v)
            return u;

        int maxJumps = ancestors.length - 1;

        while (maxJumps >= 0) {
            if (ancestors[maxJumps][u] != ancestors[maxJumps][v]) {
                u = ancestors[maxJumps][u];
                v = ancestors[maxJumps][v];
            }
            maxJumps--;
        }

        return ancestors[0][u];
    }

    private void dfs(int node, List<List<Integer>> adj, int depthValue) {
        visited[node] = true;
        depth[node] = depthValue;
        List<Integer> children = adj.get(node);

        for (int v : children) {
            if (visited[v])
                continue;
            parent[v] = node;
            dfs(v, adj, depthValue + 1);
        }
    }

}
