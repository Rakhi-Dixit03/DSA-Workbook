package Strings;

import java.util.ArrayList;
import java.util.List;

public class KMP_Algo {

    public static void main(String[] args) {

        String txt="ABABABABD";
        String pat="ABABD";
        System.out.println("Indices of matching pattern found in  string txt : "+kmpAlgo(txt,pat));
    }


    public static List<Integer> kmpAlgo(String s, String pat){

        int n=pat.length();

        int[] lps=new int[n];

        lps[0]=0;
        int length=0;
        int i=1;

        while(i<n){

            if(s.charAt(i)==s.charAt(length)){
                length++;
                lps[i]=length;
                i++;

            }else{
                if(length!=0){

                    length=lps[length-1];
                }else{

                    lps[i]=0;
                    i++;

                }

            }

        }

       List<Integer>list=new ArrayList<>();
        int j=0;
        int k=0;

        while(j<s.length()){

            if(pat.charAt(k)==s.charAt(j)){

                j++;
                k++;

            }

            if(k==pat.length()){
                list.add(j-k);

               k=lps[k-1];

            }else if(pat.charAt(k)!=s.charAt(j)){

                if(k!=0){

                    k=lps[k-1];

                }else{
                    j++;
                }
            }
        }
        return list;

    }
}
