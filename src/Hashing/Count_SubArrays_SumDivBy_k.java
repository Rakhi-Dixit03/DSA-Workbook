package Hashing;

import java.util.HashMap;
import java.util.Map;
//PrefixSum + Hashing
public class Count_SubArrays_SumDivBy_k {

    public static void main(String[] args) {

        int[] nums={4,5,0,-2,-3,1};
        int k=5;

        System.out.println("SubArrays count whose sum is divisible by k : "+subArraysDivByK(nums,5));

    }

    public static int subArraysDivByK(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();//keeping the count of remainder

        int currSum=0;
        int count=0;
        //    map.put(0,1);//to account for prefixSum=0

        for(int n:nums){

            currSum=((currSum+n)%k+k)%k;//prefixSum%k

            if(currSum==0)count+=1; //if currSum==0 then increment count to count subArray [0...i]

            if(map.containsKey(currSum)){
                count+=map.get(currSum);
            }

            map.put(currSum,map.getOrDefault(currSum,0)+1);

        }

        return count;
    }

}
