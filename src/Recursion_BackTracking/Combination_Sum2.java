package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum2 {

    public static void main(String[] args) {

        int[] candidates={10,1,2,7,6,1,5};
        int target=8;

        List<List<Integer>> ans = new ArrayList<>();

        java.util.Arrays.sort(candidates);
        backTrack(candidates,ans,new ArrayList<>(),target,0);
        System.out.println("Combinations having sum equal to target   : "+ans.toString());


    }

    private static void backTrack(int[] candidates, List<List<Integer>> ans, List<Integer> currList, int target, int idx) {


        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }


        for (int i = idx; i < candidates.length; i++) {

            if (target < candidates[i]) break;//Pruning

            //skipping duplicates
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            currList.add(candidates[i]);

            backTrack(candidates, ans, currList, target - candidates[i], i + 1);
            //Back Track
            currList.remove(currList.size() - 1);

        }


    }


}