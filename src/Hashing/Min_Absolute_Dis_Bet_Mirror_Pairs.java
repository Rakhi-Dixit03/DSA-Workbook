package Hashing;

import java.util.*;

//Using a hash map to store the last seen index of reversed numbers
// to find minimum distance pairs in one pass.
//TC - O(N*D)
//SC - O(N)
public class Min_Absolute_Dis_Bet_Mirror_Pairs {

    public static int reverse(int num){

        int rev=0;

        while(num>0){

            rev=rev*10+(num%10);
            num=num/10;
        }

        return rev;

    }

    public static void main(String[] args) {
        System.out.println("Minimum Absolute Distance Between Mirror Pairs :  "
                +minMirrorPairDistance(new int[]{12,21,45,33,54}));
    }

    public static int minMirrorPairDistance(int[] numbers) {

        int ans=Integer.MAX_VALUE;

        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<numbers.length;i++){

            if(map.containsKey(numbers[i])){
                ans=Math.min(ans,i-map.get(numbers[i]));
            }

            map.put(reverse(numbers[i]),i);

        }

        return ans==Integer.MAX_VALUE?-1:ans;

    }

}
