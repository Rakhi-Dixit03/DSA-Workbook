package Arrays;

import java.util.*;

public class Longest_Balanced_SubArr {


    public static void main(String[] args) {

        System.out.println("Length of Longest Balanced SubArray  is : "+longestBalanced(new int[]{2, 5, 4, 3}));
    }

    //Brute Force O(N^2)
    public static int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {

                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);

                if (even.size() == odd.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }


}
