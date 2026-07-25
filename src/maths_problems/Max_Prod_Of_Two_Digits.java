package maths_problems;

public class Max_Prod_Of_Two_Digits {

    public  static int maxProduct1(int n) {

        String num = String.valueOf(n);

        char[] arr = num.toCharArray();

        java.util.Arrays.sort(arr);


        int a = arr[arr.length-1]-'0';
        int b = arr[arr.length-2]-'0';

        return a*b;

    }

    public static int maxProduct2(int n) {

        int max1 = 0;
        int max2 = 0;

        while (n > 0) {

            int digit = n % 10;
            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;

            }

            n = n / 10;
        }

        return max1 * max2;
    }
    public static void main(String[] args) {

        System.out.println("Maximum Product of 2 Digits : "+maxProduct1(3479));
        System.out.println("Maximum Product of 2 Digits : "+maxProduct2(3454));

    }


}
