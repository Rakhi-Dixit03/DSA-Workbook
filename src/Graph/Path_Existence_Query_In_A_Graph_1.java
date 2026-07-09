package Graph;


//TC - O(N+Q)
//SC - O(N+Q)
public class Path_Existence_Query_In_A_Graph_1 {

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] comp = new int[n];
        boolean[] ans = new boolean[queries.length];

        comp[0] = 0;

        for (int i = 1; i < n; i++) {

            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {

                comp[i] = comp[i - 1];//since absolute diff is <=maxDiff can be a part of same component

            } else {

                comp[i] = comp[i - 1] + 1;
            }

        }

        //Processing Queries
        int i = 0;
        for (int[] q : queries) {

            int u = q[0];
            int v = q[1];

            ans[i] = comp[u] == comp[v];

            i++;

        }

        return ans;

    }

    public static void main(String[] args) {

        int[][] queries = {{0, 0}, {0, 1}};
        System.out.println("Result : " +
                java.util.Arrays.toString(pathExistenceQueries(2, new int[]{1, 3}, 1, queries)));
    }

}
