package Bit_Manipulation;

public class Binary_Num_With_Alternating_Bits {

    public static void main(String[] args) {

        Binary_Num_With_Alternating_Bits obj=new Binary_Num_With_Alternating_Bits();

        System.out.println("Does N have Alternating Bits ? : "+obj.hasAlternatingBits1(5));
        System.out.println("Does N have Alternating Bits ?: "+obj.hasAlternatingBits2(8));
        System.out.println("Does N have Alternating Bits ? : "+obj.hasAlternatingBits3(21));
    }
    public boolean hasAlternatingBits1(int n) {

        String binStr=Integer.toBinaryString(n);

        for(int i=1;i<binStr.length();i++){

            if(binStr.charAt(i)==binStr.charAt(i-1)){//Comparing bits as characters
                return false;
            }

        }
        return true;

    }


    public boolean hasAlternatingBits2(int n) {
        if(n==1){
            return true;
        }
        int currBit=n&1;
        int lastBit=currBit;
        n>>=1;
        while(n>0){

            currBit=n&1;
            if(lastBit==currBit){
                return false;
            }
            lastBit=currBit;
            n>>=1;

        }
        return true;

    }

    public boolean hasAlternatingBits3(int n) {
        if(n==1){
            return true;
        }

        String binStr=Integer.toBinaryString(n);

        for(int i=0;i<binStr.length()-1;i++){

            if(((int)binStr.charAt(i)^(int)binStr.charAt(i+1))==0){//using XOR Operator
                return false;
            }

        }

        return true;
    }

}
