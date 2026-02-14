package dynamicProgramming;

public class Champagne_Tower {

    double[][] memo;
    private double solve(int poured, int i, int j){

        if(i<0 || j < 0 )return 0.0;

        if(i==0 && j==0)return poured;
        if(memo[i][j]!=-1)return memo[i][j];

        double left_contrib=Math.max(0.0,(solve(poured,i-1,j-1)-1)/2.0);
        double right_contrib=Math.max(0.0,(solve(poured,i-1,j)-1)/2.0);

        return memo[i][j] = left_contrib+right_contrib;

    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        memo=new double[101][101];
        for(double[] row:memo){
            java.util.Arrays.fill(row,-1);
        }
        return Math.min(1.0,solve(poured,query_row,query_glass));
    }

}
