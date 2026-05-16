package BinarySearch;

//TC- Best Case O(log N)
//Worst Case O(N)
public class Find_Min_Ele_In_Rotated_Sorted_Arr_2 {

    public static int findMin(int[] numbers) {

        int n = numbers.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (numbers[mid] > numbers[r]) {

                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;

            } else {//equal case

                r--;//as numbers[mid]==numbers[r] hence removing one cannot lose minimum value but reduce the search space but in worst case loop will run O(N) times

            }

        }
        return numbers[l];
    }

    public static void main(String[] args) {

        System.out.println("Minimum Element is : "+findMin(new int[]{5,6,7,8,0,1,2,3,4}));
    }



}
