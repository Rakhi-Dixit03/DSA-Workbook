package Bit_Manipulation;

public class Find_Kth_Bit_In_Nth_Binary_String {

    public static void main(String[] args) {

        System.out.println("Kth Bit in Nth Binary String is : "+findKthBit(4,4));
        System.out.println("Kth Bit in Nth Binary String is : "+findKthBit1(4,4));
    }

   //TC-(2^N) where N can be from 1 to 20 [1048576]

    public  static char findKthBit(int n, int k) {

        StringBuilder sb=getNthStr(n);//this will return nth BINARY STRING
        char ch='@';

        for(int i=0;i<sb.length();i++){//finding kth bit in that string

            if(i==k-1){

                ch =sb.charAt(i);
            }

        }
        return ch;
    }

    private static StringBuilder getNthStr(int n){

        //Base Case

        if(n==1){
            return new StringBuilder("0");
        }

        StringBuilder sb=getNthStr(n-1);//Recursive Call
        StringBuilder inv=invert(sb);

        return new StringBuilder(sb.append("1").append(inv.reverse()));


    }

    private static StringBuilder invert(StringBuilder s){

        StringBuilder invert=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                invert.append("1");
            }else{
                invert.append("0");
            }
        }

        return invert;
    }

    //TC-O(N) by observing the structure of the resultant string
    public static char findKthBit1(int n, int k) {

        boolean flip = false;

        while (k > 1) {
            if ((k & (k - 1)) == 0) {   // power of 2 (middle)
                return flip ? '0' : '1';
            }

            int len = (1 << n) - 1;//2^n -1
            int mid = (len + 1) / 2;//mid will be 2^(n-1)

            if (k > mid) {
                k = len + 1 - k;   // mirror Step
                flip = !flip;      // invert
            }

            n--;
        }

        return flip ? '1' : '0';
    }


}
