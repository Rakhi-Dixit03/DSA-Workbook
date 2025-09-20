package BinarySearch;

public class PeakIndex {

    public static void main(String[] args) {


        int[] arr={0,1,4,7,10,2,1};
        System.out.println("Peak Index in Mountain Array Using Brute Force : "+peakIndex1(arr));
        System.out.println("Peak Index in Mountain Array Using Binary Search : "+peakIndex2(arr));


    }

    //Brute Force O(N)
    public static int peakIndex1(int[] arr){

        for(int i=1;i<arr.length-1;i++){

            if(arr[i]>arr[i-1] && arr[i]>arr[i+1] ){
                return i;
            }
        }
      return -1;
    }

    //O(logN)
    public static int peakIndex2(int[] arr){

    int low=0;
    int high=arr.length-1;

    while(low<=high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;

        }
        //Increasing Part
        if (arr[low] <= arr[mid]) {
            //right side
            low = mid + 1;
        } else {
            //Decreasing Part
            //left side
            high = mid - 1;
        }

    }

   return -1;
    }

}
