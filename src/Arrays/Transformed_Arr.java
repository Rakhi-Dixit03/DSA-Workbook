package Arrays;

public class Transformed_Arr {


    public int[] constructTransformedArray(int[] nums) {
        int n= nums.length;
        int[] res=new int[n];

        for(int i=0;i<n;i++){


            int newIdx=i;

            if(nums[i]>0){

                newIdx+=nums[i];

                res[i]=nums[newIdx%n];

            }else if(nums[i]<0){

                newIdx+=nums[i];

                res[i]=nums[((newIdx%n)+n)%n];//negative wrapping

            }else{

                res[i]=nums[i];
            }

        }
        return res;
    }


}
