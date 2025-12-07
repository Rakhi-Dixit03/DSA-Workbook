package Hashing;

import java.util.HashMap;
import java.util.Map;

public class Largest_SubArray_with_0_Sum {


    public static void main(String[] args) {

        int[] arr={15,-2,2,-8,1,7,10,23};

        System.out.println("Size of Largest SubArray with 0 sum : "+largestSubArray0Sum(arr));


    }
//prefix Sum + HashMap TC-O(N)
    public static int largestSubArray0Sum(int[] arr){

        Map<Integer,Integer>map=new HashMap<>();//(sum,index)

        int preSum=0;
        int maxLen=0;

        for(int j=0;j<arr.length;j++){//sum[i...j]=sum[0..j]-sum[0..i]

            preSum+=arr[j];

            if(map.containsKey(preSum)){

                maxLen=Math.max(maxLen,j-map.get(preSum));

            }else{

                map.put(preSum,j);

            }

        }

        return maxLen;

    }


}
