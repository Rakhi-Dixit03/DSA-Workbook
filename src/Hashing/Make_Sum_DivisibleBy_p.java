package Hashing;

import java.util.HashMap;
import java.util.Map;

//HashMap + PrefixSum
public class Make_Sum_DivisibleBy_p {

    public static void main(String[] args) {

        int[] nums={6,3,5,2};
        int p=9;

        System.out.println("Length of SubArray that need to be removed to " +
                "make subArray divisible by p is : "+minSubArray(nums,p));


    }

    public static int minSubArray(int[] nums, int p) {

        Map<Integer, Integer> map = new HashMap<>();//for Storing  last seen rem [rem,index]
        map.put(0, -1);//to handle cases when subArray to remove will start at the beginning
        int n = nums.length;
        int minLen = n;
        int totSum = 0;

        for (int num : nums) {

            totSum = (totSum + num) % p;//to avoid larger values of sum

        }

        int target = totSum % p;

        if (target == 0)
            return 0;//already divisible

        //otherwise we have to find min-size subarray to remove

        int currSum = 0;//running prefix sum

        for (int i = 0; i < n; i++) {

            currSum = (currSum + nums[i]) % p;

            int prev = (currSum - target + p) % p;//(+p)is to avoid negative remainders

            if (map.containsKey(prev)) {

                int currLen = i - map.get(prev);
                minLen = Math.min(minLen, currLen);

            }

            map.put(currSum, i);//storing currPrefix sum for future processing

        }

        return minLen == n ? -1 : minLen;
    }



}
