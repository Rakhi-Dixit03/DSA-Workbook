package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partition {

    public static void main(String[] args) {
        String str="aab";
        List<String> curr=new ArrayList<>();
        List<List<String>>ans=new ArrayList<>();
        palindromePartition(str,0,curr,ans);
        System.out.println("All the possible palindromic partitions are :   "+ans.toString());
    }

    public static void palindromePartition(String s,int idx,List<String> curr, List<List<String>> ans){
        //Base Case
        int n=s.length();
        if(idx==n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<n;i++){
            String str=s.substring(idx,i+1);

            if(isPalindrome(str)) {

                curr.add(str);

                palindromePartition(s, i + 1, curr, ans);
                //BackTrack
                curr.remove(curr.size() - 1);
            }

        }

    }

    public static boolean isPalindrome(String str){

        int l=0;
        int r=str.length()-1;

        while(l<r){

            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;

        }

        return true;
    }

}
