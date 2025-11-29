package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Sliding_Window_Maximum {

//Maximum of all subArrays of size k

    static class Pair{

        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }


    public static void main(String[] args) {

        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println("Maximum of all subArrays of size "+k+" is : ");
        System.out.println(slidingWinMax(arr,k));

    }

    public static List<Integer> slidingWinMax(int[] arr,int k){

        List<Integer>ans=new ArrayList<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->b.val-a.val);//we have to maintain a max heap
         int n= arr.length;
        //Storing 1st window elements(k elements)

        for(int i=0;i<k;i++){

            pq.add(new Pair(arr[i],i));

        }

        ans.add(pq.peek().val);

       for(int i=k;i<n;i++){

           //checking if element at the top of pq has gone out of window of not

           while(!pq.isEmpty() && pq.peek().idx<=(i-k)){

               pq.remove();
           }

           pq.add(new Pair(arr[i],i));

           ans.add(pq.peek().val);

       }

       return ans;

    }

}
