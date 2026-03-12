package Graph;

import java.util.*;

public class Maximize_Spanning_Tree_Stability {

    //Approach - (Binary Search + DSU)
//T.C : O(nlog(maxStability - minStability))
//S.C : O(n+e), n = number of nodes, e = number of edges
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            if (xParent == yParent) {
                return false;
            }

            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
            } else if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
            } else {
                parent[xParent] = yParent;
                rank[yParent]++;
            }

            return true;
        }
    }


    private boolean check(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);

        List<int[]> upgradeCandidates = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid) {
                    return false;
                }
                dsu.union(u, v);
            } else {
                if (s >= mid) {
                    dsu.union(u, v);
                } else if (2 * s >= mid) {
                    upgradeCandidates.add(new int[]{u, v});
                }
            }
        }

        for (int[] edge : upgradeCandidates) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) != dsu.find(v)) {
                if (k <= 0) {
                    return false;
                }
                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);

        for (int node = 1; node < n; node++) {
            if (dsu.find(node) != root) {
                return false;
            }
        }

        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int m = edge[3];

            if (m == 1) {
                if (dsu.find(u) == dsu.find(v)) {
                    return -1;
                }
                dsu.union(u, v);
            }
        }

        int result = -1;
        int l = 1;
        int r = (int) 2e5;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(n, edges, k, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}


class DSU {

    private int[] par;
    private int[] size;
    private int numSets;

    public DSU(int n) {

        par = new int[n];
        size = new int[n];
        numSets = n;

        for (int i = 0; i < n; i++) {
            par[i] = i;// initially each element is parent of itself
            size[i] = 1;//each set initially has size of 1
        }

    }

    //Finds the representative (root) of the set containing element 'i'.
    //Uses path compression optimization.TC-(a(N))
    public int find(int i) {

        if (par[i] == i) {
            return i;
        }

        // Path compression: set the parent of 'i' directly to the root
        return par[i] = find(par[i]);

    }

    public void union(int i, int j) {

        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {

            if (size[rootI] < size[rootJ]) {
                par[rootI] = rootJ;
                size[rootJ] += size[rootI];

            } else {
                par[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }

            numSets--;//numSets decreases as we joined 2

        }

    }

    //Checks if two elements 'i' and 'j' are in the same set

    boolean isConnected(int i, int j) {
        return find(i) == find(j);//if both have the same root/par

    }

}

class Solution {
    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int m = e[3];

            if (m == 1) {//when must to add an edge that forms cycle the return it is  impossible to form a valid spanning tree

                if (dsu.isConnected(u, v)) {//forms a cycle
                    return -1;
                }
            }

            dsu.union(u, v);
        }

        int l = 1;
        int r = 2 * (int) Math.pow(10, 5);
        int ans = -1;
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (check(n, edges, k, mid)) {
                ans = mid;
                l = mid + 1;

            } else {
                r = mid - 1;
            }

        }

        return ans;
    }

    public boolean check(int n, int[][] edges, int k, int mid) {

        DSU dsu = new DSU(n);
        List<int[]> upgradeList = new ArrayList<>();

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int m = e[3];

            if (m == 1) {

                if (s < mid) {
                    return false;
                }

                if (dsu.isConnected(u, u)) {
                    return false;
                }
                dsu.union(u, v);

            } else {

                if (s >= mid && !dsu.isConnected(u, v)) {
                    dsu.union(u, v);

                } else if (2 * s >= mid) {

                    upgradeList.add(new int[]{u, v});

                }

            }

        }

        //now handle the upgrade List

        for (int[] a : upgradeList) {

            int u = a[0];
            int v = a[1];

            if (k <= 0) {
                return false;
            }

            if (!dsu.isConnected(u, v)) {
                dsu.union(u, v);
                k--;//used one upgrade operation
            }

        }

        //checking whether all nodes covered or not?

        int root = dsu.find(0);
        for (int i = 1; i <= n - 1; i++) {

            if (dsu.find(i) != root)
                return false;

        }

        return true;

    }

}
