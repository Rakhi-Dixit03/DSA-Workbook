package dynamicProgramming;

//TC-O(N^3)
//SC-O(N^2)
public class Stone_Game_5 {

    int[][] memo;

    int solve(int l ,int r, int[] cumSum ){

        if(l>=r)return 0;

        if(memo[l][r]!=-1){
            return memo[l][r];
        }

        int score = 0;

        for(int mid=l;mid<=r-1;mid++){

            int leftSum = cumSum[mid]-((l-1>=0)?cumSum[l-1]:0);
            int rightSum = cumSum[r]-cumSum[mid];

            if(leftSum<rightSum){

                score = Math.max(score,leftSum+solve(l,mid,cumSum));

            }else if(leftSum>rightSum){

                score = Math.max(score,rightSum+solve(mid+1,r,cumSum));

            }else{

                score = Math.max(score,Math.max(leftSum+solve(l,mid,cumSum),rightSum+solve(mid+1,r,cumSum)));
            }


        }

        return memo[l][r]=score;

    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;
        memo=new int[501][501];

        for(int[] row : memo){
            java.util.Arrays.fill(row,-1);
        }

        int[] cumSum = new int[n];

        cumSum[0]=stoneValue[0];

        for(int i=1;i<n;i++){

            cumSum[i]=cumSum[i-1]+stoneValue[i];

        }

        return solve(0,n-1,cumSum);


    }

    public static void main(String[] args) {
        Stone_Game_5 obj = new Stone_Game_5();
        System.out.println("Maximum Score  Alice Can Get : "+obj.stoneGameV(new int[]{2,1}));
    }

}
