package Recursion_BackTracking;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] nums={8,3,5,2,1,0,3};
        System.out.println(Arrays.toString(mergeSort(nums,0,nums.length-1)));


    }


    public static int[] mergeSort(int[] nums,int st,int end){

        if(st>=end){
            return new int[]{nums[st]};
        }

        int mid=st+(end-st)/2;

        //left half
        int[] left=mergeSort(nums,st,mid);
        //right half
        int[] right=mergeSort(nums,mid+1,end);

        return merge(left,right);

    }

    public static int[] merge(int[] left,int[] right){

        int lLen=left.length;
        int rLen=right.length;

        int[] temp=new int[rLen+lLen];

        int i=0,j=0,k=0;

        while(i<lLen && j<rLen){

            if(left[i]<= right[j]){

                temp[k++]=left[i++];
            }else{

                temp[k++]=right[j++];
            }

        }


        while(i<lLen){

            temp[k++]=left[i++];

        }

        while(j<rLen){

            temp[k++]=right[j++];

        }


        return temp;

    }


}



