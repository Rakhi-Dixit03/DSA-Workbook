package Hashing;

import  java.util.*;

public class Smallest_Missing_Int_Greater_Than_Seq_Prefix_Sum {
    //Tc-O(N+K)
    //SC-O(N)
    public static int missingInteger(int[] numbers) {
       //Alternatively,we can also use a fixed sized boolean array based on the constraints
        // given in the question  to reduce complexity to O(N) only
        Set<Integer> set = new HashSet<>();

        for (int num : numbers) {
            set.add(num);
        }

        int seqPrefix = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1] + 1) {
                break;
            } else {
                seqPrefix += numbers[i];
            }

        }


        while(set.contains(seqPrefix)) {

            seqPrefix++;

        }

        return seqPrefix;
    }

    public static void main(String[] args) {

        System.out.println("Smallest Missing Integer Greater Than or Equal to " +
                "Sequential Prefix Sum : "+missingInteger(new int[]{1,2,3,2,5}));
    }

}
