package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum1 {

   static Set<List<Integer>> set=new HashSet<>();

    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;

        List<List<Integer>> ans = new ArrayList<>();

        backTrack(candidates, ans, new ArrayList<>(), target, 0);
        System.out.println("Combinations having sum equal to target using Recursive Approach1  : "+ans.toString());

        java.util.Arrays.sort(candidates);
        System.out.println("Combinations having sum equal to target using Recursive Approach2  : "+ans.toString());

    }


        private static void backTrack(int[] candidates,List<List<Integer>>ans,List<Integer>currList,int target ,int idx){


            //Base Case

            if(target<0 || idx==candidates.length){
                return;
            }

            if(target==0){

                if(!set.contains(currList)){

                    set.add(new ArrayList<>(currList));
                    ans.add(new ArrayList<>(currList));
                    return;
                }
                return;
            }
            currList.add(candidates[idx]);
//Choice where we are using element multiple times
            backTrack(candidates,ans,currList,target-candidates[idx],idx);

//Back Track
            currList.remove(currList.size()-1);

            backTrack(candidates,ans,currList,target,idx+1);


        }

    //Using Backtracking
        public static void backTrack2(int[] candidates,List<List<Integer>>ans,List<Integer>currList,int tar ,int idx){


        //Base Cases

            if(tar<0){
                return;
            }

            if(tar == 0){
                ans.add(new ArrayList<>(currList));
                return;
            }


            for(int i=idx;i<candidates.length;i++){

                if(tar<candidates[i])break;//Pruning

                //Skipping Duplicates
                if(i>idx && candidates[i]==candidates[i-1])continue;

                currList.add(candidates[i]);

                backTrack2(candidates, ans, currList, tar-candidates[i], i);
                //Back Track

                currList.remove(currList.size()-1);

            }


        }



    }


