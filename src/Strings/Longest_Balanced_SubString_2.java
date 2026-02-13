package Strings;

import java.util.HashMap;
import java.util.Map;


public class Longest_Balanced_SubString_2{

public static void main(String[] args) {

        System.out.println("Length of Longest SubString : "+longestBalanced("aabcc"));

        System.out.println("Testing case 2 method : "+longestBalOfTwoChars('a','b',"aabcc"));
    }


static class Pair{

    int d1;
    int d2;

    public Pair(int diff1,int diff2){
        d1=diff1;
        d2=diff2;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair p)) return false;
        return d1 == p.d1 && d2 == p.d2;
    }

    @Override
    public int hashCode() {
        return 31 * d1 + d2;
    }

}


//O(N) TC and O(N) SC Solution
    //helper method to solve case : 2

    private static int longestBalOfTwoChars(char ch1,char ch2,String s){
        Map<Integer,Integer>map=new HashMap<>();//Map to keep track of the same difference seen before [diff,index]
        map.put(0,-1);//handles the case  if the substring from index 0 to i is already balanced
        int maxL=0;
        int count1=0;
        int count2=0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==ch1){
                count1++;
            }else if(s.charAt(i)==ch2){
                count2++;
            }else{
                //reset counts and map too
                count1=0;
                count2=0;
                map=new HashMap<>();
                map.put(0,i);
                continue;
            }

            int diff=count1-count2;


            if(map.containsKey(diff)){

                maxL=Math.max(maxL,i-map.get(diff));

            }else{
                map.put(diff,i);//storing diff only if not present //we want leftmost index to maximize SubString length
            }



        }

        return maxL;
    }

    public static int longestBalanced(String s) {

        int n=s.length();
        int maxL=0;

        //Case 1 : Contribution to the answer by single char SubString

        int count=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else {
                maxL=Math.max(maxL,count);
                count=1;
            }

        }
        maxL=Math.max(maxL,count);//last subString


        //Case 2 : Contribution to the answer by 2 distinct Chars SubString

        int a_bCharsSubStrL=longestBalOfTwoChars('a','b',s);
        maxL= Math.max(maxL,a_bCharsSubStrL);
        int a_cCharsSubStrL=longestBalOfTwoChars('a','c',s);
        int b_cCharsSubStrL=longestBalOfTwoChars('b','c',s);

        maxL=Math.max(maxL,Math.max(a_cCharsSubStrL,b_cCharsSubStrL));


        //Case 3 : Contribution of 3 distinct chars Substring to our answer

        Map<Pair,Integer>map=new HashMap<>();
        map.put(new Pair(0,0),-1);
        int count1=0;//for a
        int count2=0;//for b
        int count3=0;//for c

        for(int i=0;i<n;i++){

            if(s.charAt(i)=='a'){
                count1++;
            }else if(s.charAt(i)=='b'){
                count2++;
            }else{
                count3++;
            }

            int diff1=count1-count2;//diff of a and b [a-b]
            int diff2=count1-count3;//diff of a and c [a-c]


            Pair currPair = new Pair(diff1,diff2);

            if(map.containsKey(currPair)){

                maxL=Math.max(maxL,i-map.get(currPair));

            }else{
                map.put(currPair,i);
            }

        }

        return maxL;

    }
}


