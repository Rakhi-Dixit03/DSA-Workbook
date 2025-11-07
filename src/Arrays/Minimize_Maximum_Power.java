package Arrays;
//Best Use of Difference Array

public class Minimize_Maximum_Power {

    public static void main(String[] args) {

        int[] stations={1,2,4,5,0};

        Minimize_Maximum_Power obj=new Minimize_Maximum_Power();

        System.out.println("Maximum Minimum power of a City is : "+obj.maxPower(stations,1,2));


    }


    private boolean check(long mid, long[] diff, int r, int k, int n) {

        long[] temp = java.util.Arrays.copyOf(diff, n);

        long cumSum = 0;//It will give power of a city at any given point of time

        //Accumulation

        for (int i = 0; i < n; i++) {

            cumSum += temp[i];

            if (cumSum < mid) {

                long need = mid - cumSum;

                if (need > k)
                    return false;

                k -= need;
                cumSum += need;//Greedily chosen to add station on the city which can cover more range

                if (i + 2L * r +1< n) {
                    temp[(int)(i + 2L * r + 1)] -= need;//Applying diff Array Technique
                }

            }
        }
        return true;

    }

    public long maxPower(int[] stations, int r, int k) {

        int n = stations.length;

        long[] diff = new long[n];

        for (int i = 0; i < n; i++) {

            diff[Math.max(i - r, 0)] += stations[i];//At left range adding val
            if (i + r + 1 < n) {
                diff[i + r + 1] -= stations[i];//At right range subtracting val
            }

        }

        long right = java.util.Arrays.stream(stations).asLongStream().sum()+k;
        long min = Integer.MAX_VALUE;
        for (int num : stations) {

            if (min > num) {
                min = num;
            }

        }
        long left = min;
        long result = 0;
        //Binary Search on Minimum Power stations for a city

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (check(mid, diff, r, k, n)) {
                result = mid;
                left = mid + 1;

            } else {
                right = mid - 1;

            }

        }
        return result;

    }



}
