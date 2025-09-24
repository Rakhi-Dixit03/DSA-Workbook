package Strings;

import java.util.Stack;

//Remove All Occurrences
public class RemoveOccur {


    public static void main(String[] args) {

        String str="bbbbbabab";
        String part="ab";
        System.out.println("String after removing All Occurrences : "+removeOccur1(str,part));
        System.out.println("String after removing All Occurrences : "+removeOccur2(str,part));
    }


    public static String removeOccur1(String str,String part){

        StringBuilder sb=new StringBuilder(str);


        while(sb.indexOf(part)!=-1){

            int idx=sb.indexOf(part);
            sb.delete(idx,idx+part.length());
        }

        return sb.toString();
    }


    public static String removeOccur2(String str,String part){

        Stack<Character> st=new Stack<>();

        for(char ch: str.toCharArray()){

            st.push(ch);

            if(st.size() >=part.length() && st.peek()==part.charAt(part.length()-1)){

                String temp="";

                 for(int i=0;i<part.length();i++){

                     temp=st.pop()+temp;

                 }

                if(!temp.equals(part)){

                    for(int i=0;i<temp.length();i++){

                        st.push(temp.charAt(i));
                    }

                }

            }

        }

        String ans="";
        while(!st.isEmpty()){
             ans=st.pop()+ans;
        }


       return ans;

    }


}
