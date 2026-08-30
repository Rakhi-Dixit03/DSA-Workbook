package Greedy;

public class Removing_Min_Max_From_Array {
    //TC - O(N)
    //SC - O(1)
    public static int minimumDeletions(int[] numbers) {
        int n = numbers.length;

        int minElIdx = 0, maxElIdx = 0;
        for (int i = 1; i < n; i++) {
            if (numbers[i] < numbers[minElIdx]) minElIdx = i;
            if (numbers[i] > numbers[maxElIdx]) maxElIdx = i;
        }

        int left  = Math.min(minElIdx, maxElIdx);
        int right = Math.max(minElIdx, maxElIdx);

        return Math.min(left + 1 + n - right, Math.min(right + 1, n - left));
    }

    public static void main(String[] args) {
         int[] arr ={2,10,7,5,4,1,8,6};
        System.out.println("Minimum number of deletions : "+minimumDeletions(arr));
    }


}
