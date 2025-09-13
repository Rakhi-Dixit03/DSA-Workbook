package Arrays;

//Longest SubString without Repeating Characters

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        String  s= "abcdefg";
        System.out.println("Length of Longest Substring without repeating characters is : "+ longSubstring(s));
        System.out.println("Length of Longest Substring without repeating characters is 2nd Approach  : "+ longSubstring1(s));
    }


    public static int longSubstring(String s){

        boolean[] window=new boolean[128];//Covering all ASCII Characters
        int l=0,r=0,maxLen=0;
        int n=s.length();

        while(r<n){

            if(!window[s.charAt(r)]){
                //When not a Duplicate element

                window[s.charAt(r)]=true;
                maxLen=Math.max(maxLen,r-l+1);
                r++;

            }else{
              //Duplicate occurs
                window[s.charAt(l)]=false;
                l++;
            }
        }

        return maxLen;
    }

    //Using HashSet
    public static int longSubstring1(String s){

        Set<Character> set=new HashSet<>();//Covering all ASCII Characters
        int l=0,r=0,maxLen=0;
        int n=s.length();

        while(r<n){

            if(!set.contains(s.charAt(r))){
                //When not a Duplicate element

                set.add(s.charAt(r));
                maxLen=Math.max(maxLen,r-l+1);
                r++;

            }else{
                //Duplicate occurs
                set.remove(s.charAt(l));
                l++;
            }
        }

        return maxLen;
    }



}
