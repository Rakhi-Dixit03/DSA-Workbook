package Bit_Manipulation;

//TC-O(N)
//SC-O(1)

public class Longest_SubSeq_With_Non_Zero_Bitwise_XOR {

    public static int longestSubsequence(int[] numbers) {

        int totXOR = 0;
        int n = numbers.length;

        boolean allZeros = true;

        for (int num : numbers) {

            totXOR ^= num;

            if (num != 0) {
                allZeros = false;
            }
        }

        if (allZeros)
            return 0;

        return totXOR == 0 ? n - 1 : n;

    }

    public static void main(String[] args) {
        int[] arr = {2,3,4};
        System.out.println("Longest SubSequence With Non-Zero Bitwise XOR :" +
                " "+longestSubsequence(arr));
    }


}
