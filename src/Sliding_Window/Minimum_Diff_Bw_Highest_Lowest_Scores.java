package Sliding_Window;

public class Minimum_Diff_Bw_Highest_Lowest_Scores {

    public static void main(String[] args) {

        int[] nums={9,4,1,7};

        System.out.println("Minimum Difference Between Highest and lowest Scores : "+minimumDifference(nums,2));
        
    }

    public static int minimumDifference(int[] nums, int k) {

        int n=nums.length;

        if(n==1){
            return 0;
        }

        java.util.Arrays.sort(nums);
        int minDiff=Integer.MAX_VALUE;

        for(int i=0;i<=n-k;i++){

            int diff=nums[i+k-1]-nums[i];//MaxElement - minElement difference in a  window
            minDiff=Math.min(minDiff,diff);

        }

        return minDiff;

    }


}
