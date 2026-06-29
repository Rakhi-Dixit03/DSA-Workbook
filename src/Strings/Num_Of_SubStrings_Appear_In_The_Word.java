package Strings;

public class Num_Of_SubStrings_Appear_In_The_Word {

    //TC-O(N*M*K)

    public static int numOfStrings(String[] patterns, String word) {

        int count=0;

        for(String str : patterns){

            if(word.contains(str)){
                count++;
            }


        }

        return count;
    }


    //TC-O(P*N + P(M))
    public static int numOfStrings1(String[] patterns, String word) {

        int N = word.length();

        int count = 0;

        for (String str : patterns) {

            int M = str.length();
            int[] LPS = new int[M];

            computeLPS(LPS, str);

            int i = 0;
            int j = 0;

            while (i < N) {

                if (word.charAt(i) == str.charAt(j)) {
                    i++;
                    j++;

                    if (j == M) {

                        count++;
                        break;

                    }

                } else {

                    if (j != 0) {

                        j = LPS[j - 1];

                    } else {
                        i++;
                    }

                }

            }

        }

        return count;

    }

    static void computeLPS(int[] LPS, String str) {

        int M = str.length();
        LPS[0] = 0;
        int length = 0;
        int i = 1;

        while (i < M) {

            if (str.charAt(i) == str.charAt(length)) {

                length++;
                LPS[i] = length;
                i++;

            } else {

                if (length != 0) {

                    length = LPS[length - 1];

                } else {

                    LPS[i] = 0;
                    i++;
                }

            }
        }

    }

    public static void main(String[] args) {

        System.out.println("Number of Sub Strings that Appear in the word : "+numOfStrings(new String[]{"a","abc","bc","d"},"abc"));
        System.out.println("Number of Sub Strings that Appear in the word : "+numOfStrings1(new String[]{"a","abc","bc","d"},"abc"));
    }

}
