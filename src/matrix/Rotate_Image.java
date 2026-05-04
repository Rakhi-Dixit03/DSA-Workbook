package matrix;

//Ques : 78

//Rotating a matrix 90 degrees clockwise by transposing rows
// to columns and then reversing each row.
//TC - O(N^2)
public class Rotate_Image {

    public void reverse(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //Reverse each row

        for (int[] row : matrix) {

            reverse(row);

        }

    }

    public static void main(String[] args) {

        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};

        Rotate_Image obj = new Rotate_Image();
        obj.rotate(mat);
        //After Rotation
        for (int[] row : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(row[j] + " ");
            }
        }
    }

}
