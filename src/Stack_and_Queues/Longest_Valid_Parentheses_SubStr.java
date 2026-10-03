package Stack_and_Queues;

public class Longest_Valid_Parentheses_SubStr {

    /*Key Idea: Using a stack to track indices of unmatched parentheses to calculate valid substring lengths.*/

    public int longestValidParentheses(String s) {

        //edge case
        // if(s.isEmpty())return 0;

        java.util.Stack<Integer> st = new java.util.Stack<>();
        int maxLen = 0;

        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                st.push(i);
            } else {//closing parentheses
                st.pop();

                if (st.isEmpty()) {
                    st.push(i);
                } else {

                    maxLen = Math.max(maxLen, i - st.peek());
                }

            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Longest_Valid_Parentheses_SubStr obj = new Longest_Valid_Parentheses_SubStr();

        System.out.println("Longest Valid Parentheses SubString Length : "+obj.longestValidParentheses("((())(())()("));
    }
}
