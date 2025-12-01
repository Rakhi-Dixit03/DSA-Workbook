package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kth_Largest_Ele_in_Stream {
    static PriorityQueue<Integer>pq;

    static int k;


    public static void main(String[] args) {

        k=3;
        pq=new PriorityQueue<>();

        int[] arr={1,2,3,4,5,6};

        System.out.println("All  kth Largest Elements in a stream : ");
        System.out.println(get_kthLargestElements(arr,k));

    }


   //TC-O(NLog(k)),SC-O(K)
    public static List<Integer> get_kthLargestElements(int[] stream, int k){

       List<Integer>ans=new ArrayList<>();

        for(int val:stream ){

            if(pq.size()<k){
                pq.add(val);

            }else {

               if(val>pq.peek()){
                   pq.poll();
                   pq.add(val);

               }

            }

            if(pq.size()>=k){

                ans.add(pq.peek());
            }else{

                ans.add(-1);
            }


        }

        return ans;
    }

}
