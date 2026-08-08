package Greedy;

public class Lexicographically_Smallest_Valid_Seq {

    public static int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] rightHandSideMatchLen = new int[n];

        int i = n - 1;
        int j = m - 1;
        int rightMatched = 0;

        while (i >= 0) {

            if (j>=0 && word1.charAt(i) == word2.charAt(j)) {
                rightMatched++;
                j--;
            }

            rightHandSideMatchLen[i] = rightMatched;
            i--;

        }

        int[] seq = new int[m];
        boolean changePower = true;//can change only one char

        i = 0;
        j = 0;
        int idx = 0;
        while (i < n && j < m) {

            if (word1.charAt(i) == word2.charAt(j)) {
                seq[idx] = i;
                idx++;
                j++;

            } else if (changePower && i + 1 < n && rightHandSideMatchLen[i + 1] >= m - j - 1) {
                seq[idx] = i;
                idx++;
                j++;
                changePower = false;

            }

            i++;

        }

        return j == m ? seq : new int[] {};

    }

    public static void main(String[] args) {
        System.out.println("Valid Sequence is : "+java.util.Arrays.toString(validSequence("vbcca","abc")));
    }


}
