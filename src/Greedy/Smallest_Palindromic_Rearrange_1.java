package Greedy;

//TC - O(N)
//SC - O(26) i.e. O(1)
//Key Idea: Construct the smallest palindrome by sorting half characters.

public class Smallest_Palindromic_Rearrange_1 {

    public static String smallestPalindrome1(String s) {

        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        for (char ch : arr) {

            freq[ch - 'a']++;

        }

        StringBuilder sb = new StringBuilder();
        char extraChar = '@';

        for (int i = 0; i < 26; i++) {

            int charFreq = freq[i];

            if (charFreq % 2 == 1) {

                extraChar = (char) (i + 'a');
            }

            int itr = 0;
            while (itr < charFreq / 2) {

                sb.append((char) (i + 'a'));
                itr++;

            }

        }

        int j = sb.length() - 1;

        if (extraChar != '@') {
            sb.append(extraChar);
            j = sb.length() - 2;
        }

        while (j >= 0) {
            sb.append(sb.charAt(j));
            j--;
        }

        return sb.toString();

    }


    //2nd Approach

    public static String smallestPalindrome2(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        for (char ch : arr) {

            freq[ch - 'a']++;

        }

        char[] ans = new char[n];

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < 26; i++) {

            while (freq[i] >= 2) {
                char ch = (char) (i + 'a');
                ans[left++] = ch;
                ans[right--] = ch;
                freq[i] -= 2;

            }

        }

        for (int i = 0; i < 26; i++) {

            if (freq[i] == 1) {
                ans[left] = (char) (i + 'a');
                break;
            }
        }

        return String.valueOf(ans);

    }

    public static void main(String[] args) {

        System.out.println("Smallest Palindromic Rearrangement is : "+smallestPalindrome1("inini"));
        System.out.println("Smallest Palindromic Rearrangement is : "+smallestPalindrome2("bbaaabb"));
    }
}
