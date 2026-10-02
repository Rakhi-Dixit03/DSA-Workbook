package Recursion_BackTracking;

import java.util.*;

public class Generate_Parentheses {

    List<String> list = new ArrayList<>();
    int m;

    public List<String> generateParenthesis(int n) {
        m = 2 * n;
        solve(new StringBuilder(), n, n);
        return list;

    }


    void solve(StringBuilder sb, int openCnt, int closeCnt) {

        if (sb.length() == m) {
            list.add(sb.toString());
            return;
        }

        //openCnt  - Opening parentheses still available
        //closeCnt - Closing parentheses still available

        if (openCnt > 0) {

            solve(sb.append("("), openCnt - 1, closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCnt > openCnt) {

            solve(sb.append(")"), openCnt, closeCnt - 1);
            sb.deleteCharAt(sb.length() - 1);

        }

    }

    public static void main(String[] args) {

        Generate_Parentheses obj = new Generate_Parentheses();

        System.out.println("Answer : "+(obj.generateParenthesis(3)).toString());
    }
}

