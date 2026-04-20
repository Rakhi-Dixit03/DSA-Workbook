package Greedy;

public class Two_Furthest_Houses_With_Diff_Colors {

    //TC- O(N)
    //Ques - 2078
    //Maximizing distance by checking endpoints against the array,
    // utilizing the property that one endpoint must be part of the optimal solution.
    public static void main(String[] args) {
        System.out.println("Maximum Distance between two houses with different colors : "
                + maxDistance(new int[]{1,1,1,1,5,1,1,1,1,3,1,1}));
    }
    public static int maxDistance(int[] colors) {
        int n = colors.length;

        for (int i = 0; i < n; i++) {

            if ((colors[i] != colors[0]) || (colors[i] != colors[n - 1 - i])) {
                return n - 1 - i;
            }

        }
        return 0;
    }


}
