package Arrays;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] mat={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroes1(mat);
        System.out.println("Matrix after setting Zeroes : ");
        printMatrix(mat);
    }


    // Naive/Brute Force Approach TC-O(2*(N*M)*(N+M)) SC-O(1)
    public static void setMatrixZeroes1(int[][] mat){
        //Mark cells which need to be made zero
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    markRow(mat,i);
                    markCol(mat,j);

                }
            }
        }

        //setting 0 at  marked  places
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=0;
                }
            }
        }

    }


    //Better Approach TC-O(2*n*m) SC-O(n+m)

    public static void setMatrixZeroes2(int[][] mat){
        int[] row=new int[mat.length];
        int[] col=new int[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    row[i]=1;//Marking rows  that need to be made zero
                    col[j]=1;//Marking columns that need to be made zero
                }
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(row[i]==1 || col[j]==1){
                   mat[i][j]=0;
                }
            }
        }

    }


    public static void markRow(int[][] mat,int row){

        for(int j=0;j<mat[0].length;j++){
            if(mat[row][j]!=0){
                mat[row][j]=-1;
            }


        }
    }
    public static void markCol(int[][] mat,int col){
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]!=0){
                mat[i][col]=-1;
            }
        }
    }


    // Optimal Solution TC-(2*(N*M)), SC-O(1)

    public static void setMatrixZeroes3(int[][] mat){

        int col0=1;
        //Marking 1st row and 1st column accordingly

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){

                if(mat[i][j]==0){
                    //Mark row
                    mat[i][0]=0;
                    //Mark Column
                    if(j==0){
                        col0=0;
                    }else{
                        mat[0][j]=0;
                    }
                }
            }
        }

        //Modifying /setting values to zeroes for the rows and cols which are marked, from (1,1) to (n-1,m-1)
        //Because modification of rest of the matrix is dependent on 1st row and 1st col

        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                if(mat[0][j]==0 || mat[i][0]==0){
                    mat[i][j]=0;
                }
            }
        }

        //Modifying 1st row and 1st column
        //row
        if(mat[0][0]==0) {
            Arrays.fill(mat[0], 0);
        }

        if(col0==0) {
            for(int i=0;i<mat.length;i++){
                mat[i][0]=0;
            }
        }
    }


    public static void printMatrix(int[][] mat){

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

}
