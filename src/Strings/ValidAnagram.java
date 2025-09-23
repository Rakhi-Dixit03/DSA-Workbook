package Strings;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {

        String str1="earth";
        String str2="thare";
        System.out.println("Valid Anagrams : "+validAnagram(str1,str2));
    }


    public static boolean validAnagram(String str1,String str2){

        if(str1.length() !=str2.length()){
            return false;
        }else{

            char[] str1Arr=str1.toCharArray();
            char[] str2Arr=str2.toCharArray();

            Arrays.sort(str1Arr);
            Arrays.sort(str2Arr);

            if(Arrays.equals(str1Arr,str2Arr)){
                return true;
            }else{
                return false;
            }
        }


    }

}
