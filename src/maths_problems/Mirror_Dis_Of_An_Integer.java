package maths_problems;

public class Mirror_Dis_Of_An_Integer {
   //Ques : 3783
   //Reversing integer digits via modulo arithmetic and calculating absolute difference.
    public static void main(String[] args) {
        System.out.println("Mirror Distance of an Integer : "+mirrorDistance(12));
    }

    public static int reverse(int n) {

        int rev = 0;
        while (n > 0) {

            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }

    public static int mirrorDistance(int n) {

        return Math.abs(n - reverse(n));
    }

}
