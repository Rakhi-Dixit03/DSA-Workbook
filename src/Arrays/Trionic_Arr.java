package Arrays;

public class Trionic_Arr {

    public static void main(String[] args) {

        System.out.println("Is Trionic Array : "+isTrionic(new int[]{1,3,5,4,2,6}));
    }
    public static boolean isTrionic(int[] nums) {

        int i=0;
        int n=nums.length;

        while(i+1<n && nums[i]<nums[i+1]){
            i++;
        }

        if(i==0 || i==n-1){
            return false;
        }

        while(i+1<n && nums[i]>nums[i+1]){
            i++;
        }

        if(i==n-1){
            return false;
        }

        while(i+1<n && nums[i]<nums[i+1]){
            i++;
        }
        //if reached end then return true
        return i == n - 1;

    }




}
