package matrix;
//Ques : 1886
public class Whether_Mat_Be_Obtained_By_Rotation {
    public static void main(String[] args) {
        Whether_Mat_Be_Obtained_By_Rotation obj=new Whether_Mat_Be_Obtained_By_Rotation();

        int[][] mat={{0,1},{1,0}};
        int[][] tar={{1,0},{0,1}};
        System.out.println("Can we obtain Target By Rotating Matrix : "+obj.findRotation(mat,tar));
        System.out.println("Can we obtain Target By Rotating Matrix : "+obj.findRotation2(mat,tar));
    }

    private void reverse(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    private void rotate(int[][] mat) {
        //Transpose
        for (int i = 0; i < mat.length; i++) {

            for (int j = i; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }

        }

        //row-Wise reverse

        for (int[] row : mat) {

            reverse(row);

        }

    }
   //TC-(N^2)
    public boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;

        for (int r = 0; r < 4; r++) {//At Max-4 rotations

            boolean isEqual = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != target[i][j]) {
                        isEqual = false;
                        break;
                    }
                }

                if (!isEqual) {
                    break;
                }
            }

            if (isEqual) {
                return true;
            }

            rotate(mat);
        }

        return false;
    }

    //2nd Approach
    public boolean findRotation2(int[][] mat, int[][] target) {

        int n = mat.length;
        boolean r0 = true;
        boolean r90 = true;
        boolean r180 = true;
        boolean r270 = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    r0 = false;

                if (target[i][j] != mat[j][n - i - 1])
                    r90 = false;
                if (target[i][j] != mat[n - i - 1][n - j - 1])
                    r180 = false;
                if (target[i][j] != mat[n - j - 1][i])
                    r270 = false;

            }

        }

        return r0 || r90 || r180 || r270;
    }


}
