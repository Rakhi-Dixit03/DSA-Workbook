package Stack_and_Queues;

import java.util.*;

//TC - O(N)
//SC - O(N)
public class Smallest_SubSeq_Of_Distinct_Chars {

    public static String smallestSubsequence(String s) {

        boolean[] vis = new boolean[26];

        java.util.Stack<Character> st = new java.util.Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (!vis[curr - 'a']) {//if distinct char

                while (!st.isEmpty() && curr < st.peek() && map.get(st.peek()) > 1) {

                    char prev = st.peek();
                    st.pop();
                    map.put(prev, map.get(prev) - 1);
                    vis[prev - 'a'] = false;

                }

                st.add(curr);
                vis[curr - 'a'] = true;

            } else {
                //if we are skipping a character then we also have to reduce its frequency
                map.put(curr, map.get(curr) - 1);
            }

        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {

            ans.append(st.pop());

        }

        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println("Smallest SubSequence with all Distinct characters is :  "
                +smallestSubsequence("cbacdcbc"));
    }



}
