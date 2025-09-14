package Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] mat={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroes(mat);
        System.out.println("After setting Zeroes : ");
        printMatrix(mat);
    }

    public static void setMatrixZeroes(int[][] mat){
        int[] markedRow=new int[mat.length];
        int[] markedCol=new int[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    markedRow[i]=-1;
                    markedCol[j]=-1;
                }
            }
        }


        for(int i=0;i<markedRow.length;i++){
            if(markedRow[i]==-1){
                rowZero(mat,i);
            }


        }

        for(int j=0;j<markedCol.length;j++){
            if(markedCol[j]==-1){
                colZero(mat,j);
            }
        }

    }

    public static void rowZero(int[][] mat,int row){

        for(int j=0;j<mat[0].length;j++){
            mat[row][j]=0;

        }


    }

    public static void colZero(int[][] mat,int col){
        for(int i=0;i<mat.length;i++){
            mat[i][col]=0;
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
