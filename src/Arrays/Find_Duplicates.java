package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Find_Duplicates {


    public static void main(String[] args) {

        int[] nums={4,3,2,7,8,2,3,1};

        System.out.println(findDuplicates(nums).toString());


    }

    public static List<Integer> findDuplicates(int[] nums) {

        //We can mark visited numbers within the array by flipping the
        //sign of number at that index corresponding that number

        List<Integer>ans=new ArrayList<>();


        for(int i=0;i<nums.length;i++){

            int idx=Math.abs(nums[i])-1; // as elements in the array are in the range[1,n]

            if(nums[idx]<0){
                //means number has been already visited [duplicate]
                ans.add(idx+1);

            }else{

                nums[idx]=-nums[idx]; //Mark it visited

            }

        }

        return ans;
    }


}
