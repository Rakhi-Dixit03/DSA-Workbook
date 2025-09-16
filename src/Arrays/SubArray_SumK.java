package Arrays;

import java.util.HashMap;
import java.util.Map;

// Number of SubArrays sum Equal to k
public class SubArray_SumK {

    public static void main(String[] args) {
         int[] arr={1,2,3};
         int k=3;
        System.out.println("Number of SubArrays whose Sum equal to k are Solution 1 :  "+subArraySum_k1(arr,k));
        System.out.println("Number of SubArrays whose Sum equal to k are Solution 2 :  "+subArraySum_k2(arr,k));
        System.out.println("Number of SubArrays whose Sum equal to k are  Solution 3 :  "+subArraySum_k3(arr,k));
    }

    //Better Approach O(N^2)
    public static int subArraySum_k1(int[] arr,int k){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int sum=0;
                for(int m=i;m<=j;m++){
                    sum+=arr[m];
                }
                if(sum==k){
                    count++;

                }

            }

        }
        return count;
    }


    //Better Approach O(N^2)
    public static int subArraySum_k2(int[] arr,int k){
       int n=arr.length;
       int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];

                if(sum==k){
                    count++;

                }

            }

        }
       return count;
    }

    //Optimised One using Prefix Concept with HashMap

    public static int subArraySum_k3(int[] arr,int k){

        Map<Integer,Integer>map=new HashMap<>();//Storing prefixes(x-k) and their counts

        map.put(0,1);
        int prefixSum=0;
        int count=0;

        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            int remove=prefixSum-k;

            count+=map.getOrDefault(remove,0);

            //Updating prefix Sum frequency in the map
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);

        }
        return count;
    }







}
