package Hashing;

import java.util.*;
//Question - 2657
//TC-O(N^2)
//SC-O(N)
public class Find_Prefix_Common_Arr {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        int[] C = new int[n];
        Set<Integer> elementsInA = new HashSet<>();
        Set<Integer> elementsInB = new HashSet<>();

        for (int i = 0; i < n; i++) {

            elementsInA.add(A[i]);
            elementsInB.add(B[i]);

            int common = 0;

            for (int ele : elementsInA) {
                if (elementsInB.contains(ele)) {
                    common++;
                }

            }
            C[i] = common;

        }
        return C;
    }

    public static void main(String[] args) {

        System.out.println("Prefix Common Array is : "
                +Arrays.toString(findThePrefixCommonArray(new int[]{1,3,2,4},new int[]{3,1,2,4})));
    }


}
