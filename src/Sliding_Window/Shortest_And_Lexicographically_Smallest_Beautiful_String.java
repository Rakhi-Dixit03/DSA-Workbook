package Sliding_Window;

public class Shortest_And_Lexicographically_Smallest_Beautiful_String {

    public static String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        int ones = 0;     // number of '1's in window [i, j]
        String result = "";
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '1')
                ones++;
            //remove extra 1's, then trim leading 0's
            while (i<n && (ones > k || s.charAt(i) == '0')) {
                if (s.charAt(i) == '1')
                    ones--;
                i++;
            }
            if (ones == k) {
                String temp = s.substring(i, j + 1);
                if (result.isEmpty()
                        || j - i + 1 < result.length()
                        || (j - i + 1 == result.length() && temp.compareTo(result) < 0)) {
                    result = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Shortest and Lexicographically Smallest Beautiful String : "+shortestBeautifulSubstring("100011001",3));
    }


}
