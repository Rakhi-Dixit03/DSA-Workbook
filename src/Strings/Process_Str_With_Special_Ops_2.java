package Strings;

public class Process_Str_With_Special_Ops_2 {

    public static char processStr(String s, long k) {

        int n = s.length();
        long L = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '*') {
                if (L > 0) {
                    L--;
                }

            } else if (ch == '#') {
                L *= 2;

            } else {

                L++;
            }

        }

        if (k >= L) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {

            char ch = s.charAt(i);
            if (ch == '*') {
                L++;
            } else if (ch == '#') {
                L = L / 2;
                k = k % L;

            } else if (ch == '%') {

                //No change in Length
                k = L - k - 1;

            } else {// a to z

                L--;

            }

            if (k == L) {
                return s.charAt(i);
            }

        }

        return '.';
    }

    public static void main(String[] args) {

        System.out.println("Processed String is : "+processStr("cd%#*#",3));

    }

}
