package Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] nums={1,2,2,0,0,1,1,2,0};
        System.out.println("Sorted Array : ");
        sortNumbers3(nums);
        printArr(nums);



    }
    //Brute Force Applying any of the sorting algorithm --Bubble Sort--

    public static void sortNumbers1(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
        }

    }

    //Better Approach Using frequency count variables since there are only three numbers 0,1,2
    public static void sortNumbers2(int[] arr){
        int n=arr.length;

        int zeroes=0;
        int ones=0;
        int twos=0;

        for (int j : arr) {

            if (j == 0) {
                zeroes++;
            } else if (j == 1) {
                ones++;

            } else {
                twos++;
            }

        }

        int i = 0;
        while (zeroes-- != 0) arr[i++] = 0;
        while (ones-- != 0) arr[i++] = 1;
        while (twos-- != 0) arr[i++] = 2;



    }

   //Optimal Approach Using Dutch National Flag algorithm
    public static void sortNumbers3(int[] arr){
        int n=arr.length;
        int left=0;
        int right=n-1;
        int mid=0;

        while(mid<=right){

            if(arr[mid]==0){

                arr[mid]=arr[left];
                arr[left]=0;
                mid++;
                left++;

            }else if(arr[mid]==2){

                arr[mid]=arr[right];
                arr[right]=2;
                right--;

            }else{
                mid++;
            }

        }
    }

    public static void printArr(int[] arr){
        for(int ele:arr){
            System.out.print(ele+" ");
        }

    }

}
