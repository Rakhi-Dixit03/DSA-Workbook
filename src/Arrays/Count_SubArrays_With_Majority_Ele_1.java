package Arrays;

//TC-O(N^2)
public class Count_SubArrays_With_Majority_Ele_1 {

    public static int countMajoritySubArrays1(int[] numbers, int target) {
        int n = numbers.length;
        int ans = 0;

        for (int l = 0; l < n; l++) {
            int targetCount = 0;

            for (int r = l; r < n; r++) {
                if (numbers[r] == target) {
                    targetCount++;
                }

                int len = r - l + 1;

                if (targetCount > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int countMajoritySubArrays2(int[] numbers, int target) {

        int res = 0;
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int cumSum = 0;
            for (int j = i; j < n; j++) {

                if (numbers[j] == target) {
                    cumSum++;
                } else {
                    cumSum--;
                }

                if (cumSum > 0) {
                    res++;
                }


            }

        }

        return res;
    }

    //Can use precalculated prefix sum too

    public static int countMajoritySubArrays3(int[] numbers, int target) {

        int res = 0;
        int n = numbers.length;
        int[] prefixArr = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] == target) {
                sum++;
            } else {
                sum--;
            }

            prefixArr[i] = sum;
        }

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int cumSum = prefixArr[j] - ((i - 1) >= 0 ? prefixArr[i - 1] : 0);

                if (cumSum > 0) {
                    res++;
                }


            }

        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println("Count of SubArrays with Majority Elements is : " + countMajoritySubArrays1(new int[]{1, 2, 2, 3}, 2));
        System.out.println("Count of SubArrays with Majority Elements is : " + countMajoritySubArrays2(new int[]{1, 2, 2, 3}, 2));
        System.out.println("Count of SubArrays with Majority Elements is : " + countMajoritySubArrays3(new int[]{1, 2, 2, 3}, 2));

    }
}


