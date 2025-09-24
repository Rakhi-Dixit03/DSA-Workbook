package Strings;

import java.util.Collections;
import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {

        String str=" The sky   is blue  ";
        System.out.println("After reversal : "+reverseWords1(str));
        System.out.println("After reversal : "+reverseWords2(str));
        System.out.println("After reversal : "+reverseWords3(str));
        System.out.println("After reversal : "+reverseWords4(str));
    }


    public static String reverseWords1(String s){

        Stack<String> st=new Stack<>();
        String[] arr=s.trim().split("\\s+");

        StringBuilder sb=new StringBuilder("");

        for(String str: arr){
            st.push(str);
        }

        while(!st.isEmpty()){

            if(sb.length()>0){

                sb.append(" ");
            }
            sb.append(st.pop());
        }
        return sb.toString();

    }


    public static String reverseWords2(String s) {

        Stack<String> st=new Stack<>();
        s=s.trim();
        StringBuilder word=new StringBuilder("");
        StringBuilder res=new StringBuilder("");

        for(char ch : s.toCharArray()){

            if(ch==' '){

                if(word.length()>0){
                    st.push(word.toString());
                    word.setLength(0);
                }

            }else{

                word.append(ch);
            }

        }

        // push last word
        if (word.length() > 0) {
            st.push(word.toString());
        }


        while(!st.isEmpty()){
            res.append(st.pop());

            if(!st.isEmpty()){
                res.append(" ");
            }


        }

        return res.toString();

    }



    public static String reverseWords3(String s){

        s=s.trim();
        String word="";
        String ans="";

        for(char ch : s.toCharArray()){

            if(ch!=' '){

                word+=ch;

            }else if(ch==' '){

                if(!word.equals("")){

                    if(!(ans.equals(""))){

                        ans=word+" "+ans;


                    }else{
                        ans=word;
                    }
                }
                word="";
            }

        }

        // add last word

        if(!word.equals("")){

            if(!ans.equals("")){

                ans=word+" "+ans;

            }else{
                ans=word;
            }

        }

        return ans;


    }


    public static String reverseWords4(String s){

        String[] arr = s.trim().split("\\s+");
        Collections.reverse(java.util.Arrays.asList(arr));
        return String.join(" ", arr);



    }

}
