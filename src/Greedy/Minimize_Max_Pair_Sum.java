package Greedy;
//Greedy+Two-Pointers+Sorting

public class Minimize_Max_Pair_Sum {

    public static void main(String[] args) {


        System.out.println("Minimised Maximum Pair Sum : "+minPairSum(new int[]{3,5,4,2,4,6}));

    }
    //TC-O(NlogN) due to sorting
    public static int minPairSum(int[] nums) {

        java.util.Arrays.sort(nums);

        int l=0;
        int r=nums.length-1;
        int maxSum=Integer.MIN_VALUE;
        while(l<r){


            int sum=nums[l]+nums[r];

            if(sum>maxSum){
                maxSum=sum;

            }

            l++;
            r--;

        }
        return maxSum;
    }

}
