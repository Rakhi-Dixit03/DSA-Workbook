package Arrays;

import java.util.*;
public class Min_Abs_Difference {

    public static void main(String[] args) {
       int[] arr={1,3,6,10,15};

        System.out.println("List of Minimum Absolute Difference Pairs : "+minimumAbsDifference(arr));

    }


    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>pairs=new ArrayList<>();

        int minAbsDiff=Integer.MAX_VALUE;
        int n=arr.length;

        Arrays.sort(arr);

        for(int i=0;i<n-1;i++){

            int diff=Math.abs(arr[i+1]-arr[i]);

            if(diff<minAbsDiff){

                minAbsDiff=diff;

            }



        }

        for(int i=0;i<n-1;i++){

            int diff=Math.abs(arr[i+1]-arr[i]);

            if(diff==minAbsDiff){

                pairs.add(new ArrayList<>(Arrays.asList(arr[i],arr[i+1])));
            }


        }

        return pairs;
    }



}
