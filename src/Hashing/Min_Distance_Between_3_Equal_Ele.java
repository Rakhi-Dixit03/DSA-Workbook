package Hashing;

import java.util.*;

//Ques : 3740
//Approach : Grouping indices by value to find the minimum distance among any three identical elements.
public class Min_Distance_Between_3_Equal_Ele {

    public static void main(String[] args) {
        System.out.println("Minimum Distance Between 3 Equal Element : "+minimumDistance(new int[]{5,4,3,2,1,5,5}));
    }
    public static int minimumDistance(int[] nums) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        }

        int minDis = Integer.MAX_VALUE;

        for (ArrayList<Integer> list : map.values()) {

            if (list.size() >= 3) {

                for (int i = 0; i < list.size() - 2; i++) {

                    int dis =2 * Math.abs(list.get(i + 2) - list.get(i));
                    minDis = Math.min(minDis, dis);

                }

            }

        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

}
