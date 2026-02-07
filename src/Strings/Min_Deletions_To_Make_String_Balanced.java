package Strings;

import java.util.Stack;

public class Min_Deletions_To_Make_String_Balanced {

    public static void main(String[] args) {
        System.out.println("Minimum Deletions to make String Balanced : "+minimumDeletions1("bababababa"));
    }


    public static int minimumDeletions1(String s) {

        int n=s.length();
        int[] bCount=new int[n];
        int[] aCount=new int[n];

        for(int i=1;i<n;i++){
            if(s.charAt(i-1)=='b'){
                bCount[i]=bCount[i-1]+1;
            }else{
                bCount[i]=bCount[i-1];
            }
        }

        for(int i=n-2;i>=0;i--){
            if(s.charAt(i+1)=='a'){
                aCount[i]=aCount[i+1]+1;
            }else{
                aCount[i]=aCount[i+1];
            }
        }

        int minDel=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            int del=bCount[i]+aCount[i];
            minDel=Math.min(minDel,del);

        }
        return minDel;

    }

//Instead of using Arrays for keeping a and b Counts used 2 variables
    public static int minimumDeletions2(String s) {

        int n = s.length();
        int bCount = 0;
        int aCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        int minDel = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == 'a') {
                aCount--;
            }

            if (i > 0 && s.charAt(i - 1) == 'b') {
                bCount++;
            }

            int del = bCount + aCount;
            minDel = Math.min(minDel, del);

        }
        return minDel;

    }

    //Using Stack
    public static int minimumDeletions3(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();

        int minDel = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == 'a') {
                if (!st.isEmpty() && st.peek() == 'b') {
                    st.pop();
                    minDel++;
                    continue;
                }
            }

            st.push(s.charAt(i));

        }
        return minDel;

    }
//1 Pass Solution
    public static int minimumDeletions4(String s) {

        int n = s.length();


        int minDel = 0;
        int bCount=0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == 'b') {
                bCount++;
            }else{
                minDel=Math.min(minDel+1,bCount);
            }

        }
        return minDel;

    }
}
