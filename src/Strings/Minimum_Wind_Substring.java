package Strings;

public class Minimum_Wind_Substring {

    public static void main(String[] args) {
        String t="ABC";
        String s="ADOBECODEBANC";
        System.out.println("Minimum Window SubString : "+minWindSubstring(s,t));

    }
    //CodeStoryWithMIK

    public static String minWindSubstring(String s,String t) {

        //Edge Cases
        int m = s.length();
        int n = t.length();

        if (s == null || t == null || s.isEmpty() || t.isEmpty() || m < n) {
            return "";
        }

        int[] map = new int[128];

        for (char ch : t.toCharArray()) {
            map[ch]++;

        }

        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        int reqCount = t.length();
        int start_idx = 0;


        while (j < m) {

            char ch = s.charAt(j);

            if (map[ch] > 0) {

                reqCount--;

            }

            map[ch]--;

            //Shrinking the window
            while (reqCount == 0) {

                int currWind = j - i + 1;

                if (minLength > currWind) {
                    start_idx = i;
                    minLength = currWind;
                }

                map[s.charAt(i)]++;

                if (map[s.charAt(i)] > 0) {

                    reqCount++;
                }
                i++;

            }
            j++;

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start_idx, start_idx + minLength);
    }

}
