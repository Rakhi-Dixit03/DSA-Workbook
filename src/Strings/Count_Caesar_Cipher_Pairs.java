package Strings;

import  java.util.*;

public class Count_Caesar_Cipher_Pairs {

    public static void main(String[] args) {

        String[] words={"fusion","layout"};
        System.out.println("Number of Caesar Cipher Pairs are : "+countPairs(words));


    }

    public static long countPairs(String[] words) {

        // Map to store normalized word and its frequency
        HashMap<String,Integer>map=new HashMap<>();

        // Process each word
        for(String word: words){

            int shift = word.charAt(0)-'a';

            //Build the normalised word
            StringBuilder sb=new StringBuilder();

            for(char c : word.toCharArray()){

                int val=c-'a';  // convert to number (0–25)

                val=val-shift; //shift backward

                if(val<0){
                    val+=26;
                }

                char newChar=(char)(val+'a');//convert back to character

                sb.append(newChar);

            }

            String normalised=sb.toString();
            map.put(normalised,map.getOrDefault(normalised,0)+1);


        }

        long pairs=0;
        for(int val : map.values()){

            pairs+=(long)val*(val-1)/2;


        }
        return pairs;
    }


}
