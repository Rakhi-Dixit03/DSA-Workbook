package maths_problems;

public class Find_The_GCD_Of_An_Array {

    static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;

        }
        return a;
    }

    public static int findGCD(int[] numbers) {

        int small = 1001;
        int large = 0;

        for (int num : numbers) {

            small = Math.min(small, num);
            large = Math.max(large, num);

        }

        return gcd(small, large);

    }


    public static void main(String[] args) {

        int[] arr = {2,3,5,6,7,4,7,10};
        System.out.println("GCD of Smallest and Largest Number in the Array is : "+findGCD(arr));
    }
}
