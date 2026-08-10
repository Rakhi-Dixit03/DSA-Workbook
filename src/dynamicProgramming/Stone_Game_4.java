package dynamicProgramming;

//TC - O(N*sqrt(N))
//SC-O(N)
public class Stone_Game_4 {

    Boolean[] memo;

    boolean solve(int n) {

        if (n == 0)
            return false;

        if (memo[n] != null)
            return memo[n];

        for (int i = 1; i * i <= n; i++) {

            int sq = i * i;//curr player takes up these number of stones

            if (!solve(n - sq)) {//if 2nd player losses
                return memo[n] = true;
            }

        }

        return memo[n] = false;

    }

    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return solve(n);

    }

    //Tabulation

    public boolean winnerSquareGame2(int n) {

        boolean[] dp = new boolean[n + 1];//dp[i] stores given the n number of stones does Alice win

        dp[0]=false;

        for(int stones=1; stones<=n; stones++){

            for(int i=1;i*i<=stones;i++){
                int sq=i*i;//first player takes up these number of stones then
                if(!dp[stones-sq]){//if 2nd player losses

                    dp[stones]=true;//curr player wins
                    break;
                }

            }

        }
        return dp[n];
    }


    public static void main(String[] args) {

        Stone_Game_4 obj = new Stone_Game_4();
        System.out.println("Alice Won the match : " + obj.winnerSquareGame(6));
        System.out.println("Alice Won the match : " + obj.winnerSquareGame2(6));
    }

}
