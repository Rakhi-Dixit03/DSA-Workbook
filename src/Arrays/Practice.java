package Arrays;

public class Practice {


    public static void main(String[] args) {

        System.out.println("Single Element : "+singleNonDuplicate(new int[]{1,1,2,3,3,4,4,5,5}));

    }

        public static int singleNonDuplicate(int[] A) {

            int N = A.length;
            int low = 0;
            int high = N - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (A[mid] == A[mid - 1]) {

                    //Go to left side because number of elements there will be odd
                    high=mid-1;


                } else if (A[mid] == A[mid + 1]) {
                    //Go to right Side
                    low=mid+1;

                } else {
                    return mid;
                }
            }

            return -1;

        }
    }

