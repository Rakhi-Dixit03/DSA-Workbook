package Sliding_Window;

//TC-O(N)
//SC-O(1)

public class Max_Len_SubString_With_Two_Occurrences {

    public static int maximumLengthSubstring(String s) {

        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = Integer.MIN_VALUE;

        int[] freq = new int[26];

        while (r < n) {

            char ch = s.charAt(r);

            freq[ch - 'a']++;

            //if curr window is invalid reduce the size

            while (freq[ch - 'a'] > 2) {

                char curr = s.charAt(l);
                freq[curr - 'a']--;
                l++;
            }

            //when window becomes valid
            int len = r - l + 1;//curr length

            maxLen = Math.max(maxLen, len);

            r++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Maximum Length of SubString With " +
                "At Most Two Occurrences : "+maximumLengthSubstring("bcbbbcba"));
    }

}
