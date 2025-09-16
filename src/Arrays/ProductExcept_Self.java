package Arrays;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class ProductExcept_Self {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {1, 2, 3, 4};
        System.out.println("Array containing products except self approach 1 : ");
        printArray(productExceptSelf1(arr));
        System.out.println();

        System.out.println("Array containing products except self approach 2 : ");
        printArray(productExceptSelf2(arr1));
    }

    //Using Prefix and Suffix Product Arrays TC-O(N) SC-O(2N)
    public static int[] productExceptSelf1(int[] arr) {

        int n = arr.length;

        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);

        int[] suffix = new int[n];
        Arrays.fill(suffix, 1);

        //Building prefix
        for (int i = 1; i < n; i++) {

            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        //Building suffix
        for (int i = n - 2; i >= 0; i--) {

            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        //Building Product Array
        for (int i = 0; i < n; i++) {

            arr[i] = prefix[i] * suffix[i];

        }
        return arr;
    }


    //Optimal Approach TC-O(N) SC-O(N)

    public static int[] productExceptSelf2(int[] arr) {

        int n = arr.length;
        int[] prod = new int[n];
//        Arrays.fill(prod,1);


        int curr = 1;
        //prefix product
        for (int i = 0; i < n; i++) {
            prod[i] = curr;
            curr *= arr[i];

        }
        curr = 1;//Resetting current

        //Suffix  product
        for (int i = n - 1; i >= 0; i--) {
            prod[i] *= curr;
            curr *= arr[i];

        }

        return prod;
    }


    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}