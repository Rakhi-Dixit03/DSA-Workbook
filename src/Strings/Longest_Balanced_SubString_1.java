package Strings;

public class Longest_Balanced_SubString_1 {

    public static void main(String[] args) {

        System.out.println("Length of Longest Balanced SubString : "+longestBalanced("abbaccd"));
    }


    private static boolean isBalanced(int[] freq){

        int commonCount=-1;
        for(int i=0;i<26;i++){
            if(freq[i]==0)continue;

            if(commonCount == -1){
                commonCount=freq[i];
            }

            if(freq[i] != commonCount){
                return false;
            }

        }

        return true;
    }

    public static int longestBalanced(String s) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                int charIdx = s.charAt(j) - 'a';
                freq[charIdx]++;

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

            }
        }
        return maxLen;
    }
}

