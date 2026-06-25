package Arrays;
  //TC-O(N^2)
public class Count_SubArrays_With_Majority_Ele {

    public static int countMajoritySubArrays(int[] numbers, int target) {
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

    public static void main(String[] args) {
        System.out.println("Count of SubArrays with Majority Elements is : "+countMajoritySubArrays(new int[]{1,2,2,3},2));

    }
}


