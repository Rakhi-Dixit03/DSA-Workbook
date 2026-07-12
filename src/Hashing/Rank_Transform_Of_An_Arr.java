package Hashing;

import java.util.*;

//TC-O(NlogN)
//SC-O(N)
//Key Idea:
//Sort unique elements to assign ranks, then map original values using a hash table.

public class Rank_Transform_Of_An_Arr {

    public static int[] arrayRankTransform(int[] arr) {

        int n= arr.length;

        int[] tempArr = Arrays.copyOf(arr,arr.length);

        Arrays.sort(tempArr);

        Map<Integer,Integer> map = new HashMap<>();//for Value-Rank lookup

        int rank =1;

        for(int i=0;i<n;i++){

            if(!map.containsKey(tempArr[i])){
                map.put(tempArr[i],rank);
                rank++;
            }

        }

        int[] ans= new int[n];

        for(int i=0;i<n;i++){

            ans[i]=map.get(arr[i]);


        }

        return ans;

    }


    public static void main(String[] args) {

        System.out.println("After Transformation Array is : "
                +Arrays.toString(arrayRankTransform(new int[]{40,10,20,30})));

    }

}
