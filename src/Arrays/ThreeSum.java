package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//3Sum Problem
//We have to find All Triplets that add up to target Sum
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr={2,-3,-1,3,1,0,7};
        int target=0;
        System.out.println("Three Sum Brute Force : ");
        ArrayList<ArrayList<Integer>>list=threeSum1(arr,target);

       for(ArrayList<Integer> l : list){
           System.out.print(l.toString());
       }


    }

    //Brute Force O(N^3)
    public static ArrayList<ArrayList<Integer>> threeSum1(int[] arr, int target){

        Set<ArrayList<Integer>> set=new HashSet<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){

                    if(arr[i]+arr[j]+arr[k]==target){
                        ArrayList<Integer>temp=new ArrayList<>(java.util.Arrays.asList(arr[i],arr[j],arr[k]));
                        temp.sort(null);
                        set.add(temp);
                    }

                }

            }
        }
        return new ArrayList<>(set);

    }


    //Better Approach O(N^2)
    public static ArrayList<ArrayList<Integer>> threeSum2(int[] arr, int target){

        Set<ArrayList<Integer>> set=new HashSet<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            Set<Integer>lookUpSet=new HashSet<>();//Storing values between i to j
            for(int j=i+1;j<n;j++){

                int k=-(arr[i]+arr[j]);

                if(lookUpSet.contains(k)){

                    ArrayList<Integer>temp=new ArrayList<>(java.util.Arrays.asList(arr[i],arr[j],k));
                    temp.sort(null);
                    set.add(temp);

                }
                lookUpSet.add(arr[j]);
            }
        }
        return new ArrayList<>(set);

    }

    //Optimal Approach Using Two pointers
    //TC-O(n * log n) +O(N^2)

    public static ArrayList<ArrayList<Integer>> threeSum3(int[] arr, int target){
        int n=arr.length;
        java.util.Arrays.sort(arr);//Sorting Array

        ArrayList<ArrayList<Integer>>list=new ArrayList<>();

        for (int i=0; i < n; i++) {
            //Fixing one Pointer
            int j=i+1;//Two moving Pointers
            int k=n-1;

            if (i != 0 && arr[i] == arr[i - 1]) continue;

            while(j<k){

                int sum=arr[i]+arr[j]+arr[k];
                if(sum==target){
                    ArrayList<Integer>temp=new ArrayList<>(java.util.Arrays.asList(arr[i],arr[j],arr[k]));
                    list.add(temp);
                    j++;
                    k--;
                    //Skipping the  duplicates
                    while(j<k && arr[j]==arr[j-1])j++;
                    while(j<k && arr[k]==arr[k+1])k--;

                }else if(sum<target){
                    j++;
                }else{
                    k--;
                }

            }

        }
        return list;

    }

}
