package maths_problems;

public class Stone_Game_9 {

    public static boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) > 2;
    }

    public static void main(String[] args) {
        System.out.println("Alice Wins : "+stoneGameIX(new int[]{2,1}));
    }
}
