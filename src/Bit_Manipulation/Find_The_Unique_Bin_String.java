package Bit_Manipulation;

import java.util.*;
public class Find_The_Unique_Bin_String {

    public static void main(String[] args) {

        String[] arr={"10","11"};
        System.out.println("Unique Binary String : "+findDifferentBinaryString(arr));
        System.out.println("Unique Binary String : "+findDifferentBinaryString1(arr));

    }

    public static String findDifferentBinaryString(String[] nums) {

        int n=nums.length;
        Set<Integer>set=new HashSet<>();

        for (String num : nums) {//O(N^2)

            set.add(Integer.parseInt(num, 2));//parseInt() method takes O(N) time

        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=n;i++){

            if(!set.contains(i)){

                String ans=Integer.toBinaryString(i);//O(Log(N))
                sb= new StringBuilder(ans);

                while(sb.length()<n){//as we want the answer string length=n
                    sb.insert(0, '0');

                }
            }
        }

        return sb.toString();
    }

    public static String findDifferentBinaryString1(String[] nums) {

        int n=nums.length;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){

            char ch=nums[i].charAt(i);

            sb.append(ch=='1'?'0':'1');

        }

        return sb.toString();

    }

}
