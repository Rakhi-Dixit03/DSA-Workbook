package Arrays;

public class Min_Ops_To_Make_Grid_UniValued {
//TC-O(M*N(Log(M*N))
    //Why Median ?
//Because minimizing sum of absolute differences is achieved at the median. This is the core idea behind this problem.
    public static int minOperations(int[][] grid, int x) {

        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int idx = 0;
        for (int[] row : grid) {
            for (int j : row) {
                arr[idx] = j;
                idx++;
            }

        }

        java.util.Arrays.sort(arr);
        int mid = (m * n) / 2;
        int target = arr[mid];

        int minOps = 0;
        for (int val : arr) {

            int valReq = Math.abs(val - target);
            if (valReq % x != 0) {
                return -1;
            } else {

                minOps += valReq / x;

            }

        }

        return minOps;

    }

    public static void main(String[] args) {
        int[][] grid = {{2,4},{6,8}};
        System.out.println("Minimum Number of operations Required to make grid Uni-valued : "+minOperations(grid,2));
    }
}


