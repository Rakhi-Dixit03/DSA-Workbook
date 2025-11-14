package BinarySearch_Tree;

import java.util.Comparator;
import java.util.PriorityQueue;

//LeetCode 703
//Kth Largest element in the stream
public class kth_Largest_InBST {


    public static void main(String[] args) {

       KthLargest obj=new KthLargest(3,new int[]{4,5,8,2});

        System.out.println("Kth Largest element is : "+obj.add(3));
        System.out.println("Kth Largest element is : "+obj.add(5));
        System.out.println("Kth Largest element is : "+obj.add(8));


    }


}


class KthLargest {

    PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.comparingInt(a -> a));
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0;i<nums.length;i++){

            pq.add(nums[i]);

            if(pq.size()>k){

                pq.poll();
            }


        }

    }

    public int add(int val) {
        pq.add(val);

        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();

    }
}
