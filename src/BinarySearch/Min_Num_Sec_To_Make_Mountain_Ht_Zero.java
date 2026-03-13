package BinarySearch;

public class Min_Num_Sec_To_Make_Mountain_Ht_Zero {

    //Approach (Binary search on answer)
    //T.C : O(n * log(Tmax * mountainHeight^2), where Tmax = maximum time among all workers in the input, n = length of workerTimes

    public static void main(String[] args) {

        Min_Num_Sec_To_Make_Mountain_Ht_Zero obj = new Min_Num_Sec_To_Make_Mountain_Ht_Zero();
        System.out.println("Minimum Number of seconds needed to make mountain Height 0 : "
                + obj.minNumberOfSeconds(5, new int[]{1, 2, 2}));
    }

    //I was making the mistake of multiplication in line num 36 while finding [r]
    private boolean check(long mid, int[] workerTimes, int mH) {
        long h = 0;

        for (int t : workerTimes) {
            h += (long) (Math.sqrt(2.0 * mid / t + 0.25) - 0.5);

            if (h >= mH) {
                return true;
            }
        }

        return h >= mH;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime = 0;
        for (int t : workerTimes)
            maxTime = Math.max(maxTime, t);

        long l = 1;
        long r = (long) maxTime * mountainHeight * (mountainHeight + 1) / 2;

        long result = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (check(mid, workerTimes, mountainHeight)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }


}