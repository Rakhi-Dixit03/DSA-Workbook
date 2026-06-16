package Strings;

// TC-O(2^N)
//Simulating string operations including append, delete, duplicate, and reverse using a mutable buffer.

public class Process_String_With_Special_Ops_1 {

    public static String processStr(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '*') {

                if (!result.isEmpty()) {
                    //Remove last character
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {

                result.append(result);

            } else if (ch == '%') {

                result.reverse();

            } else {
                result.append(ch);
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("Processed String is : "+processStr("a#b%*"));

    }

}
