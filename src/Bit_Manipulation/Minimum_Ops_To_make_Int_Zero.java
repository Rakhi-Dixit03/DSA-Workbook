package Bit_Manipulation;

//Leet-Code 1611
//Min Bit operations required to make integer zero

import java.util.List;

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



    //2nd Question Easy one [Count Operations to obtain zero]

    public static int countOperations(int num1, int num2) {

        int numOps = 0;

        //Euclidean Algorithm

        while(num1!=0 && num2!=0){

            numOps+=num1/num2;

            num1%=num2;

            //Swap numbers

            num1=num1^num2;
            num2=num1^num2;
            num1=num1^num2;

        }
        return numOps;
    }

    public static class Construct_Min_Bitwise_Arr1 {

        public int[] minBitwiseArray(List<Integer> nums) {
            int[] result = new int[nums.size()];
            for (int i = 0; i < nums.size(); i++) {
                int original = nums.get(i);
                int candidate = -1;
                for (int j = 1; j < original; j++) {
                    if ((j | (j + 1)) == original) {
                        candidate = j;
                        break;
                    }
                }
                result[i] = candidate;
            }
            return result;
        }

    }
}
