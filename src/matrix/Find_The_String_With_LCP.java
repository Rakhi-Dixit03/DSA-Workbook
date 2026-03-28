package matrix;
import java.util.Arrays;
public class Find_The_String_With_LCP {

    //Key_Idea : Constructing the lexicographically smallest string
    // by enforcing LCP constraints via greedy assignment and validation.
    //TC-O(N^2)
    //SC-O(N^2)

    public static void main(String[] args) {

        int[][] lcp={{4,0,2,0},{0,3,0,1},{2,0,2,0},{0,1,0,1}};

        Find_The_String_With_LCP obj=new Find_The_String_With_LCP();

        System.out.println(obj.findTheString(lcp));
    }
    private int[][] validateLcp(String s) {
        int n = s.length();
        int[][] lcp = new int[n][n];
        //Last Row

        for (int j = 0; j < n; j++) {
            if (s.charAt(n - 1) == s.charAt(j)) {
                lcp[n - 1][j] = 1;
            } else {
                lcp[n - 1][j] = 0;
            }

        }

        //Last Column
        for (int i = 0; i < n; i++) {
            if (s.charAt(n - 1) == s.charAt(i)) {
                lcp[i][n - 1] = 1;
            } else {
                lcp[i][n - 1] = 0;
            }

        }

        //remaining Matrix

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }

        return lcp;
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        StringBuilder sb = new StringBuilder();

        sb.append("$".repeat(n));

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (lcp[i][j] != 0) {
                    sb.setCharAt(i, sb.charAt(j));
                    break;
                }

            }



            if (sb.charAt(i) == '$') {

                boolean[] forbidden = new boolean[26];
                for (int j = 0; j < i; j++) {

                    int idx = sb.charAt(j) - 'a';
                    forbidden[idx] = true;
                }

                for (int idx = 0; idx < 26; idx++) {
                    if (!forbidden[idx]) {
                        sb.setCharAt(i, (char)(idx + 'a'));
                        break;
                    }
                }

                if (sb.charAt(i) == '$') {
                    return "";
                }

            }

        }

        return Arrays.deepEquals(validateLcp(sb.toString()),lcp)? sb.toString() : "";

    }


}
