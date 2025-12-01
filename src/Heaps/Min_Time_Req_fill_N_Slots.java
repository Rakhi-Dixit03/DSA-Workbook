package Heaps;

import java.util.LinkedList;
import java.util.Queue;

public class Min_Time_Req_fill_N_Slots {

    public static void main(String[] args) {

        int[] arr={2,6};

        System.out.println("Minimum Time required to fill N slots is : "+minTimeReq(arr,6,2));

    }

    public static int minTimeReq(int[] arr,int n,int k){

       //Level Order Traversal Approach
        boolean[] vis=new boolean[n+1];//to keep track of visited indices

       Queue<Integer> q=new LinkedList<>();

       int time=0;

        for (int val : arr) {

            q.add(val);
            vis[val] = true;
        }



       while(!q.isEmpty()){

           int size=q.size();

           for(int i=0;i<size;i++) {//processing level by level

               int curr = q.poll();

               if (curr - 1 >= 1 && !vis[curr - 1]) {

                   //mark it as visited
                   vis[curr - 1] = true;
                   q.add(curr - 1);

               }

               if (curr + 1 < n && !vis[curr + 1]) {

                   //mark it as visited
                   vis[curr + 1] = true;
                   q.add(curr + 1);

               }
           }

           time++;

       }

       return (time-1);
    }

}
