package Greedy;

public class Max_Ele_After_Dec_And_Rearranging {

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;
        java.util.Arrays.sort(arr);
        arr[0] = 1;


        for (int i = 1; i < n; i++) {

            arr[i] = Math.min(arr[i], arr[i - 1] + 1);

        }

        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println("Maximum Element After Decrementing And Rearranging :" +
                " "+maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
    }
}
