package Arrays;
import java.util.*;

public class Distribute_Ele_Into_Two_Arrays_1 {

    //TC-O(N)
    //SC-O(N)
    public static int[] resultArray(int[] numbers) {

        int n = numbers.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(numbers[0]);
        arr2.add(numbers[1]);

        for (int i = 2; i < numbers.length; i++) {

            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(numbers[i]);

            } else {

                arr2.add(numbers[i]);

            }

        }

        int idx = 0;
        int[] res = new int[n];

        for (int ele : arr1) {
            res[idx] = ele;
            idx++;
        }

        for (int ele : arr2) {
            res[idx] = ele;
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Resultant Array After Distribution :  "+Arrays.toString(resultArray(new int[]{3,2,5,6,7})));
        System.out.println("Resultant Array After Distribution :  "+Arrays.toString(resultArray1(new int[]{3,2,5,6,7})));
    }

    //TC-O(N)
    //SC-O(1)
    public static int[] resultArray1(int[] numbers) {

        int n = numbers.length;
        int[] res = new int[n];
        int idx = 0;
        int revIdx = n - 1;

        res[0] = numbers[0];
        res[n - 1] = numbers[1];

        for (int i = 2; i < numbers.length; i++) {

            if (res[idx] > res[revIdx]) {
                res[++idx] = numbers[i];

            } else {

                res[--revIdx] = numbers[i];

            }

        }

        for (int l = revIdx, r = n - 1; l < r; l++, r--) {

            int temp = res[l];
            res[l] = res[r];
            res[r] = temp;

        }

        return res;
    }

}
