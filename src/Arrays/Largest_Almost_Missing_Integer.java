package Arrays;

public class Largest_Almost_Missing_Integer {
    //TC-O(N)
    //SC-O(N)

    public static int largestInteger(int[] numbers, int k) {

        int n = numbers.length;

        int[] freq = new int[51];

        for (int num : numbers) {
            freq[num]++;
        }


        if (k == 1) {//return the largest unique element
            int unique = -1;

            for (int i = 0; i < freq.length; i++) {
                if (freq[i] == 1) {

                    unique = Math.max(unique, i);
                }
            }

            return unique;

        } else if (k == n) {

            int ans = -1;

            for (int num : numbers) {

                ans = Math.max(num, ans);

            }
            return ans;

        } else {

            if (freq[numbers[0]] == 1 && freq[numbers[n - 1]] == 1) {

                return Math.max(numbers[0], numbers[n - 1]);

            } else if (freq[numbers[0]] == 1) {
                return numbers[0];

            } else if (freq[numbers[n - 1]] == 1) {
                return numbers[n - 1];

            } else {
                return -1;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {3,9,7,2,1,7};
        System.out.println("Largest Almost Missing Integer : "+largestInteger(arr,4));
    }

}
