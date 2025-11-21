package Strings;

import java.util.HashSet;
import java.util.Set;

public class Count_Palindromic_SubSeq {


    public static void main(String[] args) {

        String str="aabca";

        System.out.println("Number of Unique length-3 Palindromic Subsequences : "+countPalindromicSubsequence(str));


    }


    public static int countPalindromicSubsequence(String s) {

        int[][] indices=new int[26][2];
        for(int[] row:indices ){

            java.util.Arrays.fill(row,-1);
        }

        int result=0;

        //PreComputation of leftMost and rightMost indices of each character
        for(int i=0;i<s.length();i++ ){

            char ch=s.charAt(i);
            int idx=ch-'a';

            if(indices[idx][0]==-1){

                indices[idx][0]=i;

            }

            indices[idx][1]=i;

        }



        for(int i=0;i<26;i++){

            int leftIdx=indices[i][0];
            int rightIdx=indices[i][1];


            if(leftIdx==-1)continue;//we have no such character corresponding to that index


            Set<Character> set=new HashSet<>();

            for(int middle=leftIdx+1;middle<rightIdx;middle++){

                set.add(s.charAt(middle));


            }

            result+=set.size();

        }

        return result;

    }


}
