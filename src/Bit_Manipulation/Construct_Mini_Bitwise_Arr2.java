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
                int x = nums.get(i);
                int res = -1;
                int d = 1;
                while ((x & d) != 0) {
                    res = x - d;
                    d <<= 1;
                }
                result[i] = res;
            }
            return result;
        }
}
