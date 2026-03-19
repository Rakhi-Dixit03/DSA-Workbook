package matrix;
//Question Number - 3212
public class Count_SubMatrices_With_Equal_Freq_X_and_Y {

    //TC - O(M*N)
    //SC - O(M*N)

    public static void main(String[] args) {
        char[][] grid={{'X','X','.'},{'Y','.','Y'},{'Y','X','.'}};

        System.out.println("Number of SubMatrices with Equal Count of X and Y : "+numberOfSubMatrices(grid));
        System.out.println("Number of SubMatrices with Equal Count of X and Y : "+numberOfSubMatrices2(grid));
    }

    public static int numberOfSubMatrices(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] countX = new int[m][n];
        int[][] countY = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                countX[i][j] = grid[i][j] == 'X' ? 1 : 0;
                countY[i][j] = grid[i][j] == 'Y' ? 1 : 0;

                if (i > 0) {
                    countX[i][j] += countX[i - 1][j];
                    countY[i][j] += countY[i - 1][j];
                }

                if (j > 0) {
                    countX[i][j] += countX[i][j - 1];
                    countY[i][j] += countY[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    countX[i][j] -= countX[i - 1][j - 1];
                    countY[i][j] -= countY[i - 1][j - 1];
                }

                if (countX[i][j] == countY[i][j] && countX[i][j] > 0) {
                    count++;
                }

            }
        }
        return count;
    }

    //1D Arrays
    public static int numberOfSubMatrices2(char[][] grid) {

        int n = grid[0].length;
        int[] countX = new int[n];
        int[] countY = new int[n];
        int count = 0;

        for (char[] chars : grid) {
            int rowX = 0;
            int rowY = 0;
            for (int j = 0; j < n; j++) {

                if (chars[j] == 'X') {
                    rowX++;
                } else if (chars[j] == 'Y') {
                    rowY++;
                }

                countX[j] += rowX;
                countY[j] += rowY;

                if (countX[j] == countY[j] && countX[j] > 0) {
                    count++;
                }

            }
        }
        return count;
    }

}
