package Bit_Manipulation;

public class Min_Swaps_To_Arrange_A_Binary_Grid {

    public static void main(String[] args) {

        int[][] grid={{0,0,1},{1,1,0},{1,0,0}};

        System.out.println("Minimum Swaps to arrange Binary Grid : "+minSwaps(grid));

    }
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] endZeros = new int[n];//stores number of consecutive zeros from the end for each row

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int j = n - 1;
            int count = 0;

            while (j >= 0 && grid[i][j] == 0) {
                count++;
                j--;

            }

            endZeros[i] = count;

        }

        for (int i = 0; i < n; i++) {

            int need = n - i - 1;//need of zeros for a row

            int j = i;

            while (j < n && endZeros[j] < need) {

                j++;

            }

            if (j == n) {
                return -1;
            }

            swaps += j - i;

            //swapping rows

            while (j > 0) {

                int temp = endZeros[j];
                endZeros[j] = endZeros[j - 1];
                endZeros[j - 1] = temp;
                j--;

            }

        }
        return swaps;
    }

}
