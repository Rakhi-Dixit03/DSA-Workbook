package Greedy;

import java.util.PriorityQueue;

public class Maximize_Happiness {

    public static void main(String[] args) {

        int[] happiness={1,2,3};
        System.out.println("Maximum sum of the happiness values that we can achieve by selecting k children :  "+maximumHappinessSum(happiness,2));

        System.out.println("Maximum sum of the happiness values that we can achieve by selecting k children :  "+maximumHappinessSum2(new int[]{2,3,4,5},1));

    }

    //O(kLogN)
    public static long maximumHappinessSum(int[] happiness, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);//Max-Heap

        for(int h: happiness){
            pq.add(h);
        }

        long sumOfHappiness=0;

        for(int i=0 ;i<k;i++){

            int curr = pq.poll();
            int actualVal=Math.max(curr-i,0);
            sumOfHappiness+=actualVal;

        }

        return sumOfHappiness;

    }

    public static long maximumHappinessSum2(int[] happiness, int k) {

        java.util.Arrays.sort(happiness);//it will be in ascending order
        int n=happiness.length;

        long sumOfHappiness=0;
        int turn=0;
        for(int i=n-1;i>=0;i--){

            int actualVal=Math.max(happiness[i]-turn,0);
            sumOfHappiness+=actualVal;
            turn++;
            if(turn==k){
                break;
            }

        }

        return sumOfHappiness;

    }

}
