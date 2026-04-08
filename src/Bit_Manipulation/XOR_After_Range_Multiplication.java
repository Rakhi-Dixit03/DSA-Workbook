package Bit_Manipulation;

public class XOR_After_Range_Multiplication {

    public final static int mod = 1000000007;

    public static void main(String[] args) {
        int[][] q={{0,2,1,4}};
        System.out.println("XOR After Queries : "+xorAfterQueries(new int[]{1,1,1},q));

    }
    //TC : O(q*n)
    //SC : O(1)
    public static int xorAfterQueries(int[] numbers, int[][] queries) {

        for (int[] q : queries) {

            int idx = q[0];
            while (idx <= q[1]) {
                numbers[idx] = (int)(((long) numbers[idx] * q[3]) % mod);
                idx += q[2];
            }
        }

        int xor = 0;
        for (int i : numbers) {
            xor ^= i;
        }

        return xor;
    }

}
