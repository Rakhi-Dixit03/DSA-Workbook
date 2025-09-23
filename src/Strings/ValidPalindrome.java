package Strings;

public class ValidPalindrome {

    public static void main(String[] args) {

        String str="A man, a plan, a canal: Panama";
        System.out.println("Valid Palindrome : "+validPalindrome1(str));
        System.out.println("Valid Palindrome : "+validPalindrome2(str));

    }

    public static boolean validPalindrome1(String s){

        String str=s.toLowerCase();
        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<str.length();i++){

            if(checkChar(str.charAt(i))){

                sb.append(str.charAt(i));

            }

        }

        String original=sb.toString();
        sb=sb.reverse();
        String reverse=sb.toString();


        if(original.equals(reverse))return true;
        return false;


    }

    private  static boolean checkChar(char ch){

        String alphaNumeric="abcdefghijklmnopqrstuvwxyz0123456789";

        if(alphaNumeric.contains(ch+"")){
            return true;
        }

        return false;

    }


    public static boolean validPalindrome2(String s){

        String str=s.toLowerCase();

        int i=0,j=s.length()-1;

        while(i < j ){


            char a=str.charAt(i);
            char b=str.charAt(j);

            // skip non-AlphaNumeric

            if(!((a>='a' && a<='z') || (a>='0' && a<='9'))){
                i++;
                continue;
            }

            if(!((b>='a' && b<='z') || (b>='0' && b<='9'))){
                j--;
                continue;
            }

            if(a!=b)return false;

            j--;
            i++;
        }

        return true;
    }
}
