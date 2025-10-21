package Stack_and_Queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parenthesis {

    public static void main(String[] args) {

        String str="{}()[]";
        String str2="[]{(}]";

        System.out.println("Valid Parenthesis : "+isValid(str));
        System.out.println("Valid Parenthesis : "+isValid(str2));


    }

    public static boolean isValid(String s) {

        java.util.Stack<Character>st=new Stack<>();
        Map<Character,Character> map=new HashMap<>();

        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);

            if(ch=='{' || ch=='(' || ch=='['){
                st.push(ch);
                continue;
            }

            if(ch=='}' || ch==')' || ch==']')

                if(!st.isEmpty() && map.get(ch)==st.peek()){
                    st.pop();

                }else{
                    return false;
                }

        }

        return st.isEmpty();

    }


}
