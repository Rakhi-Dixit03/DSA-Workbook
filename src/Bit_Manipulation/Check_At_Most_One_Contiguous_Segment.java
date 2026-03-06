package Bit_Manipulation;

public class Check_At_Most_One_Contiguous_Segment {

    //Problem number : 1784
    public static void main(String[] args) {

        System.out.println("Does String contain only one segment of ones ? "+checkOnesSegment("11110000"));
    }

    public static boolean checkOnesSegment(String s) {
        //Detecting pattern transitions in a string to verify contiguous segments.

        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {//can use String.contains() method too
                return false;

            }

        }
        return true;
    }

}
