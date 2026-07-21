package Arrays;

import java.util.*;

//TC-O(N)
//SC-O(N)
//Key Idea : Maximize active sections by merging adjacent zero blocks separated by a single one block.
public class Maximize_Active_Sec_With_Trade {

    public static int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();

        List<Integer> inactiveBlocks = new ArrayList<>();

        int maxActiveSec = 0;
        int onesCnt =0;

        int i = 0;

        while (i < n) {

            char ch = s.charAt(i);

            if (ch == '0') {
                int start = i;//zero block starting

                while (i < n && s.charAt(i) == '0') {
                    i++;

                }

                inactiveBlocks.add(i - start);

            } else {
                i++;
                onesCnt++;
            }

        }

        for (int j = 0; j < inactiveBlocks.size() - 1; j++) {

            maxActiveSec = Math.max(maxActiveSec, inactiveBlocks.get(j) + inactiveBlocks.get(j + 1));

        }

        return maxActiveSec + onesCnt;

    }

    public static void main(String[] args) {

        System.out.println("Active Section count After Trade : "+maxActiveSectionsAfterTrade("000111110000"));
    }

}

