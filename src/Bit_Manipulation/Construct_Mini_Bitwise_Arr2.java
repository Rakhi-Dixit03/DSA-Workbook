package Bit_Manipulation;

import java.util.*;

public class Construct_Mini_Bitwise_Arr2 {

       public static void main(String[] args){

           List<Integer>arr=new ArrayList<>();
           arr.add(2);
           arr.add(3);
           arr.add(5);
           arr.add(7);
           System.out.println("Minimum Bitwise array  : "+Arrays.toString(minBitwiseArray(arr)));

       }

    public static int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            int num=nums.get(i);

            if(num==2){

                result[i]=-1;
                continue;

            }

            int ans;
            //we are going till 31 because this much of bits are sufficient to represent a number up-to 10^9
            for(int j=1;j<32;j++){

                if((num&(1<<j))>0){

                    continue;

                }

                //Replace with 0

                ans=num^(1<<(j-1));
                result[i]=ans;
                break;

            }


        }
        return result;
    }



}
