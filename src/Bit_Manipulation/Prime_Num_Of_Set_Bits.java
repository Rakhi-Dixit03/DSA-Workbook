package Bit_Manipulation;

public class Prime_Num_Of_Set_Bits {

    public static void main(String[] args) {

        System.out.println("Count of Numbers which have prime set bits in the range : "+countPrimeSetBits(6,10));

    }


    public static int  countPrimeSetBits(int left, int right) {

        int count=0;
        for(int i=left;i<=right;i++){

            int setBits = Integer.bitCount(i);

            if(checkPrime(setBits)){
                count++;
            }

        }

        return count;
    }

    public static boolean checkPrime(int num){

        if(num<=1){// 1 is not a prime number
            return false;
        }
        if(num==2 || num==3){
            return true;
        }
        for(int i=2;i<=Math.sqrt(num);i++){

            if(num%i==0){
                return false;

            }
        }
        // If a number has a factor larger than its square root, it must have a corresponding
        // factor smaller than its square root, which is why checking up to (sqrt{n}) is sufficient.

        return true;
    }


}
