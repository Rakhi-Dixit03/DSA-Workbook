package Two_Pointer;

public class Valid_Parentheses {
    //TC - O(N)
    // SC - O(1)
    public boolean checkValidString(String s) {

        int count = 0;
        int stars = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;

            } else if (ch == ')') {
                count--;
            } else {
                stars++;
            }

            if (count < 0 && stars < Math.abs(count)) {
                return false;
            }

        }

        count = 0;
        stars = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;

            } else if (ch == ')') {
                count--;
            } else {
                stars++;
            }

            if (count > 0 && stars < Math.abs(count)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        Valid_Parentheses obj = new Valid_Parentheses();
        System.out.println("Is it a valid Parentheses String :  "+obj.checkValidString("(*)(*"));

    }



}
