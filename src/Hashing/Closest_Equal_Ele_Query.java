package Hashing;

import java.util.*;
public class Closest_Equal_Ele_Query {

    public List<Integer> solveQueries(int[] nums, int[] queries) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Map<Integer, ArrayList<Integer>> posMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            posMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        }

        for (ArrayList<Integer> pos : posMap.values()) {
            int x = pos.get(0);
            int last = pos.get(pos.size() - 1);
            pos.add(0, last - n);
            pos.add(x + n);
        }


        for (int q : queries) {

            int ele = nums[q];

            ArrayList<Integer> pos = posMap.get(ele);

            if (pos.size() == 3) {
                ans.add(-1);
                continue;
            }
            int idx = Collections.binarySearch(pos, q);
            if (idx < 0)
                idx = -idx - 1;
            ans.add(Math.min(pos.get(idx) - pos.get(idx - 1), pos.get(idx + 1) - pos.get(idx)));

        }
        return ans;
    }

}
