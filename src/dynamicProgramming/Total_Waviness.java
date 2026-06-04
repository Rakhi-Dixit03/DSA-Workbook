package dynamicProgramming;

//TC-O(num2-num1)*log(num2)
//Iterating through a range to simulate digit comparison logic for peaks and valleys.

public class Total_Waviness {

    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int x = num1; x <= num2; x++) {
            String s = String.valueOf(x);

            for (int i = 1; i < s.length() - 1; i++) {
                if ((s.charAt(i) > s.charAt(i - 1) &&
                        s.charAt(i) > s.charAt(i + 1)) ||
                        (s.charAt(i) < s.charAt(i - 1) &&
                                s.charAt(i) < s.charAt(i + 1))) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
