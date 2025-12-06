package Hashing;

import java.util.HashSet;
import java.util.Set;

public class Union_And_Intersection {


    public static void main(String[] args) {

        int[] arr1={7,3,9};
        int[] arr2={6,3,9,2,9,4};

        findUnion(arr1,arr2);
        findInterSec(arr1,arr2);

    }

    //TC-O(N)
    public static void  findUnion(int[] arr1,int[] arr2){

        Set<Integer> set=new HashSet<>();

        for(int n: arr1){
            set.add(n);
        }

        for(int n:arr2){
            set.add(n);
        }

        System.out.println("Union set of two arrays  Contains : "+set);

    }

    public static void findInterSec(int[] arr1,int[] arr2){

        Set<Integer>set=new HashSet<>();


        for(int n:arr1){
            set.add(n);
        }

        System.out.print("Intersection set Contains : [");
        for(int n: arr2){

            if(set.contains(n)){
                System.out.print(n+" ");
                set.remove(n);
            }

        }
        System.out.print("]");
    }


}
