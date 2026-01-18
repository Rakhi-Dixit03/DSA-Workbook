package matrix;

public class Largest_Magic_Square {

    public static void main(String[] args) {

        int[][] grid={{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};

        System.out.println("Largest Magic Square Side : "+largestMagicSquare(grid));
    }


    public static int largestMagicSquare(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int[][] rowCulSum=new int[m][n];
        int[][] colCulSum=new int[m][n];

        //Cumulative sum of all rows in the grid
        for(int i=0;i<m;i++){

            rowCulSum[i][0]=grid[i][0];

            for(int j=1;j<n;j++){
                rowCulSum[i][j]=grid[i][j]+rowCulSum[i][j-1];

            }
        }

        //Cumulative sum of all columns in the grid
        for(int j=0;j<n;j++){

            colCulSum[0][j]=grid[0][j];

            for(int i=1;i<m;i++){

                colCulSum[i][j]=grid[i][j]+colCulSum[i-1][j];

            }
        }


        for(int side=Math.min(m,n);side>=2;side--){

            for(int i=0;i+side-1<m;i++){

                for(int j=0;j+side-1<n;j++){

                    int targetSum=rowCulSum[i][j+side-1]-(j>0?rowCulSum[i][j-1]:0);

                    boolean allSame=true;
                    //Sum of All remaining Rows

                    for(int r=i+1;r<i+side;r++){

                        int rowSum=rowCulSum[r][j+side-1]-(j>0?rowCulSum[r][j-1]:0);

                        if(rowSum!=targetSum){

                            allSame=false;
                            break;
                        }
                    }

                    if(!allSame){//current is not magic square,we can check next square
                        continue;

                    }

                    //Check All Columns

                    for(int c=j;c<j+side;c++){

                        int colSum=colCulSum[i+side-1][c]-(i>0?colCulSum[i-1][c]:0);

                        if(colSum!=targetSum){

                            allSame=false;
                            break;
                        }
                    }

                    if(!allSame){//current is not magic square,we can check next square
                        continue;

                    }

                    //Diagonals Check
                    int diagonal=0;
                    int antiDiagonal=0;

                    for(int k=0;k<side;k++){

                        diagonal+=grid[i+k][j+k];
                        antiDiagonal+=grid[i+k][j+side-1-k];

                    }

                    if(diagonal==targetSum && antiDiagonal==targetSum){
                        return side;
                    }

                }


            }

        }
        return 1;
    }
}
