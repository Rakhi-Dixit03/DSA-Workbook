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

//TC-O(N)
//How the  time complexity is O(N)?
//Each index from the original array appears exactly once in some list.
// So if you sum up the sizes of all lists:
//total elements across all lists = N ,so overall the map loop is covering all [N] elements of the array
// 2nd Variation  3741 can also be solved with the same approach
//Group indices by value and find the minimum distance between the
// first and third occurrence in any sorted group.
