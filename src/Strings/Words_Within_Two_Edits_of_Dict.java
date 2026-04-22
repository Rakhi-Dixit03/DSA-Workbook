package Strings;
import java.util.*;

//Ques : 2452
//O(Q*N*L) ~ O(N^3)
//Comparing each query against every dictionary word to count character differences within a limit.
public class Words_Within_Two_Edits_of_Dict {

    public static void main(String[] args) {
        String[] queries= {"word","note","ants","wood"};
        String[] dictionary ={"wood","joke","moat"};

        System.out.println("List of words within 2 Dictionary Edits :  "+twoEditWords(queries,dictionary));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> ans = new ArrayList<>();

        for (String query : queries) {

            for (String word : dictionary) {

                int diff = 0;

                for (int i = 0; i < word.length(); i++) {

                    if (word.charAt(i) != query.charAt(i)) {
                        diff++;

                    }

                    if (diff > 2)
                        break;

                }

                if (diff <= 2) {
                    ans.add(query);
                    break;
                }

            }

        }
        return ans;

    }

}
