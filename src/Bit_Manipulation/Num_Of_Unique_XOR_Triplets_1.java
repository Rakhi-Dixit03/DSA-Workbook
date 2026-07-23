package Bit_Manipulation;

//TC - Log(N)
//Based on Observation only
//Finding the smallest power of 2 greater than n to determine unique XOR values.

public class Num_Of_Unique_XOR_Triplets_1 {

    public static int uniqueXorTriplets(int[] numbers) {

        int n = numbers.length;

        if (n <= 2) {
            return n;
        } else {

            int ans = 1;

            while (ans <= n) {

                ans <<= 1;
            }

            return ans;

        }

    }

    public static void main(String[] args) {

        int[] numbers = {1,3,2,4};
        System.out.println("Number of Unique XOR Triples : "+uniqueXorTriplets(numbers));

    }


}
