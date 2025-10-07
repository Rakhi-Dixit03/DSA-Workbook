package Recursion_BackTracking;

//Count of substring starting and ending at same index
public class Substrings {

    public static void main(String[] args) {
        String s="aba";

        System.out.println("Answer is : "+countSubstring1("abcba",'a'));
        System.out.println("Answer is : "+countSubstring2("aba"));
        System.out.println("Answer is : "+subStringCount(s,0,s.length()-1,s.length()));


    }

    public static long countSubstring1(String s,char c) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }

        }

        return (long) count * (count + 1) / 2;

    }

    public static long countSubstring2(String s){
        int[] map=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map[ch-'a']++;

        }
        long tot=0;

        for(int i=0;i<map.length;i++){

            tot+=(map[i]*(map[i]+1)/2);


        }


        return tot;
    }

    //Recursive approach
    public static long subStringCount(String s,int i,int j,int n){

        //Base Cases

        if(n==1)return 1;
        if(n<=0)return 0;
        //Inclusion-Exclusion approach

        long res=subStringCount(s,i,j-1,n-1)+subStringCount(s,i+1,j,n-1)-subStringCount(s,i+1,j-1,n-2);

        if(s.charAt(i)==s.charAt(j))res++;

        return res;

    }



}
