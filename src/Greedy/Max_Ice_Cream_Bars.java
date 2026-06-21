package Greedy;

//TC-O(N+M)
//SC-O(N)
//Key Idea:
//Using Counting Sort to efficiently process frequencies
// and applying a greedy strategy to maximize items bought.

public class Max_Ice_Cream_Bars {

    public static int maxIceCream(int[] costs, int coins) {

        int[] freq = new int[100001];
        int bars = 0;

        for (int c : costs)
            freq[c]++;

        for (int cost = 1; cost <= 100000; cost++) {

            while (freq[cost] > 0 && coins >= cost) {
                freq[cost]--;
                coins -= cost;
                bars++;

            }

        }
        return bars;

    }

    public static void main(String[] args) {
        int[] costs = {10,6,8,7,7,8};
        System.out.println("Maximum Ice Cream Bars the Child can Buy : "+maxIceCream(costs,10));
    }

}
