package dynamicProgramming;

public class Max_Dot_Prod_Of_SubSequences {

    public static void main(String[] args) {

        Max_Dot_Prod_Of_SubSequences obj=new Max_Dot_Prod_Of_SubSequences();

        System.out.println("Maximum Dot Product of Subsequences : "+obj.maxDotProduct(new int[]{2,1,-2,5},new int[]{3,0,-6}));


    }

    int m;
    int n;
    int[][] dp=new int[501][501];
    final int negInf=(int)-1e9;
    public int maxDotProduct(int[] nums1, int[] nums2) {

        m=nums1.length;
        n=nums2.length;

        for(int[] row: dp){

            java.util.Arrays.fill(row,Integer.MIN_VALUE);

        }

        return solve(0,0,nums1,nums2);

    }

    private  int solve(int i,int j,int[] nums1,int[] nums2){

        if(i==m || j==n){
            return negInf;
        }

        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }

        int val =nums1[i]*nums2[j];
        int take_i_j=(nums1[i]*nums2[j])+solve(i+1,j+1,nums1,nums2);
        int take_i=solve(i,j+1,nums1,nums2);
        int take_j=solve(i+1,j,nums1,nums2);

        int max1=Math.max(val,take_i_j);
        int max2=Math.max(take_i,take_j);

        return dp[i][j]= Math.max(max1,max2);

    }


}
