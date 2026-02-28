package Bit_Manipulation;

public class Binary_Concat {

    public static void main(String[] args) {
        System.out.println("Number After Concatenating binary numbers from 1 to n :  "+concatenatedBinary(3));
    }


    static final int M = 1000000007;

    public static int concatenatedBinary(int n) {
        //As internally Integers are stored in bits so direct manipulation is possible using bitwise operators
        long res = 0;
        int bits = 0;
        for (int i = 1; i <= n; i++) {

            if ((i & (i - 1)) == 0) {
                bits++;
            }

            res = ((res << bits) % M + i) % M;

        }
        return (int) res;

    }

}