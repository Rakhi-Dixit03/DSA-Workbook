package Bit_Manipulation;

//Leet-Code 1611
//Min Bit operations required to make integer zero

public class Minimum_Ops_To_make_Int_Zero {

    public static void main(String[] args) {

        System.out.println("Operations required to make n Zero : "+minimumOneBitOperations(7));

    }


    public static int minimumOneBitOperations(int n) {

        if(n==0)return 0;

        long[] F=new long[31];//Holding operations required to make a number with having set bet at ith position to zero

        F[0]=1; //only one operation converting  1 to 0
        for(int i=1;i<=30;i++){

            F[i]=2L*F[i-1]+1;

        }

        int sign=1;
        int result=0;

        //Going left(MSB) to right(LSB) to minimise number of operations
        for(int i=30;i>=0;i--){

            int i_thBit=(1<<i)&n;

            if(i_thBit==0)continue;

            if(sign>0){//+ve

                result+=(int)F[i];

            }else{

                result-= (int) F[i];
            }

            sign=sign*(-1);
        }

        return result;
    }


}
