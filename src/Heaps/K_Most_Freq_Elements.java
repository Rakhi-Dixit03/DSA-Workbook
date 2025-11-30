package Heaps;

import java.util.*;

public class K_Most_Freq_Elements {

    public static void main(String[] args) {

       int[] nums={1,1,1,2,2,3};
       int k=2;
        System.out.println("K Most Frequent Elements : "+ Arrays.toString(topKFrequent(nums,k)));

    }
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int n : nums) {

            map.put(n, map.getOrDefault(n, 0) + 1);//Building freq map

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.add(new int[] { entry.getKey(), entry.getValue() });

            if (pq.size() > k)
                pq.poll();

        }

        int i = 0;
        while (i < k) {

            if(pq.peek()!=null){

                ans[i] = pq.poll()[0];
            }
            i++;

        }

        return ans;
    }

}
