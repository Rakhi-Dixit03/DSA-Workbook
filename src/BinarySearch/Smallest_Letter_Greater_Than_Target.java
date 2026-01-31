package BinarySearch;

public class Smallest_Letter_Greater_Than_Target {

    public static void main(String[] args) {
        System.out.println("Smallest Letter Greater than Target : "+nextGreatestLetter(new char[]{'a','c','c','d'},'c'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {

        //UpperBound  because we have to return the character which is greater than target > strictly Greater

        int l = 0, h = letters.length - 1;
        char ans = letters[0];

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (letters[mid] > target) {
                ans = letters[mid];
                h = mid-1;
            } else {
                l = mid + 1;
            }

        }

        return ans;

    }

}
