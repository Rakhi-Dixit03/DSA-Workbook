package matrix;
import java.util.*;

public class Largest_SubMatrix_With_Rearrangements {

    public static void main(String[] args) {

        int[][] mat={{0,0,1},{1,1,1},{1,0,1}};

        System.out.println("Largest SubMatrix with Maximum Area : "+largestSubMatrix(mat));
    }
    public static int largestSubMatrix(int[][] matrix) {

        int n = matrix[0].length;
        int maxArea = 0;
        int[] h = new int[n];

        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) h[j]++;
                else h[j] = 0;
            }
            int[] sh = h.clone();
            Arrays.sort(sh);
            for (int j = n - 1; j >= 0; j--) {
                if (sh[j] == 0) break;
                maxArea = Math.max(maxArea, sh[j] * (n - j));
            }
        }
        return maxArea;

    }

}
