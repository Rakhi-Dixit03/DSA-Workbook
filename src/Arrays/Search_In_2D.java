package Arrays;

public class Search_In_2D {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int element = 7;

        System.out.println("Brute Force Element found : " + searchMatrix1(mat, element));
        System.out.println("Better Approach Element found : " + searchMatrix2(mat, element));
        System.out.println("Optimal Approach - 1 Element found : " + searchMatrix3(mat, element));
        System.out.println("Optimal Approach - 2 Element found : " + searchMatrix4(mat, element));


    }

    //Brute Force O(N*M) N-no. of Rows , M-no. of Columns
    public static boolean searchMatrix1(int[][] matrix, int ele) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == ele) {
                    return true;
                }


            }
        }
        return false;
    }

    //Better Approach
    //TC-O(N)*O(log(M))
    //As matrix is sorted row-wise as well as column -wise we can apply Binary-Search on either each column ot each row
    public static boolean searchMatrix2(int[][] matrix, int ele) {

        for (int[] row : matrix) { //For each row we are calling Binary-Search

            if (binarySearch(row, ele)) {
                return true;
            }

        }
        return false;

    }

    //Binary Search
    public static boolean binarySearch(int[] arr, int tar) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == tar) {
                return true;
            } else if (arr[mid] > tar) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }

        return false;
    }


    //Optimal Approach -1 O(M+N)

    public static boolean searchMatrix3(int[][] matrix, int ele) {
        //picking bottom left element as starting point
        int n = matrix.length;
        int m = matrix[0].length;


        int i = n - 1;//Last row
        int j = 0;//first column

        while (i >= 0 && j < m) {

            if (matrix[i][j] == ele) {
                return true;
            } else if (matrix[i][j] > ele) {
                //Move up smaller element
                i--;//decreasing row

            } else {

                j++; //increasing column , bigger element
            }


        }
        return false;
    }

    //Optimal Approach -2 O(log(M*N))

    public static boolean searchMatrix4(int[][] matrix, int ele) {
        //We can imagine 2D matrix as Sorted Flattened Array
        //Applying Binary Search on this Virtual Array
        int n = matrix.length;
        int m = matrix[0].length;
        int low=0;
        int high=m*n-1;//Index of last element in flattened array

        //Binary Search

        while(low<=high){

            int mid=low+(high-low)/2;
            //Finding 2D position of this mid 1D index

            int row=mid/m;//if we are assuming row Major standard
            int col=mid%m;//m is number of columns

            if(matrix[row][col]==ele){
                return true;
            }else if(matrix[row][col]>ele){
                //Update high
                high=mid-1;
            }else{
                //Update low
                low=mid+1;
            }

        }
        return false;
    }


}
