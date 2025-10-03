package Recursion_BackTracking;

public class Sudoku_Solver {

    public static void main(String[] args) {

        char[][] grid={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                       {'.','9','8','.','.','.','.','6','.'},
                       {'8','.','.','.','6','.','.','.','3'},
                      {'4','.','.','8','.','3','.','.','1'},
                      {'7','.','.','.','2','.','.','.','6'},
                      {'.','6','.','.','.','.','2','8','.'},
                      {'.','.','.','4','1','9','.','.','5'},
                      {'.','.','.','.','8','.','.','7','9'}



        };

        System.out.println("Is it possible to solve this sudoku? : "+sudokuSolver(grid,0,0));
        printGrid(grid);

    }

    public static boolean isValid(char[][] grid,int row,int col,char digit){
        int m=grid.length;
        int n=grid[0].length;
        //row scan
        for(int j=0;j<n;j++){
            if(grid[row][j]==digit){
                return false;
            }

        }
       //col scan
        for (int i=0;i<m;i++) {
            if (grid[i][col] == digit) {
                return false;
            }

        }

        //grid scan

        int stRow=(row/3)*3;
        int stCol=(col/3)*3;


        for(int i=stRow;i<stRow+3;i++){

            for(int j=stCol;j<stCol+3;j++){

                if(grid[i][j]==digit){
                    return false;
                }

            }

        }

        return true;
    }

    public static boolean sudokuSolver(char[][] grid,int row,int col){
        if(grid.length==0)return false;

        if(row==9){
            return true;
        }

        if(col==9){
            return sudokuSolver(grid,row+1,0);
        }

        if(grid[row][col]!='.'){
            return  sudokuSolver(grid,row,col+1);
        }



        for(char ch='1';ch<='9';ch++){

            if(isValid(grid,row,col,ch)){

                //Place digit
                grid[row][col]=ch;

                if(sudokuSolver(grid,row,col+1)){
                    return true;
                }

                grid[row][col]='.';

            }




        }
        return false;

    }

    public static void printGrid(char[][] grid){

        for(char[] row: grid){
            System.out.println(java.util.Arrays.toString(row));

        }

    }

}
