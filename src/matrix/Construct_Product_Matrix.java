package matrix;

//Ques : 2906 Similar to Product od Array Except Self
public class Construct_Product_Matrix {
    public static void main(String[] args) {
        int[][] mat={{1,2},{3,4}};
        System.out.println("Product Matrix is : ");
        int[][] res=constructProductMatrix(mat);

        for(int[] row:res){
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    public static int[][] constructProductMatrix(int[][] grid) {

        final int M = 12345;
        int m = grid.length;
        int n = grid[0].length;
        int[][] p = new int[m][n];

        long suffix = 1;//product of all elements after curr element

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                p[i][j] = (int) (suffix);
                suffix = (suffix * grid[i][j]) % M;

            }
        }

        long prefix = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = (int) (prefix * p[i][j]) % M;
                prefix = (prefix * grid[i][j]) % M;

            }
        }

        return p;
    }


}
