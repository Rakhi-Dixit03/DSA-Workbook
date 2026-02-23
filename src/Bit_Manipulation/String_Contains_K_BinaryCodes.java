package Bit_Manipulation;

import java.util.*;
public class String_Contains_K_BinaryCodes {

    public static void main(String[] args) {

        System.out.println("Does String contain all Binary Codes of length k ? "+hasAllCodes("00110110",2));
        System.out.println("Does String contain all Binary Codes of length k ? "+hasAllCodes1("00110110",2));
    }
    public static boolean hasAllCodes(String s, int k) {
        int n=s.length();
        if(n<(1<<k)+k-1){//early termination, not sufficient length
            return false;

        }

        Set<String>set=new HashSet<>();
        int l=0,r=0;

        while(r<n){

            //Shrink if invalid window


            if(r-l+1>k){
                l++;
            }

            if(r-l+1==k){//valid window

                set.add(s.substring(l,r+1));//r+1 because last index is excluded

            }

            r++;

        }

        return (1<<k)==set.size();

    }


    //Cleaner Version
    public static boolean hasAllCodes1(String s, int k) {
        int n=s.length();
        if(n<(1<<k)+k-1){//early termination, not sufficient length
            return false;

        }

        Set<String>set=new HashSet<>();

        for(int i=0;i<=n-k;i++){

            set.add(s.substring(i,i+k));

        }
        return (1<<k)==set.size();
    }

}
