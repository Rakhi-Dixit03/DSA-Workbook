package matrix;

public class Flip_Square_SubMatrix_Vertically {

    public static void main(String[] args) {

        int[][] grid={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] res=reverseSubMatrix(grid,1,0,3);
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }
   //TC-(k^2)
    public static int[][] reverseSubMatrix(int[][] grid, int x, int y, int k) {


        for(int i=0;i<k;i++){
            for(int j=0;j<(k>>1);j++){

                int temp=grid[x+j][y+i];
                grid[x+j][y+i] =grid[x+k-j-1][y+i];
                grid[x+k-j-1][y+i]=temp;

            }
        }

        return grid;
    }


}
