package dynamicProgramming;

//Key Idea:
//DP tracking GCD states of two disjoint subsequences.
//TC - O(N*M^2)
public class Num_Of_SubSeq_With_Equal_GCD {

    int[][][] memo;

    static int mod = 1000_000_007;

    int gcd(int a,int b){

        a=Math.abs(a);
        b=Math.abs(b);

        while(b>0){

            int temp=b;
            b=a%b;
            a=temp;

        }

        return a;

    }

    int solve(int[] nums,int i,int first,int second){

        //Base Case
        if(i==nums.length){

            boolean bothNonEmpty=(first!=0 && second!=0);
            boolean equalGcd=(first==second);

            return (bothNonEmpty && equalGcd)?1:0;

        }

        if(memo[i][first][second]!=-1){
            return memo[i][first][second];
        }

        int skip = solve(nums,i+1,first,second);

        int take1 = solve(nums,i+1,gcd(first,nums[i]),second);

        int take2 = solve(nums,i+1,first,gcd(second,nums[i]));

        return memo[i][first][second]=(int)((0L+skip+take1+take2)%mod);


    }


    public int subsequencePairCount1(int[] nums) {

        int n=nums.length;
        int maxVal = java.util.Arrays.stream(nums).max().getAsInt();
        memo = new int[n+1][maxVal+1][maxVal+1];

        //initialise memo with -1

        for(int i=0;i<=n;i++){
            for(int j=0;j<=maxVal;j++){
                for(int k=0;k<=maxVal;k++){
                    memo[i][j][k]=-1;
                }
            }
        }

        return solve(nums,0,0,0);

    }

   //Bottom-up code
   //SC- O(M^2)
    public int subsequencePairCount2(int[] nums) {

        int n = nums.length;
        int maxVal = java.util.Arrays.stream(nums).max().getAsInt();
        int[][] prev = new int[maxVal + 1][maxVal + 1];

        //Base Case

        for (int first = 0; first <= maxVal; first++) {
            for (int second = 0; second <= maxVal; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean equalGcd = (first == second);

                prev[first][second] = (bothNonEmpty && equalGcd) ? 1 : 0;

            }
        }

        //  for(int first = maxVal ; first>=0;first--){
        // for(int second =maxVal; second >=0;second--){

        for (int i = n - 1; i >= 0; i--) {

            int[][] curr = new int[maxVal + 1][maxVal + 1];

            for (int first = 0; first <= maxVal; first++) {
                for (int second = 0; second <= maxVal; second++) {

                    int skip = prev[first][second];

                    int take1 = prev[gcd(first, nums[i])][second];

                    int take2 = prev[first][gcd(second, nums[i])];

                    curr[first][second] = (int) ((0L + take1 + skip + take2) % mod);

                }
            }

            prev = curr;

        }

        return prev[0][0];

    }

    public static void main(String[] args) {

        Num_Of_SubSeq_With_Equal_GCD obj = new Num_Of_SubSeq_With_Equal_GCD();

        System.out.println("Number of SubSequences with Equal GCD are : "
                +obj.subsequencePairCount1(new int[]{10,20,30}));
        System.out.println("Number of SubSequences with Equal GCD are : "
                +obj.subsequencePairCount2(new int[]{10,20,30}));
    }


}
