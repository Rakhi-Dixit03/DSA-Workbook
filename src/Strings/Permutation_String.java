package Strings;

import java.util.HashMap;

public class Permutation_String {

    public static void main(String[] args) {

        String s1="ab";
        String s2="eidbaooo";
        System.out.println("Permutation in a String : "+permutationString(s1,s2));



    }

    public static boolean permutationString(String s1,String s2){

//        boolean flag=false;
        int m=s1.length();
        int n=s2.length();

        if(n<m)return false;

        HashMap<Character,Integer> countS1=new HashMap<>();

        //Frequencies of chars in s1

        for(char ch:s1.toCharArray()){

            countS1.put(ch,countS1.getOrDefault(ch,0)+1);
        }

        //Map to Store freq of chars in window
        HashMap<Character,Integer>wind=new HashMap<>();


        //Maintaining a window of size =s1

        int l=0,r=0;

        while(r<s2.length()){

            //Expand window by adding char at r from s2 string
            wind.put(s2.charAt(r),wind.getOrDefault(s2.charAt(r),0)+1);


            //if window size exceeds shrink it
            if((r-l+1)>s1.length()){

                wind.put(s2.charAt(l),wind.get(s2.charAt(l))-1);

                if(wind.get(s2.charAt(l))==0){
                    wind.remove(s2.charAt(l));
                }

                l++;
            }


           //  int count=0;
            if((r-l+1)==s1.length()){

                if(countS1.equals(wind))return true;

                //This will work but takes more time

                // for(int i=0;i<s1.length();i++){

                //    if(countS1.get(s1.charAt(i))==wind.getOrDefault(s1.charAt(i),0)){
                //        count++;
                //    }

                // }
                // if(count==s1.length()){

                //     flag=true;
                //     return true;

            }
            r++;

        }
        // return false;
        return false;

    }

}
