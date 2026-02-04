package Arrays;

import java.util.ArrayList;

public class Trionic_Arr_2 {


    public static void main(String[] args) {

        System.out.println("Maximum Sum of a Trionic SubArray : " + maxSumTrionic(new int[]{0, -2, -1, -3, 0, 2, -1}));

    }

    static class Pair {

        int p, q;
        long sum;

        public Pair(int p, int q, long sum) {

            this.p = p;
            this.q = q;
            this.sum = sum;

        }

    }


    public static long maxSumTrionic(int[] nums) {
        long ans = Long.MIN_VALUE;
        int n = nums.length;

        ArrayList<Pair> decSeg = new ArrayList<>();
        // First stage: Get all strictly decreasing segment O(n)
        for (int i = 0; i < n - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                int left = i;
                long sum = nums[i];

                while (i < n - 1 && nums[i] > nums[i + 1]) {

                    ++i;
                    sum += nums[i];

                }
                decSeg.add(new Pair(left, i, sum));

            }
        }

        // second stage: find the strictly increasing parts

        for (Pair pair : decSeg) {

            int p = pair.p;
            int q = pair.q;
            long sum = pair.sum;

            long lMax = Long.MIN_VALUE, rMax = Long.MIN_VALUE;

            long lCur = 0, rCur = 0;

            while (p > 0 && nums[p - 1] < nums[p]) {
                lCur += nums[--p];
                lMax = Math.max(lMax, lCur);

            }

            while (q < n - 1 && nums[q] < nums[q + 1]) {
                rCur += nums[++q];
                rMax = Math.max(rMax, rCur);

            }

            if (p != pair.p && q != pair.q) {//they have changed means we found valid inc. parts
                ans = Math.max(ans, lMax + sum + rMax);

            }
        }

        return ans;
    }
}



