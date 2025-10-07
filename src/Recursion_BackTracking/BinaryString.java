package Recursion_BackTracking;

public class BinaryString {

    public static void main(String[] args) {

        binaryString(new StringBuilder(),0,3);
    }


    public static void binaryString(StringBuilder str,int lastPlace,int  n){

        //Base case
        if(n==0){
            System.out.println(str);
            return;
        }

        binaryString(new StringBuilder(str).append("0"),0,n-1);
        if((lastPlace==0 ) || str.isEmpty()){

            binaryString(new StringBuilder(str).append("1"),1,n-1);
        }




    }
}
