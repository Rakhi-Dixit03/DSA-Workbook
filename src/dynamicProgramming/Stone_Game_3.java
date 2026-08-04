package dynamicProgramming;

public class Stone_Game_3 {

    int n;
    int[][] memo;

    int solve(int person, int i, int[] nums) {

        if (i >= n)
            return 0;

        if (memo[person][i] != -1)
            return memo[person][i];

        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score = 0;

        for (int x = 1; x <= Math.min(n - i, 3); x++) {
            score += nums[i + x - 1];

            if (person == 1) {//Alice

                result = Math.max(result, score + solve(0, i + x, nums));

            } else {//Bob

                result = Math.min(result, solve(1, i + x, nums));

            }

        }

        return memo[person][i] = result;

    }

    public String stoneGameIII(int[] stoneValue) {

        n = stoneValue.length;
        memo = new int[2][n + 1];

        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }

        int AliceScore = solve(1, 0, stoneValue);

        int total = 0;

        for (int val : stoneValue) {
            total += val;
        }

        int BobScore = total - AliceScore;

        if (AliceScore > BobScore)
            return "Alice";
        if (AliceScore < BobScore)
            return "Bob";
        return "Tie";
    }

    public static void main(String[] args) {
        Stone_Game_3 obj = new Stone_Game_3();
        System.out.println("Winner : "+obj.stoneGameIII(new int[]{1,2,3,7}));
        System.out.println("Winner : "+obj.stoneGameIII_2(new int[]{1,2,3,7}));

    }


    //2nd Approach

    int[] dp;


    int solve(int i,int[] stones){
        if (i >= n)
            return 0;

        if(dp[i]!=-1)return dp[i];

        int res= Integer.MIN_VALUE;
        res = Math.max(res,stones[i]-solve(i+1,stones));

        if(i+1< n)
            res= Math.max(res,stones[i]+stones[i+1]-solve(i+2,stones));

        if(i+2< n)
            res= Math.max(res,stones[i]+stones[i+1]+stones[i+2]-solve(i+3,stones));


        return dp[i]=res;

    }

    public String stoneGameIII_2(int[] stoneValue) {

        n = stoneValue.length;
        dp = new int[n];

        java.util.Arrays.fill(dp, -1);


        int diff = solve(0, stoneValue);


        if (diff>0)
            return "Alice";
        if (diff <0)
            return "Bob";
        return "Tie";
    }
}
