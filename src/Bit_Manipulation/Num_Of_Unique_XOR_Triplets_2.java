package Bit_Manipulation;

public class Num_Of_Unique_XOR_Triplets_2 {


   static int uniqueXorTriplets(int[] numbers) {

        int n=numbers.length;

        //find Max element
        int max = java.util.Arrays.stream(numbers).max().orElseThrow(()-> new IllegalArgumentException("Array is Empty!"));

        //find nearest 2's power value which is greater than maxVal

        int powerVal=1;

        while(powerVal<=max){

            powerVal<<=1;//= powerVal*2

        }

        boolean[] s1 = new boolean[powerVal];
        boolean[] s2 = new boolean[powerVal];

        //Pairwise XOR
        //TC-O(N*N)

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int pairXor=numbers[i]^numbers[j];

                if(!s1[pairXor]){
                    s1[pairXor]=true;
                }

            }
        }


        //Take XOR of each element in numbers with pairXORs in s1
        //TC - O(powerVal*n)

        for(int i=0;i<s1.length;i++){
            if(!s1[i])continue;

            for (int num : numbers) {

                int tripleXor = i ^ num;

                if (!s2[tripleXor]) {
                    s2[tripleXor] = true;
                }
            }
        }


        //Count Unique XORs from s2

        int count=0;
        for (boolean b : s2) {

            if (b) count++;

        }

        return count;
    }


    public static void main(String[] args) {
        int[] numbers = {1,3,2,4};
        System.out.println("Number of Unique XOR Triples : "+uniqueXorTriplets(numbers));
    }


}
