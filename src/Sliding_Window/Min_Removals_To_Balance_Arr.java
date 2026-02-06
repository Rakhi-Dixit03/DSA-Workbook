package Sliding_Window;

public class Min_Removals_To_Balance_Arr {

    public static void main(String[] args) {

        System.out.println("Minimum Removals to balance  Array : "+minRemoval(new int[]{1,6,2,9},3));
    }

    public static int minRemoval(int[] nums, int k) {

        int removals=Integer.MAX_VALUE;
        int n=nums.length;
        java.util.Arrays.sort(nums);

        int r=0;

        for(int l=0;l<n;l++){

            while(r<n && nums[r]<=k*1L*nums[l]){
                r++;
            }
            removals=Math.min(removals,n-(r-l));

        }

        return removals;

    }





}
