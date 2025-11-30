package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrays_Sum_EqualsK {

    public static void main(String[] args) {

        int[] nums={1,2,3};
       int k=3;

        System.out.println("Number of SubArrays having Sum equal to k  : "+subArraySum(nums,k));

    }

    public static int subArraySum(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>(); //for keeping the sum frequencies
        int currSum=0;
        int count=0;

        for(int n:nums){

            currSum+=n;

            if(currSum==k)count++;

            int prev=currSum-k;

            if(map.containsKey(prev)){

                count+=map.getOrDefault(prev,0);

            }

            map.put(currSum,map.getOrDefault(currSum,0)+1);

        }


        return count;


    }


}
