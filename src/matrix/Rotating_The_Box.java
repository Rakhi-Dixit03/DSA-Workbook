package matrix;

public class Rotating_The_Box {
    // TC- O(M*N)
    //SC-O(M*N)

    public char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;

        //Gravity Simulation
        for (int r = 0; r < m; r++) {

            int nextStonePos = n - 1;

            for (int c = n - 1; c >= 0; c--) {

                if (boxGrid[r][c] == '*') {
                    //reset the nextStonePos pointer
                    nextStonePos = c - 1;
                } else if (boxGrid[r][c] == '#') { //stone

                    //place it to right side[at nextStonePos]
                    if (c != nextStonePos) {
                        boxGrid[r][nextStonePos] = '#';
                        boxGrid[r][c] = '.';
                    }
                    nextStonePos--;
                }
            }
        }

        //Rotate Grid by 90 degrees

        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                result[j][i] = boxGrid[m - 1 - i][j];

            }
        }

        return result;

    }

}
