package Strings;

public class Rotate_String {

   // TC- O(N)
    public static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        s = s + s;

        return s.contains(goal);//can also use indexOf() method to check presence of a string in another
    }


    //Brute Force

    // for (int i = 0; i < s.length(); i++) {

    //     if (newStr.substring(i, i + n).equals(goal)) {
    //         return true;
    //     }

    // }


    public static void main(String[] args) {

        System.out.println("Can [s] become equal to [goal] after rotation ? : "+rotateString("bbbacddceeb","ceebbbbacdd"));
    }
}
