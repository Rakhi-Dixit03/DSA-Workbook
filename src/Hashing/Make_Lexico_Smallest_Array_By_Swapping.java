package Hashing;

import java.util.*;

public class Make_Lexico_Smallest_Array_By_Swapping {

    public static int[] lexicographicallySmallestArray(int[] numbers, int limit) {
        int n = numbers.length;
        int[] vec = numbers.clone();
        Arrays.sort(vec);

        int groupNum = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(vec[0], groupNum);
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(vec[0]);

        for (int i = 1; i < n; i++) {
            if (Math.abs(vec[i] - vec[i - 1]) > limit) {
                groupNum++;
            }
            numToGroup.put(vec[i], groupNum);
            groupToList.putIfAbsent(groupNum, new LinkedList<>());
            groupToList.get(groupNum).add(vec[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = numbers[i];
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).pollFirst(); // Use and remove the smallest element
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,9,8};
        System.out.println("Array is : "+Arrays.toString(lexicographicallySmallestArray(arr,2)));
    }

}
