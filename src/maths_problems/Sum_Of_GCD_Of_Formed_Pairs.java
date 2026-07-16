package maths_problems;

//TC - O(NlogN)
//SC- O(1)
public class Sum_Of_GCD_Of_Formed_Pairs {

    static int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;

        }

        return a;

    }

    public static long gcdSum(int[] numbers) {

        int n = numbers.length;
        int maxVal = 0;
        for (int i = 0; i < n; i++) {

            if (numbers[i] > maxVal) {
                maxVal = numbers[i];
            }

            numbers[i] = gcd(maxVal, numbers[i]);

        }

        java.util.Arrays.sort(numbers);

        long gcdSum = 0;

        for (int i = 0; i < n / 2; i++) {

            gcdSum += gcd(numbers[i], numbers[n - i - 1]);

        }

        return gcdSum;

    }

    public static void main(String[] args) {
        System.out.println("Sum of GCD of Formed pairs is : "+gcdSum(new int[]{2,6,4}));
    }
}
