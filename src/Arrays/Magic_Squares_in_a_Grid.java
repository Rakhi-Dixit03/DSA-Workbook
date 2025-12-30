package Arrays;
import java.util.HashSet;
import java.util.Set;
public class Magic_Squares_in_a_Grid {

    public static void main(String[] args) {

        int[][] grid={{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println("Number of Magic Squares in the Grid are : "+numMagicSquaresInside(grid));


    }

    public static int numMagicSquaresInside(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int count=0;

        for(int i=0;i<=m-3;i++){
            for(int j=0;j<=n-3;j++){

                if(isMagicGrid(i,j,grid)){
                    count++;
                }

            }
        }
        return count;
    }

    private static boolean isMagicGrid(int r,int c,int[][] grid){

        Set<Integer>set=new HashSet<>();

        //Unique values and values within range check

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int val=grid[r+i][c+j];
                if(val<1 || val>9 || set.contains(val)){
                    return false;
                }else{
                    set.add(val);
                }


            }
        }

        int sum=grid[r][c]+grid[r+1][c]+grid[r+2][c];//colSum

        //Row and Column sum Check

        for(int i=0;i<3;i++){

            if((grid[r+i][c] + grid[r+i][c+1] +grid[r+i][c+2] )!=sum){ //Row Check
                return false;

            }

            if((grid[r][c+i] + grid[r+1][c+i] +grid[r+2][c+i] )!=sum){ //Col Check
                return false;

            }
        }

        //Diagonals Check
        //Primary Diagonal

        if((grid[r][c] + grid[r+1][c+1] +grid[r+2][c+2] )!=sum){ //Row Check
            return false;
        }

        //Secondary Diagonal
        //Row Check
        return (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) == sum;
    }

}
