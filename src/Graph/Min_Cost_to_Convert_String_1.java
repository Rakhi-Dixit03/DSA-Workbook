package Graph;

public class Min_Cost_to_Convert_String_1 {

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};
        System.out.println("Minimum Cost to Covert String 1 : " + minimumCost("abcd", "acbe", original, changed, cost));
    }


    //Using Floyd Warshall Algo
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {


        long totCost = 0;

        long[][] minCost = new long[26][26];

        for (long[] row : minCost) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < original.length; i++) {

            int stChar = original[i] - 'a';
            int endChar = changed[i] - 'a';

            minCost[stChar][endChar] = Math.min(minCost[stChar][endChar], cost[i]);

        }


        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);

                }

            }
        }


        for (int i = 0; i < source.length(); i++) {

            if (source.charAt(i) != target.charAt(i)) {

                int srcChar = source.charAt(i) - 'a';
                int tarChar = target.charAt(i) - 'a';

                if (minCost[srcChar][tarChar] >= Integer.MAX_VALUE) {
                    return -1;
                }

                totCost += minCost[srcChar][tarChar];
            }

        }

        return totCost;
    }


}
