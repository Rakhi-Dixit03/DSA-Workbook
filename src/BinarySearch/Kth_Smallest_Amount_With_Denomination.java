package BinarySearch;

public class Kth_Smallest_Amount_With_Denomination {

    private long countSmaller(long mid, int[] coins) {
        long correctedCount = 0;
        int n = coins.length;

        // 2^n * n * log(maxCoin)
        for (int expressions = 1; expressions <= (1 << n) - 1; expressions++) { // 2^n-1 expressions
            long lcm = 0;
            long order = 0; // even or odd order of expressions

            for (int i = 0; i < n; i++) {
                if ((expressions & (1 << i)) != 0) {
                    order++; // we have taken ith coin

                    if (lcm == 0) {
                        lcm = coins[i];
                    } else {
                        lcm = lcm * coins[i] / gcd(lcm, coins[i]);
                    }
                }
            }

            if (order % 2 == 0) { // even then subtract
                correctedCount -= mid / lcm;
            } else {
                correctedCount += mid / lcm;
            }
        }

        return correctedCount;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long findKthSmallest(int[] coins, int k) {
        long result = -1;

        int maxCoin = 0;
        for (int c : coins) maxCoin = Math.max(maxCoin, c);

        long l = 1;
        long r = (long) maxCoin * k;

        // log(maxCoin * k) * 2^n * n * log(maxCoin)
        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (countSmaller(mid, coins) >= k) { // left side me we can find the kth smallest element
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] coins={3,6,9};
        Kth_Smallest_Amount_With_Denomination obj =new Kth_Smallest_Amount_With_Denomination();

        System.out.println("Kth Smallest Amount With Single Denomination Combination: "+obj.findKthSmallest(coins,3));
    }


}
