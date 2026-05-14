package Arrays;

public class Is_Array_Good {

    //Validating array properties by checking length, maximum value,
    // and element frequency constraints.
    //TC-O(N)
    //SC-O(N)
    public static boolean isGood(int[] numbers) {

        int n = numbers.length;
        int max = n-1;

        boolean []exist = new boolean[n + 1];

        if (n != (max + 1))
            return false;
        int countMax = 0;

        for (int num : numbers) {

            if (num > max) {
                return false;

            } else if (num == max) {
                countMax++;

            } else {
                if (exist[num]) {
                    return false;
                } else {
                    exist[num] = true;
                }

            }

        }

        return countMax == 2;

    }

    public static void main(String[] args) {

        System.out.println("Is Array Good ? : "+isGood(new int[]{1,3,4,2,4}));
    }


}
