package Arrays;

import java.util.*;
public class Min_Pair_Removal_to_Make_Arr_Sorted {


    public static void main(String[] args) {

        int[] nums={5,2,3,1};
        Min_Pair_Removal_to_Make_Arr_Sorted obj=new Min_Pair_Removal_to_Make_Arr_Sorted();

        System.out.println("Minimum number of Operations to make array Sorted :  "+obj.minimumPairRemoval(nums));
        System.out.println("Minimum number of Operations to make array Sorted :  "+obj.minimumPairRemoval2(nums));


    }

    //TC-O(N^3)

    public int minimumPairRemoval(int[] nums) {

        List<Integer>list=new ArrayList<>();

        int operations=0;


        for(int num:nums){
            list.add(num);
        }

        while(!isSorted(list)){

            int idx = getMinSumPairIdx(list);
            int minSum = list.get(idx)+list.get(idx+1);

            list.set(idx,minSum);//replaced with minSum
            list.remove(idx+1);//Removed the pair
            operations++;

        }

        return operations;

    }


    private boolean isSorted(List<Integer>list){

        for(int i=0;i<list.size()-1;i++){

            if(list.get(i)>list.get(i+1)){
                return false;

            }

        }

        return true;

    }

    //This will return the Index of the pair which has minimum Sum

    private int getMinSumPairIdx(List<Integer>list){

        int minSum=Integer.MAX_VALUE;
        int minSumPairIdx = -1;

        for(int i=0;i<list.size()-1;i++){

            int adjPairSum=list.get(i)+list.get(i+1);

            if(adjPairSum<minSum){

                //Update minSum
                minSum=adjPairSum;
                minSumPairIdx=i;

            }

        }

        return minSumPairIdx;

    }

    //TC-O(N^2)

    public int minimumPairRemoval2(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int operations = 0;

        for (int num : nums) {
            list.add(num);
        }

        while (list.size() > 1) {//As array of size 1 will be explicitly a sorted array

            var isSorted = true;

            int minSum = Integer.MAX_VALUE;
            int minSumPairIdx = -1;

            for (int i = 0; i < list.size() - 1; i++) {//Finding minSumPairIdx

                if(list.get(i)>list.get(i+1)){
                    isSorted=false;
                }

                int adjPairSum = list.get(i) + list.get(i + 1);

                if (adjPairSum < minSum) {

                    //Update minSum
                    minSum = adjPairSum;
                    minSumPairIdx = i;

                }

            }

            if(isSorted){
                break;
            }

            list.set(minSumPairIdx, minSum);//replaced with minSum
            list.remove(minSumPairIdx + 1);//Removed the pair
            operations++;

        }

        return operations;

    }

}
