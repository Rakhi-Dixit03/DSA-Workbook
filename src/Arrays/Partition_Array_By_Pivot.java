package Arrays;

import java.util.*;

public class Partition_Array_By_Pivot {

    public int[] pivotArray(int[] nums, int pivot) {
        LinkedList<Integer> less = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();
        LinkedList<Integer> greater = new LinkedList<>();
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal.add(num);
            }
        }
        less.addAll(equal);
        less.addAll(greater);

        int i = 0;
        int[] ans = new int[nums.length];
        for (int num : less) {
            ans[i++] = num;
        }
        return ans;
    }
}


