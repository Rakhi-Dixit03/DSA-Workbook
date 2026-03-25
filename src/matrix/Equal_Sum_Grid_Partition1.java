package matrix;
//Ques : 3546
public class Equal_Sum_Grid_Partition1 {

    public static void main(String[] args) {

        int[][] grid={{1,4},{3,5}};
        System.out.println("Is it Possible to Partition the Grid into two " +
                "parts such that sum is equal in both parts  : "+canPartitionGrid(grid));
    }
    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] p = new long[m][n];
        p[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {

            p[0][j] = p[0][j - 1] + grid[0][j];

        }

        for (int i = 1; i < m; i++) {

            p[i][0] = p[i - 1][0] + grid[i][0];

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1]+grid[i][j];
            }
        }

        long totSum = p[m - 1][n - 1];

        for (int i = 0; i < m-1; i++) {

            long upperSum = p[i][n - 1];
            long lowerSum = totSum - upperSum;

            if (upperSum == lowerSum) {
                return true;
            }

        }

        for (int j = 0; j < n-1; j++) {

            long upperSum = p[m - 1][j];
            long lowerSum = totSum - upperSum;

            if (upperSum == lowerSum) {
                return true;
            }
        }

        return false;

    }


}
