package Hashing;

import java.util.*;

public class Sum_Of_Distances {
    //Calculating sum of absolute differences for identical elements using prefix sums and
    // frequency counts in two passes.
    //TC-O(N),SC-O(2N)

    public static void main(String[] args) {
        System.out.println("Sum of Distances : " + Arrays.toString(distance(new int[]{1, 3, 1, 1, 2})));
    }

    public static long[] distance(int[] nums) {

        int n = nums.length;
        long[] arr = new long[n];

        Map<Integer, Long> sumMap = new HashMap<>();//nums[i] and sum of indices where it is present
        Map<Integer, Long> freqMap = new HashMap<>();//nums[i] and its frequency

        //Left to Right
        for (int i = 0; i < n; i++) {

            long dis = i * freqMap.getOrDefault(nums[i], 0L) - sumMap.getOrDefault(nums[i], 0L);

            arr[i] = dis;

            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0L) + 1);
            sumMap.put(nums[i], sumMap.getOrDefault(nums[i], 0L) + i);

        }

        //Clear Both Maps to use in further Processing
        sumMap.clear();//Takes O(N) time
        freqMap.clear();

        // Right to Left
        for (int i = n - 1; i >= 0; i--) {

            long dis = sumMap.getOrDefault(nums[i], 0L) - i * freqMap.getOrDefault(nums[i], 0L);

            arr[i] += dis;

            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0L) + 1);
            sumMap.put(nums[i], sumMap.getOrDefault(nums[i], 0L) + i);

        }

        return arr;
    }


}
