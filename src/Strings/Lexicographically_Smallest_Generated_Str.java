package Strings;

public class Lexicographically_Smallest_Generated_Str {

    public static void main(String[] args) {
        Lexicographically_Smallest_Generated_Str obj=new Lexicographically_Smallest_Generated_Str();

        System.out.println("Lexicographically Smallest Generated String is : "+obj.generateString("TFTF","ab"));
    }

    boolean isSame(String word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {

            if (word.charAt(i) != str2.charAt(j)) {
                return false;
            }
            i++;

        }
        return true;

    }

    public String generateString(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        StringBuilder word = new StringBuilder();
        word.append("$".repeat(n + m - 1));
        boolean[] canChange = new boolean[n + m - 1];

        for (int i = 0; i < n; i++) {
            //Process the 'T'
            if (str1.charAt(i) == 'T') {
                int k = i;
                for (int j = 0; j < m; j++) {

                    if (word.charAt(j + i) != '$' && word.charAt(j + i) != str2.charAt(j)) {
                        return "";
                    }

                    word.setCharAt(k, str2.charAt(j));
                    k++;
                }

            }

        }

        //Fill the remaining spaces with lexicographically small character 'a'
        for (int i = 0; i < n + m - 1; i++) {
            if (word.charAt(i) == '$') {
                word.setCharAt(i, 'a');
                canChange[i] = true;
            }
        }

        //Handle 'F'
        //T.C : O(n*m)
        //SC : O(n+m-1)
        for (int i = 0; i < n; i++) {

            if (str1.charAt(i) == 'F') {
                if (isSame(word.toString(), str2, i, m)) {//if same then we need to unequal it
                    boolean changed = false;
                    for (int k = i + m - 1; k >= i; k--) {

                        if (canChange[k]) {
                            word.setCharAt(k, 'b');
                            changed = true;
                            break;
                        }

                    }

                    if (!changed) {//I was not able to change any character to break equality
                        return "";
                    }
                }

            }

        }
        return word.toString();
    }


}

