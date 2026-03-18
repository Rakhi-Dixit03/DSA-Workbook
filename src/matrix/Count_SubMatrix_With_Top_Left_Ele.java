package matrix;

//Question - 3070
public class Count_SubMatrix_With_Top_Left_Ele {

    public static void main(String[] args) {

        int[][] grid={{7,6,3},{6,6,1}};

        System.out.println("Count of SubMatrices starting with top-left " +
                "corner having sum less than or Equal to k : "+countSubMatrices(grid,18));
    }
    public static int countSubMatrices(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i - 1 >= 0)
                    grid[i][j] += grid[i - 1][j];

                if (j - 1 >= 0)
                    grid[i][j] += grid[i][j - 1];

                if (i - 1 >= 0 && j - 1 >= 0)
                    grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}

