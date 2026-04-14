package dynamicProgramming;

import java.util.*;
//Sort robots and expanded factory positions, then use DP to match them optimally.
//TC : O(M*N)
//SC : O(M*N)
public class Min_Total_Dis_Travelled {

    static final long max = (long) 1e12;

    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>(Arrays.asList(1, -1));
        int[][] factory = {{-2, 1}, {2, 1}};
        System.out.println("Minimum Total Distance Travelled is : " + minimumTotalDistance(robot, factory));
    }

    static long solve(int ri, int fi, List<Integer> robot, List<Integer> facPos, long[][] memo) {

        //Base cases
        if (ri >= robot.size()) {
            return 0;//No more distance to cover
        }

        if (fi >= facPos.size()) {//invalid case
            return max;
        }

        if (memo[ri][fi] != -1) {
            return memo[ri][fi];
        }

        long take = Math.abs(robot.get(ri) - facPos.get(fi)) + solve(ri + 1, fi + 1, robot, facPos, memo);
        long skip = solve(ri, fi + 1, robot, facPos, memo);

        return memo[ri][fi] = Math.min(take, skip);

    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        robot.sort(null);
        List<Integer> facPositions = new ArrayList<>();

        for (int[] row : factory) {

            for (int j = 0; j < row[1]; j++) {

                facPositions.add(row[0]);//Expanding Factory array to avoid tracking limit and simplify recursion

            }

        }

        facPositions.sort(null);

        int m = robot.size();
        int n = facPositions.size();

        long[][] memo = new long[m][n];

        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, robot, facPositions, memo);

    }


}
