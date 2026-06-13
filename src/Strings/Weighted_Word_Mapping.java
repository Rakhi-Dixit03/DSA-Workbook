package Strings;

//TC-O(N*M))
//SC-O(N)
public class Weighted_Word_Mapping {

    public static String mapWordWeights(String[] words, int[] weights) {

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            int sum = 0;

            for (int i=0;i<word.length();i++) {

                char ch = word.charAt(i);

                int w = weights[ch-'a'];
                sum += w;

            }

            sum %= 26;
            char newChar = (char)('z' - sum);

            result.append(newChar);

        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println("Resultant Weighted String is : "+mapWordWeights(words,weights));
    }

}
