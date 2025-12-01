package BinarySearch;

public class Max_runningTime_of_N_Computers {

    public static void main(String[] args) {

         int[] bat={3,3,3};
         int n=2;
        System.out.println("Maximum Running Time of N computers when run simultaneously : "+maxRunTime(n,bat));


    }

    public static long maxRunTime(int n, int[] batteries) {
        //Binary Search on answer

        long sum = 0;
        long min = Integer.MAX_VALUE;

        for (int bat : batteries) {

            sum += bat;
            min = Math.min(min, bat);
        }

        long l = min;
        long r = sum / n;
        long res = 0;

        while (l <= r) {

            long mid = l + (r - l) / 2;

            if (isPossible(mid, batteries, n)) {
                res = mid;
                l = mid + 1;

            } else {
                r = mid - 1;
            }

        }

        return res;

    }

    private static boolean isPossible(long mid, int[] batteries, int n) {

        long avail_batt = 0;

        for (int i = 0; i < batteries.length; i++) {

            avail_batt += Math.min(batteries[i], mid);

        }

        if (avail_batt < mid * n)
            return false;

        return true;

    }


}
