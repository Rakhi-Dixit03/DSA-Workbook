package maths_problems;

//TC-O(1)
//SC-O(1)

public class GCD_Of_Odd_And_Even_Sum {
    //Deriving GCD of arithmetic series sums using mathematical properties.

    public static int gcdOfOddEvenSums1(int n) {

        int sumOdd = n * n;
        int sumEven = n * (n + 1);
        while (sumOdd != sumEven) {

            if (sumOdd > sumEven) {
                sumOdd = sumOdd - sumEven;

            } else {
                sumEven = sumEven - sumOdd;
            }

        }

        return sumEven;
    }

    //Using Mathematical Proofs
    public static int gcdOfOddEvenSums2(int n) {
        return n;

    }

    public static void main(String[] args) {
        System.out.println("GCD of Two series is : "+gcdOfOddEvenSums1(4));
        System.out.println("GCD of Two series is : "+gcdOfOddEvenSums2(4));
    }
}
