package Stack_and_Queues;

//Reverse first k elements of the queue

import java.util.LinkedList;
import java.util.Stack;

public class Reverse_1st_K_elements {

    public static void main(String[] args) {

        java.util.Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        reverseKEle(q,3);
        System.out.println(q.toString());

    }

    public static void reverseKEle(java.util.Queue<Integer> q,int k){

        java.util.Stack<Integer>st=new Stack<>();
        int n=q.size();
        //Dequeue 1st k elements and push them onto the stack  O(K)

        for(int i=0;i<k;i++){
           st.push(q.poll());
        }

        //Enqueue them back from the stack

        //K elements O(K)
        while(!st.isEmpty()){
            q.add(st.pop());

        }
        //Dequeue remaining n-k elements from the queue and enqueue them again

        for(int i=0;i<n-k;i++){

            q.add(q.poll());
        }

    }

    //Can also be solved using Deque (Similar to stack)
}
