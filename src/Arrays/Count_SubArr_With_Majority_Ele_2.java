package Arrays;
import java.util.*;

//TC-O(N)
//SC-O(N)
//Key Idea : Transforming the majority element condition into
// a prefix sum problem where target counts as +1 and others as -1.

public class Count_SubArr_With_Majority_Ele_2 {

    //Since the cumSum changes by either 1 or -1 so this works perfectly

    public static long countMajoritySubArrays(int[] numbers, int target) {

        long result = 0;
        long cumSum = 0;
        long leftValidIndices = 0;

        Map<Long, Long> map = new HashMap<>();//Cumulative Sum,frequency
        map.put(0L, 1L);

        for (int num : numbers) {

            if (num == target) {

                leftValidIndices += map.getOrDefault(cumSum, 0L);
                cumSum++;

            } else {
                cumSum--;
                leftValidIndices -= map.getOrDefault(cumSum, 0L);
            }

            result += leftValidIndices;
            map.put(cumSum, map.getOrDefault(cumSum, 0L) + 1);

        }

        return result;

    }


    public static void main(String[] args) {
        System.out.println("Count of SubArrays with Majority Elements is : "+countMajoritySubArrays(new int[]{1,2,2,3},2));

    }


}
