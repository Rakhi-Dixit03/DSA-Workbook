package Strings;
//Ques 3121
public class Count_The_Special_Chars_2 {

    public static int numberOfSpecialChars(String word) {
        int[] lastLow = new int[26];
        int[] firstUp = new int[26];
        java.util.Arrays.fill(lastLow, -1);
        java.util.Arrays.fill(firstUp, -1);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastLow[c - 'a'] = i;
            } else {
                if (firstUp[c - 'A'] == -1) {
                    firstUp[c - 'A'] = i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLow[i] != -1 && firstUp[i] != -1 && lastLow[i] < firstUp[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("Total numbers of special characters " +
                "in the string are : "+numberOfSpecialChars("AbBCab"));
    }
}

