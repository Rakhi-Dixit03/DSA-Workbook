package matrix;

import java.util.*;
//Ques : 3567
public class Min_Absolute_Diff_in_Sliding_SubMatrix {

    public static void main(String[] args) {
        int[][] grid={{1,8},{3,-2}};
        System.out.print("Minimum Absolute Difference in Sliding SubMatrices is  : ");
        int[][] res=minAbsDiff(grid,2);

        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
        }

    }
    public static int[][] minAbsDiff(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                Set<Integer> set = new HashSet<>();

                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {

                        set.add(grid[r][c]);

                    }
                }

                if (set.size() == 1) {
                    res[i][j] = 0;
                    continue;
                }

                ArrayList<Integer> list = new ArrayList<>(set);
                list.sort(Comparator.comparingInt(a->a));

                int minDiff = Integer.MAX_VALUE;

                for (int p = 0; p < list.size() - 1; p++) {

                    int diff = Math.abs(list.get(p) - list.get(p + 1));
                    minDiff = Math.min(diff, minDiff);

                }

                res[i][j] = minDiff;

            }
        }

        return res;
    }


}
