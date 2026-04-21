package Graph;

import java.util.*;

//TC- O(N+N*alpha(n))  alpha(n)- inverse  Ackermann function
//SC-(N)
// Group indices into connected components using Union-Find,
// then compare element frequencies within each component.
public class Minimize_Hamming_Distance {

    static class DSU {

        int[] rank, par;
        int n;

        public DSU(int n) {

            this.n = n;
            rank = new int[n];
            par = new int[n];

            for (int i = 0; i < n; i++) {
                par[i] = i;
            }

        }

        public int find(int i) {

            if (par[i] != i) {

                par[i] = find(par[i]);
            }

            return par[i];
        }

        public void union(int x, int y) {

            int x_root = find(x), y_root = find(y);

            if (x_root == y_root) {//ele in the same set
                return;
            }

            if (rank[x_root] < rank[y_root]) {

                par[x_root] = y_root;
            } else if (rank[x_root] > rank[y_root]) {
                par[y_root] = x_root;

            } else {

                par[y_root] = x_root;
                rank[x_root] += 1;
            }

        }

    }


    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        DSU dsu=new DSU(n);

        dsu.par = new int[n];
        dsu.rank = new int[n];

        for (int i = 0; i < n; i++) {
            dsu.par[i] = i;
        }

        // Union of allowedSwaps
        for (int[] edge : allowedSwaps) {
           dsu.union(edge[0], edge[1]);
        }

        // group -> (value -> freq)
        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);

            groupFreq.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freqMap = groupFreq.get(root);

            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0) + 1);
        }

        int hammingDistance = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            Map<Integer, Integer> freqMap = groupFreq.get(root);

            if (freqMap.getOrDefault(target[i], 0) > 0) {
                freqMap.put(target[i], freqMap.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}

