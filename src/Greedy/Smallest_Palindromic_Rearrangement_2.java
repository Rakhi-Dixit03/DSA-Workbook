package Greedy;

//TC- O(N^2)
//SC - O(N)
public class Smallest_Palindromic_Rearrangement_2 {

    static long nCr(int n, int r, int k) {

        r = n - r;
        long ways = 1;
        for (int i = 1; i <= r; i++) {

            ways = ways * (n - r + i) / i;

            if (ways >= k) {
                return k;//early return
            }

        }
        return ways;

    }

    public static String smallestPalindrome(String s, int k) {

        int n = s.length();
        char mid = '@';
        int half = n / 2;

        if (n % 2 == 1) {//odd length string

            mid = s.charAt(n / 2);
        }

        int[] freq = new int[26];

        for (int i = 0; i < half; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < half; i++) {//position filling

            boolean selected = false;

            for (int j = 0; j < 26; j++) {

                if (freq[j] != 0) {

                    freq[j] -= 1;
                    //count how many permutations we get by fixing current element
                    long ways = 1;
                    int positions = half - i - 1;

                    for (int c = 0; c < 26; c++) {

                        if (freq[c] > 0) {

                            ways *= nCr(positions, freq[c], k);
                            positions -= freq[c];
                        }

                        if (ways >= k) {
                            break;
                        }

                    }

                    if (k <= ways) {//we can fix current char at ith position
                        res.append((char) (j + 'a'));
                        selected = true;
                        break;
                    }

                    //when k>num of ways we cannot choose curr char
                    k -= (int)ways;//remaining k
                    freq[j] += 1;//since we didn't use curr char

                }

            }

            if (!selected)
                return "";

        }

        //Half result is built now append mid and build the next half

        int limit = res.length() - 1;//Handling Odd length case

        if (mid != '@') {
            res.append(mid);
            limit = res.length() - 2;
        }

        for (int i = limit; i >= 0; i--) {
            res.append(res.charAt(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Smallest Palindromic Rearrangement is : "+smallestPalindrome("inini",2));
    }


}
