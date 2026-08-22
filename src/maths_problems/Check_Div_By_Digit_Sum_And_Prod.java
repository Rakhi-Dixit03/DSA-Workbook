package maths_problems;

public class Check_Div_By_Digit_Sum_And_Prod {

    public static boolean checkDivisibility(int n) {

        int num = n;
        int sum = 0;
        int digitProd = 1;

        while (num > 0) {

            int ld = num % 10;
            sum += ld;
            digitProd *= ld;
            num /= 10;

        }

        return (n % (sum + digitProd)) == 0;
    }

    public static void main(String[] args) {
        System.out.println("Is n divisible By  sum of given two values : "+checkDivisibility(456));
    }
}
