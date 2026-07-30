package Greedy;

public class Min_Num_Of_Pushes_To_Type_The_Word_1 {

    //TC - O(1) Problem Number - 3014
    public static int minimumPushes(String word) {
        int len = word.length();

        if (len <= 8) {
            return len;
        } else if ( len <= 16) {

            return 8 + (len - 8) * 2;

        } else if (len <= 24) {

            return 24 + (len - 16) * 3;

        } else {

            return 48 + (len - 24) * 4;
        }

    }

    static void reverse(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

        }

    }

    //TC -O(N) //Problem Number 3016
    public static int minimumPushes2(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {//O(N)
            freq[ch - 'a']++;
        }

        java.util.Arrays.sort(freq);//O(26*Log(26))
        reverse(freq);//to sort in descending order

        int minPushes = 0;

        for (int i = 0; i < 26; i++) {

            minPushes += ((i / 8) + 1) * freq[i];

        }

        return minPushes;
    }

    public static void main(String[] args) {
        System.out.println("Minimum Number of Pushes Required to Type the word : "+minimumPushes("abdhger"));
        System.out.println("Minimum Number of Pushes Required to Type the word : "+minimumPushes2("abdhger"));
    }


}
