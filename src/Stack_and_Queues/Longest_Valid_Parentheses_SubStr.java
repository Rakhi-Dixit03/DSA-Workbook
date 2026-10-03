package Stack_and_Queues;

public class Longest_Valid_Parentheses_SubStr {

    /*Key Idea: Using a stack to track indices of unmatched parentheses to calculate valid substring lengths.*/
    //TC -O(N) SC-O(N)
    public int longestValidParentheses1(String s) {

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

    //TC-O(N) SC-O(1)

    public int longestValidParentheses2(String s) {

        int openCnt = 0;
        int closeCnt = 0;
        int maxLen = 0;

        //Left to Right
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                openCnt++;
            } else {
                closeCnt++;

            }

            if (closeCnt == openCnt) {

                maxLen = Math.max(maxLen, openCnt + closeCnt);

            }

            if (closeCnt > openCnt) {//Reset when closing Parentheses causes invalidity
                openCnt = 0;
                closeCnt = 0;
            }

        }

        openCnt = 0;
        closeCnt = 0;
        //Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openCnt++;
            } else {
                closeCnt++;

            }

            if (closeCnt == openCnt) {

                maxLen = Math.max(maxLen, openCnt + closeCnt);

            }

            if (openCnt > closeCnt) {//Reset when '(' causes invalidity
                openCnt = 0;
                closeCnt = 0;
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Longest_Valid_Parentheses_SubStr obj = new Longest_Valid_Parentheses_SubStr();

        System.out.println("Longest Valid Parentheses SubString Length : "+obj.longestValidParentheses1("((())(())()("));
        System.out.println("Longest Valid Parentheses SubString Length : "+obj.longestValidParentheses2("((())(())("));
    }
}
