package matrix;

public class Matrix_Similarity_After_Cyclic_Shifts {

    public static void main(String[] args) {
        int[][] grid={{1,4},{3,5}};
        System.out.println("Is Matrix becomes similar after Cyclic shifts : "+areSimilar(grid,3));
    }
    public static boolean areSimilar(int[][] mat, int k) {

        int n = mat[0].length;
        k %= n;

        if (k == 0) {
            return true;
        }

        for (int[] row : mat) {
            for (int j = 0; j < n; j++) {

                if (row[j] != row[(j + k) % n]) {
                    return false;
                }
            }
        }

        return true;

    }


}
