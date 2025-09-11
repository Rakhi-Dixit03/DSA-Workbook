package Arrays;

public class Power_xn {

    public static void main(String[] args) {

        System.out.println("Brute force Solution Power of x : " + power_xnBruteForce(4, -4));
        System.out.println("Optimised Solution Power of x : " + power_xnOptimised(4, -4));
    }


    public static double power_xnBruteForce(double x, int n) {

        //Base case
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            n = Math.abs(n);
            x = 1.0/x;
        }

        return x * power_xnBruteForce(x, n - 1);
    }


    //Binary Exponentiation
    public static double power_xnOptimised(double x, int n) {
        if(n==0)return 1;

        if(n<0){
            n=Math.abs(n);
            x=1.0/x; //inverting the base
        }

        double ans = 1;
        while (n != 0) {

            if ((n & 1) != 0) {
                ans = ans * x;

            }
            x = x * x;
            n=n>>1;

        }
        return ans;
    }
}