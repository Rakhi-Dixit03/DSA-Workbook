package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {

        int[] stalls={0,3,4,7,10,9};
        int cows=4;
        System.out.println("Minimum Maximum Distance between two cows Linear Search : "+aggressiveCows(stalls,cows));
        System.out.println("Minimum Maximum Distance between two cows by Binary Search : "+aggressiveCows2(stalls,cows));
    }

    //Linear Search  Method
    public static int aggressiveCows(int[] stalls,int cows){
        Arrays.sort(stalls);
        int n=stalls.length;
        int max=stalls[n-1]-stalls[0];

        for(int i=1;i<=max;i++){

               if(canPlace(stalls,i,cows))continue;
               else{
                   return i-1;
               }

        }

       return 0;
    }

    public static boolean canPlace(int[] stalls,int dist,int cows){
        int n=stalls.length;
        int cow=1;
        int lastCow=stalls[0];
        for(int i=1;i<n;i++){

            if(stalls[i]-lastCow>=dist){

                cow++;
                lastCow=stalls[i];
            }

            if(cow>=cows)return true;


        }
        return false;
    }


   //Binary Search

    public static int aggressiveCows2(int[] stalls,int cows){
        int n=stalls.length;
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[n-1];

        while(low<=high){

            int mid=low+(high-low)/2;

            if(canPlace(stalls,mid,cows)){
                low=mid+1;

            }else{
                high=mid-1;
            }


        }

        return high;
    }

}
