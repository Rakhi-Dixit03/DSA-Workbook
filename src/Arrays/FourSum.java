package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FourSum {


    public static void main(String[] args) {
        int[] arr={2,-3,-1,3,1,0,7,3,-4};
        int target=0;
        System.out.println("Four Sum Brute Force : ");

        ArrayList<ArrayList<Integer>>list=fourSum1(arr,target);

        for(ArrayList<Integer> l : list){
            System.out.print(l.toString());
        }


    }

    //Brute Force O(N^3)
    public static ArrayList<ArrayList<Integer>> fourSum1(int[] arr, int target){

        Set<ArrayList<Integer>> set=new HashSet<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){

                        if(arr[i]+arr[j]+arr[k]+arr[l]==target){
                            ArrayList<Integer>temp=new ArrayList<>(java.util.Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                            temp.sort(null);
                            set.add(temp);
                        }

                    }
                }

            }
        }
        return new ArrayList<>(set);

    }


    //Better Approach O(N^2)
    public static ArrayList<ArrayList<Integer>> fourSum2(int[] arr, int target){

        Set<ArrayList<Integer>> set=new HashSet<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer>lookUpSet=new HashSet<>();//Storing values between j to k

                 for(int k=j+1;k<n;k++){
                     int l=-(arr[i]+arr[j]+arr[k]);
                     if(lookUpSet.contains(l)){

                         ArrayList<Integer>temp=new ArrayList<>(java.util.Arrays.asList(arr[i],arr[j],arr[k],l));
                         temp.sort(null);
                         set.add(temp);

                     }
                     lookUpSet.add(arr[k]);
                 }

            }
        }
        return new ArrayList<>(set);

    }

    //Optimal Approach Using Two pointers
    //TC-O(n * log n) +O(N^2)

    public static ArrayList<ArrayList<Integer>> fourSum3(int[] arr, int target){
        int n=arr.length;
        java.util.Arrays.sort(arr);//Sorting Array

        ArrayList<ArrayList<Integer>>list=new ArrayList<>();

        for (int i=0; i < n; i++) {
            //Fixing 1st Pointer
            if (i > 0 && arr[i] == arr[i - 1]) continue; //Skipping duplicates

            for(int j=i+1;j<n;j++){
                //Fixing 2nd Pointer
                if (j> i+1 && arr[j] == arr[j - 1]) continue; //Skipping duplicates

                int k=j+1;//Creating Two moving Pointers
                int l=n-1;

                while(k<l){

                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==target){
                        ArrayList<Integer>temp=new ArrayList<>(java.util.Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        list.add(temp);
                        k++;
                        l--;

                        //Skipping duplicates
                        while(k<l && arr[k]==arr[k-1])k++;
                        while(k<l && arr[l]==arr[l+1])l--;

                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }

                }

            }

        }
        return list;

    }


}
