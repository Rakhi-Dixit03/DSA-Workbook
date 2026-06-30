package Sliding_Window;

public class Num_SubStrings_With_All_Three_Chars {

    //TC-O(N)
    //SC-O(1)

    public static int numberOfSubstrings(String s) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int[] map = new int[3];
        int result = 0;

        while (j < n) {

            char ch = s.charAt(j);
            //increase frequency of current character

            map[ch - 'a']++;


            while (map[0] != 0 && map[1] != 0 && map[2] != 0) {//while window remains valid

                result += n - j;
                map[s.charAt(i) - 'a']--;
                i++;

            }

            j++;

        }

        return result;

    }


    public static void main(String[] args) {

        System.out.println("Number of subStrings with All Three Characters :  "+numberOfSubstrings("abcabc"));

    }


}
