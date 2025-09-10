package Arrays;

//Maximum SubArray Sum

import java.util.Arrays;

public class KadaneAlgo {

    public static void main(String[] args) {

        int[] arr={2,4,6,-8,8,10};
        System.out.println("Maximum SubArray Sum using Kadane's Algorithm : "+kadaneAlgo(arr));
        System.out.println("Maximum SubArray sum using Brute Force :  "+bruteForceMaxSubArray(arr));
        System.out.println("Maximum SubArray sum using Better Approach :  "+prefixSumApp(arr));
        int[] ans=kadaneAlgo2(arr);
        System.out.println("SubArray which gave Maximum sum : ");
        printArray(ans);

    }


    //Brute Force
    public static int bruteForceMaxSubArray(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int n=arr.length;

        for(int start=0; start<n; start++){

            for(int end= start;end<n;end++){
                int currSum=0;
                for(int i=start;i<=end;i++){

                    currSum+=arr[i];

                }
                maxSum=Math.max(maxSum,currSum);

            }

        }
        return maxSum;
    }

   //Better Approach
    public static int prefixSumApp(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int maxSum = Integer.MIN_VALUE;

        prefix[0] = arr[0];

        //Building Prefix Sum Array
        for (int i = 1; i < n; i++) {

            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int start = 0; start < n; start++) {

            for (int end = start; end < n; end++) {
                int currSum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];
                maxSum = Math.max(maxSum, currSum);

            }

        }
        return maxSum;
    }


//Optimal Approach
    public static int kadaneAlgo(int[] arr){

        int currSum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){

            currSum=Math.max(currSum+arr[i],arr[i]);
            maxSum=Math.max(maxSum,currSum);

        }

        return maxSum;
    }

//Finding SubArray which produces maxSum

    public static int[] kadaneAlgo2(int[] arr){

        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        int tempStart=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]+currSum<arr[i]){
                currSum=arr[i];
                tempStart=i;

            }else{
                currSum=currSum+arr[i];
            }

            if(currSum > maxSum){
                maxSum=currSum;
                start=tempStart;
                end=i;

            }

        }

        return Arrays.copyOfRange(arr,start,end+1);
    }


    public static void printArray(int[] arr){

        for(int i:arr){
            System.out.print(i+" ");
        }
    }




}
