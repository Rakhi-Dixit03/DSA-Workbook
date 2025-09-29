package Arrays;

import java.util.Arrays;

public class Next_Permutation {

    public static void main(String[] args) {

        int[] arr={3,2,1};
        System.out.println("Next Permutation Optimal Approach : "+ Arrays.toString(nextPermutation(arr)));
    }

    //Optimal Solution
    public static int[] nextPermutation(int[] arr){

        //Finding breaking point /Pivot
        int idx=-1;

        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }

        }

        if (idx == -1) {
            reverse(arr,0,arr.length-1);
            return arr;
        }

        //Looking for slightly larger number to swap it with to make permutation larger than the actual one
       //We are starting from backside because there we have elements sorted in reverse order (small to large)

        for(int i=arr.length-1;i>=idx;i--){

            if(arr[i]>arr[idx]){
                //Swap
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
                 break;
            }
        }

        reverse(arr,idx+1,arr.length-1);//we want to keep that part as minimum as possible
        return arr;

    }

    public static  void reverse(int[] arr,int start,int end){

        while(start<end){

            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;

        }

    }

}
