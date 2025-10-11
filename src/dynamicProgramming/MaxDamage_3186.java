package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaxDamage_3186 {

    public static void main(String[] args) {

        int[] power={1,1,3,4};
        System.out.println(maximumTotalDamage(power));
        System.out.println(maximumTotalDamage1(power));


    }



    public static long maximumTotalDamage(int[] power) {
        int n=power.length;

        Map<Long,Long> map=new HashMap<>();
        long[] dp=new long[n];
        java.util.Arrays.fill(dp,-1);

        //Storing freq in a map

        for(int i=0;i<power.length;i++){

            map.put((long)power[i],map.getOrDefault((long)power[i],0L)+1);
        }

        long[] nums=new long[map.size()];

        int i=0;
        //Building array of unique values
        for(long val:map.keySet()){

            nums[i]=val;

            i++;

        }

        //Sort array
        java.util.Arrays.sort(nums);

        return solve(nums,0,map,dp);

    }

    static long solve(long[] nums,int i,Map<Long,Long>map,long[] dp){
        int n=nums.length;
        //Base case
        if(i>=n)return 0;

        if(dp[i]!=-1)return dp[i];

        //skip
        long skip=solve(nums,i+1,map,dp);

        //Calculate lower bound

        int j=lowerBound(nums,(nums[i]+3),i+1);

        //Take

        long take=solve(nums,j,map,dp)+nums[i]*map.getOrDefault(nums[i],0L);


        return dp[i]=Math.max(skip,take);


    }

    static int lowerBound(long[] nums,long tar,int stIdx){

        int l=stIdx;
        int h=nums.length;

        while(l<h){

            int mid=l+(h-l)/2;

            if(nums[mid]>=tar){
                h=mid;

            }else{
                l=mid+1;
            }

        }
        return l;

    }


  static  public long maximumTotalDamage1(int[] power) {
        int n=power.length;

        Map<Long,Long> map=new HashMap<>();

        //Storing freq in a map

        for(int i=0;i<power.length;i++){

            map.put((long)power[i],map.getOrDefault((long)power[i],0L)+1);
        }

        long[] nums=new long[map.size()];
        long[] dp=new long[nums.length+1];

        int i=0;
        //Building array of unique values
        for(long val:map.keySet()){

            nums[i]=val;

            i++;

        }

        //Sort array
        java.util.Arrays.sort(nums);

        for(int m=nums.length-1;m>=0;m--){


            //Take
            int j= lowerBound(nums,nums[m]+3L, m>=n?0:m+1);

            long take=dp[j]+nums[m]*map.getOrDefault(nums[m],0L);


            //Skip

            long skip= dp[m+1];

            dp[m]=Math.max(take,skip);



        }
        return dp[0];
    }


}
