package BinarySearch;

//Ques 1752
//TC-O(N)
public class Check_If_Arr_Sorted_And_Rotated {


    public static boolean check(int[] numbers) {

        int n = numbers.length;
        if (numbers.length <= 1)
            return true;

        int inversionCount = 0;


        for (int i = 1; i < n; i++) {

            if (numbers[i] < numbers[i - 1]) {
                inversionCount++;
            }

            if (inversionCount > 1) {
                return false;
            }

        }

        if (numbers[0] < numbers[n - 1]) {
            inversionCount++;
        }

        return inversionCount <= 1;
    }


    public static void main(String[] args) {

        System.out.println("Is  Array Rotated and Sorted : " + check(new int[]{4, 5, 6, 7, 1, 2, 3}));
    }


}
