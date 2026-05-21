package Hashing;

import java.util.*;

public class Longest_Common_Prefix {

    public static  int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<String> set = new HashSet<>();

        for(int num:arr1){

            String number=String.valueOf(num);

            for(int j=1;j<=number.length();j++){

                set.add(number.substring(0,j));

            }

        }

        int longestPrefix = 0;

        for(int num: arr2){

            String number=String.valueOf(num);

            for(int j=1;j<=number.length();j++){

                String prefix=number.substring(0,j);

                if(set.contains(prefix)){

                    longestPrefix=Math.max(longestPrefix,prefix.length());

                }

            }



        }
        return  longestPrefix;
    }


    public static void main(String[] args) {

        System.out.println("Prefix Common Array is : "
                +longestCommonPrefix(new int[]{1,3232,2,444421},new int[]{323,1,2,4444}));
    }

}
