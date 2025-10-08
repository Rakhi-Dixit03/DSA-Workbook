package BinarySearch;
//Leetcode- 2300. Successful Pairs of Spells and Potions

public class SuccessfulPairs {

    public static void main(String[] args) {

        int[] spells={5,1,3};
        int[] potions={1,2,3,4,5};
        int success=7;
        System.out.println(java.util.Arrays.toString(successfulPairs(spells,potions,success)));

    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        //Sort potions Array to apply Binary Search
        java.util.Arrays.sort(potions);

        for (int i = 0; i < n; i++) {

            int idx = binarySearch(potions, success, spells[i]);

            ans[i] = m-idx;//potions.length-(first idx which satisfies the condition)

        }
        return ans;
    }
    //Lower bound
    static int binarySearch(int[] potions, long success, int spell) {

        int l = 0;
        int h = potions.length;

        while (l < h) {

            int mid = l + (h - l) / 2;

            if ((long)potions[mid] * spell >= success) {

                h = mid;

            } else {
                l = mid + 1;
            }

        }

        return l;
    }

}
