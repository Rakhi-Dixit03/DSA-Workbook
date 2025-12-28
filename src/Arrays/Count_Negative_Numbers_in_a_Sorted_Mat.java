package Arrays;

public class Count_Negative_Numbers_in_a_Sorted_Mat {

    public static void main(String[] args) {

        int[][] grid ={{4,3,2,-1},{2,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println("Count of Negative Numbers in matrix is : "+countNegatives(grid));

        System.out.println("Using 2nd Method : Count of Negative Numbers in matrix is : "+countNegatives2(grid));

    }
    //O(MLogN) Solution
    private static int binarySearch(int[] arr){

        int l=0;
        int h=arr.length-1;
        int ansIdx=-1;

        while(l<=h){

            int mid=l+(h-l)/2;

            if(arr[mid]<0){
                ansIdx=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }

        }
        return ansIdx;

    }

    public static int countNegatives(int[][] grid) {
        int countNeg=0;
        int n=grid[0].length;

        for(int[] row : grid){

            int idx=binarySearch(row);

            if(idx!=-1){
                countNeg+=(n-idx);
            }


        }
        return countNeg;
    }

    //O(M+N) Solution

    public static int countNegatives2(int[][] grid) {

        int countNeg=0;
        int m=grid.length;
        int n=grid[0].length;

        int r=0,c=n-1;

        while(r<m && c>=0){//We will start traversing from top-right corner

            if(grid[r][c]<0){//if negative add all negative numbers below it and move to left //next column
                countNeg+=(m-r);
                c--;

            }else{//move down because negative values can be found there //next row
                r++;
            }

        }
        return countNeg;
    }

}
