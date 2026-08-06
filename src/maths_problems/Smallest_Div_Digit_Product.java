package maths_problems;

//TC - O(n*d)
//SC - O(1)
public class Smallest_Div_Digit_Product {

    public int smallestNumber(int n, int t) {

        int num = n;

        while ((prod(num) % t) != 0) {
            num++;
        }
        return num;

    }

    private int prod(int n) {

        int p = 1;
        while (n != 0) {
            p *= n % 10;
            n = n / 10;

        }
        return p;
    }

    public static void main(String[] args) {
        Smallest_Div_Digit_Product obj = new Smallest_Div_Digit_Product();
        System.out.println("Smallest Number Whose Digits Product Divisible By t is :  "+obj.smallestNumber(11,3));
    }
}
