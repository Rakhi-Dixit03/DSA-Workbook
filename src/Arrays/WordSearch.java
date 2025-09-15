package Arrays;

public class WordSearch {

    public static void main(String[] args) {

        String word="CSEC";
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println("Result of Word Search : "+wordSearch(board,word));

    }


    public static boolean wordSearch(char[][] board,String word){
        int n=board.length;
        int m=board[0].length;

        int idx=0;
        //We are finding every Possible staring point

        for(int i=0;i<n ;i++){
            for(int j=0;j<m;j++) {

                if (board[i][j] == word.charAt(idx)) {

                    if (nextWord(board, word, i, j, idx, n, m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean nextWord(char[][] board,String word,int i,int j,int idx,int n,int m){

        //Base Cases
        //This is when we found our word
        if(idx==word.length())return true;

        //Boundary conditions, character mismatch /invalid move

        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!=word.charAt(idx))return false;

        //To prevent using same character in the same path, mark it used

        char c=board[i][j];
        board[i][j]='!';

        //Try to Search word in all four directions
        //Early Optimisation

        //Top
        if(nextWord(board,word,i-1,j,idx+1,n,m)){
            board[i][j]=c;
            return true;
        }
        //Bottom
        if(nextWord(board,word,i+1,j,idx+1,n,m)){
            board[i][j]=c;
            return true;
        }
        //Left
        if(nextWord(board,word,i,j-1,idx+1,n,m)){
            board[i][j]=c;
            return true;
        }

        //Right
        if(nextWord(board,word,i,j+1,idx+1,n,m)){
            board[i][j]=c;
            return true;
        }

        //BackTrack
        board[i][j]=c;
        return false;

    }

}
