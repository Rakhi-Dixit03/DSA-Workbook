package maths_problems;

public class Max_Prod_Three_Num {

    public static int maximumProduct(int[] numbers) {

        int n = numbers.length;
        java.util.Arrays.sort(numbers);

        return Math.max((numbers[n - 1] * numbers[n - 2] * numbers[n - 3]), (numbers[0] * numbers[1] * numbers[n - 1]));

    }

    public static void main(String[] args) {
        System.out.println("Maximum Product of Three Numbers : "+maximumProduct(new int[]{-8,-5,-1,0,2,3,4}));
    }
}
