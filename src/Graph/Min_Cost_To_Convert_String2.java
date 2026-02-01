package Graph;

import java.util.*;



public class Min_Cost_To_Convert_String2 {

    static class Pair {

        String des;
        long cost;

        public Pair(String des, long cost) {
            this.des = des;
            this.cost = cost;
        }

    }

    int n;
    long BIG_VALUE = 10_000_000_000L;

    TreeSet<Integer> lenSet;
    Map<String, List<Pair>> adjList;//Graph
    long[] dpMemo;//for memoization
    String source;
    String target;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        n = source.length();

        this.source = source;
        this.target = target;
        dpMemo = new long[1001];
        Arrays.fill(dpMemo, -1);


        //Build Graph
        adjList = new HashMap<>();

        for (int i = 0; i < original.length; i++) {

            adjList.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Pair(changed[i], cost[i]));

        }

        //TreeSet for tracking the lengths of substrings in original

        lenSet = new TreeSet<>();

        for (String s : original) {

            lenSet.add(s.length());

        }

        long result = solve(0);

        return result == BIG_VALUE ? -1 : result;

    }

    //[solve] is a Recursive method
    private long solve(int i) {

        if (i >= n) {//[i] becomes out of bounds
            return 0;
        }

        if (dpMemo[i] != -1) {
            return dpMemo[i];
        }

        long resultCost = BIG_VALUE;

        if (source.charAt(i) == target.charAt(i)) {//already matching chars(can skip)
            resultCost = solve(i + 1);

        }

        //2nd option is to keep the same char and look for other subStrings

        for (int len : lenSet) {

            if (i + len > n) {//no more substrings
                break;
            }

            String sourceSub = source.substring(i, i + len);
            String tarSub = target.substring(i, i + len);

            if (!adjList.containsKey(sourceSub)) {
                continue;
            }

            //if map contains key then we will find the shortest path to reach tarSubString using dijkstra

            long pathCost = dijkstra(sourceSub, tarSub);

            if (pathCost == BIG_VALUE) {
                //can't find the path,that substring was not right
                continue;//try another subString

            }

            resultCost = Math.min(resultCost, pathCost + solve(i + len));

        }

        return dpMemo[i] = resultCost;

    }

    private long dijkstra(String src, String tar) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        Map<String, Long> result = new HashMap<>();//it stores Source to Target ka minCost

        result.put(src, 0L);

        pq.add(new Pair(src, 0L));//cost to go from src->src=0

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            String node = curr.des;
            long currCost = curr.cost;

            if (node.equals(tar)) {
                break;
            }

            if (adjList.get(node) != null) {
                for (Pair edge : adjList.get(node)) {

                    String neighNode = edge.des;
                    long edgeCost = edge.cost;

                    if (!result.containsKey(neighNode) || currCost + edgeCost < result.get(neighNode)) {
                        //update cost

                        result.put(neighNode, (currCost + edgeCost));
                        pq.add(new Pair(neighNode, (currCost + edgeCost)));

                    }

                }
            }

        }

        long finalCost = BIG_VALUE;
        if (result.get(tar) != null) {
            finalCost = result.get(tar);

        }

        return finalCost;

    }

}
