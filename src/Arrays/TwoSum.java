package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr={2,4,6,10,0};
        int target=14;
        int[] ans1=twoSum1(arr,target);
        int[] ans2=twoSum2(arr,target);


        System.out.println("Two sum using Brute Force : "+java.util.Arrays.toString(ans1));
        System.out.println("Two sum using Optimal Solution : "+java.util.Arrays.toString(ans2));

    }

    //Brute Force
    public static int[] twoSum1(int[] arr,int target){
         int n=arr.length;
        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){

                if(arr[i]+arr[j]==target){
                    return new int[]{i,j};
                }

            }
        }
        return new int[]{};
    }

     //HashMap Approach

    public static int[] twoSum2(int[] arr,int target){

        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();//key-number value-it's index

        for(int i=0;i<n;i++){

            int complement=target-arr[i];

            if(map.containsKey(complement)){

                return new int[]{i,map.getOrDefault(complement,0)};

            }
            map.put(arr[i],i);

        }
        return new int[]{};
    }



}




