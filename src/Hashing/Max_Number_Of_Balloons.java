package Hashing;
import java.util.*;

//Key Idea : Count character frequencies and calculate maximum instances based on limiting characters.
//TC - O(N)
public class Max_Number_Of_Balloons {

    public static int maxNumberOfBalloons1(String text){

        Map<Character, Integer> freq = new HashMap<>();
        String str="balon";


        for(int i=0;i<str.length();i++){

            freq.put(str.charAt(i),0);
        }


        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            }

        }

        int maxBalloons = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {

            if (entry.getKey() == 'l' || entry.getKey() == 'o') {

                maxBalloons = Math.min(maxBalloons, entry.getValue() / 2);
            } else {
                maxBalloons = Math.min(maxBalloons, entry.getValue());
            }

        }

        return maxBalloons;
    }

    public static int maxNumberOfBalloons2(String text) {

        int b_count = 0;
        int a_count = 0;
        int l_count = 0;
        int o_count = 0;
        int n_count = 0;

        for (char ch : text.toCharArray()) {

            if (ch == 'b')
                b_count++;
            else if (ch == 'a')
                a_count++;
            else if (ch == 'l')
                l_count++;
            else if (ch == 'o')
                o_count++;
            else if (ch == 'n')
                n_count++;

        }

        return Math.min(Math.min(a_count, b_count), Math.min(Math.min(l_count / 2, o_count / 2), n_count));

    }

    public static void main(String[] args) {

        System.out.println("Maximum Number of Balloons : "+maxNumberOfBalloons1("loonbalxballpoon"));
        System.out.println("Maximum Number of Balloons : "+maxNumberOfBalloons2("loonbalxballpoon"));

    }


}

