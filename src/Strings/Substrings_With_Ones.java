package Strings;

//LeetCode  1513
//Good example of Streak calculation
public class Substrings_With_Ones {

    public static void main(String[] args) {

        String s="0110111";
        System.out.println("Number of SubStrings with only ones : "+numSub(s));

    }


    static int MOD = 1000000007;

    public static int numSub(String s) {

        long answer = 0;
        long countOnes = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '0') {

                answer += (countOnes * (countOnes + 1)) / 2;
                countOnes = 0;

            } else {

                countOnes++;
            }

        }

        if (countOnes != 0) answer += (countOnes * (countOnes + 1)) / 2;

        return (int) (answer % MOD);


    }
}