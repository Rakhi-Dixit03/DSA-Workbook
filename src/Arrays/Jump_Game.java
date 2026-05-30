package Arrays;

//Tricky Problem 3660
//TC-O(N)
//SC-O(N)
public class Jump_Game {

    public static int[] maxValue(int[] nums) {

        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] res = new int[n];

        //Calculate prefix maximum
        prefixMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(nums[i], prefixMax[i - 1]);
        }

        //Calculate suffix minimum
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        //Build answer array
        res[n - 1] = prefixMax[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (prefixMax[i] > suffixMin[i+1]) {

                res[i] = res[i + 1];//belongs to same segment [merge]

            } else {//reset - new segment starts

                res[i] = prefixMax[i];
            }

        }
        return res;

    }

    public static void main(String[] args) {

        System.out.println("Answer : "+java.util.Arrays.toString(maxValue(new int[]{1,2,3,7,8,2,4})));
    }


}
