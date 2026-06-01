package Greedy;

public class Min_Cost_Of_Buying_Candies {

   //TC-O(NlogN) Due to sorting
    //Sort costs descending and skip every third item to maximize free candy value.
    public static int minimumCost(int[] cost) {

        java.util.Arrays.sort(cost);
        int n = cost.length;
        int totSum = 0;
        int lastIdx = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            if (lastIdx - i == 2) {
                lastIdx -= 3;
                continue;
            }
            totSum += cost[i];

        }

        return totSum;

    }

    public static void main(String[] args) {
        System.out.println("Minimum Cost is : "+minimumCost(new int[]{6,5,7,9,2,2}));
    }

}
