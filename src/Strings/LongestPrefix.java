package Strings;

public class LongestPrefix {

    public static void main(String[] args) {

        String[] strs={"flower","flow","flight"};
        System.out.println("Longest Common Prefix is : "+longestPrefix(strs));
    }

    public static String longestPrefix(String[] strs){

        java.util.Arrays.sort(strs);
        int n=strs.length-1;
        String a=strs[0];
        String b=strs[n];

        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<Math.min(a.length(), b.length());i++){

            if(a.charAt(i)!=b.charAt(i)){
                return sb.toString();
            }

            sb.append(a.charAt(i));


        }

        return  sb.toString();

    }
}
