package maths_problems;

public class Rotate_Function {

    public static int maxRotateFunction(int[] nums) {
        int n =nums.length;
        int F = 0;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            F+=nums[i]*i;

        }

        int result=F;


        for(int k=0;k<=n-1;k++){

            int newF= F+sum-n*nums[n-1-k];

            result=Math.max(result,newF);
            F=newF;

        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println("Maximum value : "+maxRotateFunction(new int[]{4,3,2,6}));
    }



}
