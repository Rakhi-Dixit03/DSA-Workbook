package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Arrays {

    public static void main(String[] args) {

        int[][] arrays={{2,4,5},{},{3,7},{0,1,8,10}};

        System.out.println("Merged List after merging k sorted Arrays : "+mergeKSortedArr(arrays));


    }


   static class Node{

        int val;//element of the array
        int arrIdx;//array index
        int eleIdx;//element index in the array


       public Node(int val, int arrIdx, int eleIdx) {
           this.val = val;
           this.arrIdx = arrIdx;
           this.eleIdx = eleIdx;
       }

   }

   public static List<Integer> mergeKSortedArr(int[][] arrays){

       PriorityQueue<Node>pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

       //putting first element of each array in heap

       for(int i=0;i< arrays.length;i++){

           if(arrays[i].length>0){//check for empty array

               pq.add(new Node(arrays[i][0],i,0));


           }

       }

      //Answer List
       List<Integer>ans=new ArrayList<>();

       //process heap until empty
       while(!pq.isEmpty()){

           Node smallest=pq.poll();

           ans.add(smallest.val);

           int nextIdx= smallest.eleIdx+1;

           //inserting next element of same array

           if(nextIdx<arrays[smallest.arrIdx].length){

               pq.add(new Node(arrays[smallest.arrIdx][nextIdx], smallest.arrIdx, nextIdx));


           }

       }
       return ans;
   }

}
