package BinarySearch;

//Finding the minimum in a rotated sorted array using modified binary search
// by comparing mid with right boundary.
//TC-O(log N)

public class Find_Min_In_Sorted_Rotated_Array {

    public static int findMin(int[] numbers) {

        int n = numbers.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (numbers[mid] > numbers[r]) {

                l = mid + 1;
            } else {

                r = mid;
            }

        }

        return numbers[l];
    }

    public static void main(String[] args) {

        System.out.println("Minimum Element is : "+findMin(new int[]{5,6,7,8,0,1,2,3,4}));
    }

}
