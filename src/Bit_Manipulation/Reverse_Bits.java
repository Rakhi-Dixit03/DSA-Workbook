package Bit_Manipulation;

public class Reverse_Bits {

    public static void main(String[] args) {
        System.out.println("After Reversing the bits of 32 Bit signed Integer : "+reverseBits(50));
    }
    public static int reverseBits(int n) {

        int res=0;

        for(int i=0;i<32;i++){
            res=(res<<1) | (n&1);//left shift to make space for the next bit n&1 is for extracting bit
            n>>>=1;//right shift to move to next bit shortening the number , using it Left side fills with `0`

//            💡 Simple Mental Model

//             * `>>` = “keep the sign”
//             * `>>>` = “just move bits”

        }

        return res;
    }


}
