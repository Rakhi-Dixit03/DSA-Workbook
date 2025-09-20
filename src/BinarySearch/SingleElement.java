package BinarySearch;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class SingleElement {

    public static void main(String[] args) {
        int[] arr={1,1,3,3,4,4,5,5,10};
        System.out.println("Single Element in Sorted Array  using Brute Force : "+singleElement1(arr));
        System.out.println("Single Element in Sorted Array  using Binary Search : "+singleElement2(arr));

    }


    //Brute Force
    public static int singleElement1(int[] arr){

        Map<Integer,Integer> freq=new HashMap<>();//SC-O(N)

        for(int i=0;i<arr.length;i++){//TC-O(N)

            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer,Integer>entry : freq.entrySet()){//TC-O(N)

            if(entry.getValue()==1){
                return entry.getKey();
            }

        }

       return -1;
    }

    //Binary Search
    public static int singleElement2(int[] arr) {

        int low = 0;
        int high = arr.length -1;
        int n= arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;



                if ((mid==0 || arr[mid] != arr[mid - 1]) && (mid==n-1 || arr[mid] != arr[mid + 1]) ){
                    return arr[mid];
                }

                if(mid%2==0){

                    if(arr[mid] == arr[mid - 1]){
                        high = mid - 1;//move left


                    }else{

                        low = mid + 1;//move right
                    }


                }else{

                    if(arr[mid] == arr[mid - 1]){
                        low = mid + 1;//move right
                    }else{

                        high = mid - 1;//move left
                    }

            }

        }
        return -1;

    }
}
