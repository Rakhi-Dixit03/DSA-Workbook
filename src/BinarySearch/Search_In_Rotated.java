package BinarySearch;

public class Search_In_Rotated {

    public static void main(String[] args) {
        int[] arr={5,6,7,0,1,1,2,3,4,4};

        System.out.println("Search Result using Brute Force Index of Target element : "+searchInRotated1(arr,0));
        System.out.println("Search Result using Modified Binary Search Index of Target element : "+searchInRotated2(arr,4));

    }

    public static int searchInRotated1(int[] arr,int tar){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==tar){
                return i;
            }
        }
        return -1;
    }

    public static int searchInRotated2(int[] arr,int tar){

        int low=0;
        int high=arr.length-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(arr[mid]==tar){
                return mid;
            }

            //Identifying  the sorted half

            if(arr[low]<=arr[mid]){

                //Look for target in that range

                if(arr[low] <= tar  && tar <= arr[mid]){

                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else {

                if (arr[mid] <= tar && tar <= arr[high]) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }

            }

        }
        return -1;
    }

}
