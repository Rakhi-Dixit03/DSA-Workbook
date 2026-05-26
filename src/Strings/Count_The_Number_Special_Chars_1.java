package Strings;

//Ques 3120
//Using fixed-size boolean arrays to track character presence for constant-time lookups.
//TC-O(N)
//SC-O(1)//constant space
public class Count_The_Number_Special_Chars_1 {


    public static int numberOfSpecialChars(String word) {

        boolean[] lowerCase = new boolean[26];
        boolean[] upperCase = new boolean[26];

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if ('A'<=ch && ch<='Z') {

                if(!upperCase[ch-'A']){
                    upperCase[ch - 'A'] = true;
                }

            } else {
                if (!lowerCase[ch - 'a']) {
                    lowerCase[ch - 'a'] = true;
                }

            }

        }

        int count = 0;
        for (int i = 0; i < 26; i++) {

            if (lowerCase[i] && upperCase[i]) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println("Total numbers of special characters " +
                "in the string are : "+numberOfSpecialChars("AaBBcccCbDeE"));
    }
}
