package Bit_Manipulation;

public class Special_Position_in_Binary_Matrix {

    public static void main(String[] args) {

        int[][] mat={{1,0,0},{0,1,0},{0,0,1}};


        System.out.println("Special Positions in a Binary Matrix are : "+numSpecial(mat));
        System.out.println("Special Positions in a Binary Matrix are : "+numSpecial1(mat));

    }

    //TC-(2*M*N)
    public static int numSpecial(int[][] mat) {

        int m=mat.length;
        int n=mat[0].length;

        int[] rowOneCount=new int[m];
        int[] colOneCount=new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(mat[i][j]==1){
                    rowOneCount[i]++;
                    colOneCount[j]++;
                }
            }
        }

        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(mat[i][j]==1){
                    if(rowOneCount[i]==1 && colOneCount[j]==1){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

   //TC-O(M*N)
    public static int numSpecial1(int[][] mat) {

        int n=mat[0].length;
        int ans=0;


        for (int[] row : mat) {

            int rowOneCount = 0;
            int colIdx = -1;

            for (int j = 0; j < n; j++) {

                if (row[j] == 1) {
                    rowOneCount++;
                    colIdx = j;
                }
            }

            if (rowOneCount == 1) {

                if (checkColOneCount(colIdx, mat)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static boolean checkColOneCount(int col,int[][] mat){
        int count=0;
        for (int[] row : mat) {
            if (row[col] == 1) {
                count++;
            }

        }

        return count==1;
    }

}
