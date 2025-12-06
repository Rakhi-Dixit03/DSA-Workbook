package dynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

// Count Partitions With Max-Min Difference at Most K
//Solid combination of sliding window,dp and prefix sum,queues
public class Count_Partitions_with_MIN_MAX_Diff {

    public static void main(String[] args) {

        int[] arr={9,4,1,3,7};
        int k=4;
        System.out.println("Number of ways to partition array  :  "+countPartitions(arr,k));


    }


    static int MOD = 1_000_000_007;

    public static int countPartitions(int[] nums, int k) {

        int n = nums.length;
        long sum = 0;

        long[] dp = new long[n + 1];//state dp[i] - number of ways to make valid partitions considering first i elements[0...i-1]
        dp[0]=1;//there is exactly one way to partition an empty array [do nothing]

        Deque<Integer> max = new ArrayDeque<>();//monotonic decreasing deque to get maximum element in O(1)
        Deque<Integer> min = new ArrayDeque<>();//monotonic increasing deque to get minimum element  in O(1)

        int l = 0;//left pointer of window

        for (int r = 0; r < n; r++) {//right pointer [ending index of a segment]

            while (!max.isEmpty() && nums[max.peekLast()] <= nums[r]) {//that element will never become maximum
                max.pollLast();

            }

            while (!min.isEmpty() && nums[min.peekLast()] >= nums[r]) { //that removed element will never become minimum
                min.pollLast();
            }

            //add elements' index in both deque

            max.add(r);
            min.add(r);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
                //Shrink the window

                if (max.peekFirst() == l)
                    max.pollFirst();//maintaining correct window indices in deque
                if (min.peekFirst() == l)
                    min.pollFirst();

                sum = ((sum - dp[l]) + MOD) % MOD;//preventing sum from becoming negative
                //updating sum because now window till l will no longer be part of our new window

                l++;

            }

            sum = (sum + dp[r]) % MOD;//all valid partitions [l...r]

            dp[r + 1] = sum;

        }
        return (int) dp[n];

    }


}
