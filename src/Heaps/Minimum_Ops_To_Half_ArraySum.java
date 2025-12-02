package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Ops_To_Half_ArraySum {


    public static void main(String[] args) {

        int[] nums={5,19,8,1};//output=3
        System.out.println("Minimum Operations to half Array Sum : "+halveArray(nums));

    }


    public static int halveArray(int[] nums) {

        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());

        double half = 0;

        for (int num : nums) {
            half += num;
            pq.add((double)num);

        }
        half/=2;
        int ops = 0;

        while (half>0) {

            double curr = pq.poll();

            curr/=2;

            half-=curr;

            pq.add(curr);
            ops++;

        }

        return ops;
    }



}
