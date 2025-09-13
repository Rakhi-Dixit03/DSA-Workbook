package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merged Intervals : "+mergeIntervals(intervals).toString());
    }


    //TC-O(N*LogN)
    //SC-O(N)

    public static List<List<Integer>> mergeIntervals(int[][] intervals){

        //Sort By start Time for efficient Processing
        List<List<Integer>>ans = new ArrayList<>();
        java.util.Arrays.sort(intervals,(a,b)->a[0]-b[0]);


        for(int[] interval : intervals){

            if(ans.isEmpty() || interval[0] > ans.get(ans.size()-1).get(1)){
                //Not an Overlapping interval

                ans.add(Arrays.asList(interval[0],interval[1]));

            }else{
                // Overlapping interval needs Merging

                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),interval[1]));

            }


        }

        return ans;
    }


}
