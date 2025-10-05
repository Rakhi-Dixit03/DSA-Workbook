package Recursion_BackTracking;

import java.util.ArrayList;

public class Subsets {


    public static void main(String[] args) {

        int[] arr={1,2,3};
        int[] arr2={2,1,2};
        java.util.Arrays.sort(arr2);
//        printSubsets1(arr,arr.length,0,new ArrayList<>());
        printSubsets2(arr2,arr2.length,0,new ArrayList<>());
    }


    public static void printSubsets1(int[] arr, int n, int i, ArrayList<Integer> subset){

        //Base case
        if(i==n){
            System.out.print(subset.toString()+"  ");
            return;
        }


        //Case 1 Take
        subset.add(arr[i]);
        printSubsets1(arr,n,i+1,subset);

        //Case 2 not take
        //BACKTRACKING
         subset.remove(subset.size()-1);

         printSubsets1(arr,n,i+1,subset);


    }


    public static void printSubsets2(int[] arr, int n, int i, ArrayList<Integer> subset){

        //Base case
        if(i==n){
            System.out.print(subset.toString()+"  ");
            return;
        }


        //Case 1 Take
        subset.add(arr[i]);
        printSubsets2(arr,n,i+1,subset);

        //Case 2 not take
        //BACKTRACKING
        subset.remove(subset.size()-1);

        int idx=i+1;
        while(idx< arr.length && arr[idx]==arr[idx-1]) idx++;

        printSubsets2(arr,n,idx,subset);


    }


}
