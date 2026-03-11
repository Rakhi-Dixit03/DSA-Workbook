package Bit_Manipulation;

public class Complement_Base_10_Integer {

    public static void main(String[] args) {
        System.out.println("Complement of 10 Base Integer is : "+bitwiseComplement(10));
    }
    public static int bitwiseComplement(int n) {

        if(n==0){
            return 1;
        }else if(n==1){
            return 0;
        }

        int comp=0;
        int pow=0;

        String binStr=Integer.toBinaryString(n);

        for(int i=binStr.length()-1;i>=0;i--){

            if(binStr.charAt(i)=='0'){
                comp+=(int)(Math.pow(2,pow));
            }
            pow++;
        }

        return comp;
    }



}
