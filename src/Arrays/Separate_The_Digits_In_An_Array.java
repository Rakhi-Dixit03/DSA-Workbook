package Arrays;

import java.util.*;

//TC- O(N∗log(max(Numbers)))
//Approach : Iterate through numbers, convert to string or use math to extract digits, and append to result.

public class Separate_The_Digits_In_An_Array {

    public static int[] separateDigits(int[] numbers) {

        List<Integer> ans = new ArrayList<>();

        for (int num : numbers) {

            if (num > 9) {

                String digits = String.valueOf(num);

                for (int j = 0; j < digits.length(); j++) {

                    ans.add(digits.charAt(j) - '0');
                }
            } else {

                ans.add(num);
            }

        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {

        System.out.println("Array After Separation : "+Arrays.toString(separateDigits(new int[]{12,45,76,4,23})));

    }

}
