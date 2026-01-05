package Arrays;

public class MaximumMatrixSum {

    public static void main(String[] args) {

        int[][] mat1={{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println("Maximum Matrix Sum : "+maxMatrixSum(mat1));


    }

    public static long maxMatrixSum(int[][] matrix) {

        long sum=0;
        int minEle=Integer.MAX_VALUE;
        int countNeg=0;

        for (int[] row : matrix) {
            for (int ele:row) {

                int val = Math.abs(ele);
                sum += val;

                if (val < minEle) {
                    minEle = ele;
                }

                if (ele < 0) {
                    countNeg++;
                }
            }
        }

        return (countNeg%2==0)?sum:sum- 2L *minEle;


    }


}
