package Graph;

import java.util.*;

public class Min_Jump_To_Reach_Des {


    boolean[] isPrime;

    public void buildSieve(int maxEle) {

        //Mark all indices in isPrime true initially

        for (int i = 2; i <= maxEle; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= maxEle; i++) {

            if (isPrime[i]) {
                for (int multiple = i * i; multiple <= maxEle; multiple += i) {
                    isPrime[multiple] = false;
                }
            }

        }

    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        //Build map of nums[i] and indices
        for (int i = 0; i < n; i++) {

            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            max = Math.max(max, nums[i]);
        }

        isPrime = new boolean[max + 1];
        //Build Seive

        buildSieve(max);

        boolean[] vis = new boolean[n];//track index visit
        Set<Integer> set = new HashSet<>();//Track prime number visit

        Queue<Integer> q = new LinkedList<>();
        int steps = 0;
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == n - 1)
                    return steps;

                if (curr - 1 >= 0 && !vis[curr - 1]) {
                    q.add(curr - 1);
                    vis[curr - 1] = true;
                }

                if (curr + 1 <= n - 1 && !vis[curr + 1]) {
                    q.add(curr + 1);
                    vis[curr + 1] = true;
                }

                if (!isPrime[nums[curr]] || set.contains(nums[curr])) {
                    continue;

                }

                for (int multiple = nums[curr]; multiple <= max; multiple += nums[curr]) {

                    if (!map.containsKey(multiple)) {
                        continue;
                    }

                    for (int idx : map.get(multiple)) {

                        if (!vis[idx]) {
                            q.add(idx);
                            vis[idx] = true;
                        }

                    }

                    set.add(nums[curr]);

                }

            }

            steps++;

        }

        return steps;
    }



}
