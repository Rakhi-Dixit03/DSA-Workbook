package Hashing;

import java.util.*;

//TC - O(NLog(Log(M)))
//SC - O(N)
public class Max_Num_Of_Ele_In_A_Subset {

    public static int maximumLength(int[] numbers) {

        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : numbers)
            map.put(num, map.getOrDefault(num, 0) + 1);


        // Special case for 1s

        int ones = map.getOrDefault(1, 0);
        if ((ones & 1) == 1) {

            maxLength = ones;
        } else {
            maxLength = Math.max(maxLength,ones-1);//since count of ones can be zero and subtracting 1 make it negative
        }

        map.remove(1);

        long curr;

        for (int key : map.keySet()) {

            int length = 0;
            curr = key;


            while (curr <= Integer.MAX_VALUE && map.containsKey((int)curr) && map.get((int)curr) >= 2) {

                length += 2;
                curr *= curr;

            }

            length += (map.containsKey((int)curr) ? 1 : -1);

            maxLength = Math.max(maxLength, length);

        }

        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println("Maximum Number of elements in a subset are : "+maximumLength(new int[]{5,4,1,2,2}));
    }


}
