package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        NQueens q=new NQueens();

        System.out.println(q.solveNQueens(4).toString());

    }

    public  List<List<String>> solveNQueens(int n) {

        List<List<String>>ans=new ArrayList<>();

        char[][] board=new char[n][n];

        //Initialise

        for(char[] row: board){
            java.util.Arrays.fill(row,'.');
        }


        //call method

        nQueenHelper(0,n,board,ans);
        return ans;



    }


    boolean isSafe(int row,int col,char[][] board){

        //Row check
        for(int j=0;j<board.length;j++){

            if(board[row][j]=='Q'){
                return false;
            }

        }

        //Col check
        for(int i=0;i<board.length;i++){

            if(board[i][col]=='Q'){
                return false;
            }

        }

        //Top-Left Diagonal

        for(int j=col, i=row;j>=0 && i>=0;j--,i--){

            if(board[i][j]=='Q'){
                return false;
            }

        }
        //Top Right Diagonal

        for(int j=col,i=row;j<board.length && i>=0;j++,i--){

            if(board[i][j]=='Q'){
                return false;
            }

        }
        return true;

    }


    void nQueenHelper(int row,int n,char[][] board,List<List<String>>ans){

        if(row==n){
            ans.add(construct(board));
            return;
        }


        for(int col=0;col<n;col++){

            if(isSafe(row,col,board)){

                board[row][col]='Q';// place queen
                nQueenHelper(row+1,n,board,ans);// go to next row

                board[row][col]='.';    //BackTrack/unplace queen


            }


        }


    }


    List<String> construct(char[][] board){

        List<String>temp=new ArrayList<>();

        for(int i=0;i<board.length;i++){

            temp.add(new String(board[i]));

        }
        return temp;

    }




}
