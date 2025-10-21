package Stack_and_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplement {

    public static void main(String[] args) {

        Stack2 st=new Stack2();

        st.push(12);
        st.push(24);
        st.push(36);

        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.size());

    }

}

//Stack Implementation using 1 queue

class Stack{

    private java.util.Queue<Integer>q;

    public Stack(){
        q=new LinkedList<>();

    }


    //Push,Adding an element in the Stack O(N)
    //We are going to manipulate our q such that recently added element always stays at the front of the q

    public void push(int val){

        q.add(val);
        int size=q.size();

        //move all the elements to the back of the queue except the newly added element

        for(int i=0;i<size-1;i++){

            q.add(q.poll());

        }

        System.out.println("Element Added");
    }


    //POP,Removing element from the Stack  O(1)

    public int pop(){

        if(q.isEmpty()){

            throw new IllegalStateException("Stack is Empty!");
        }

        return q.poll();

    }

    //O(1)
    public int peek(){

        if(q.isEmpty()){

            throw new IllegalStateException("Stack is Empty!");
        }

        return q.peek();

    }

    public boolean isEmpty(){

        return q.isEmpty();
    }

    //Size of Stack

    public int size(){
        return q.size();

    }

}


//Implementing Stack using 2 Queues

class Stack2{

    private java.util.Queue<Integer>q1;
   private java.util.Queue<Integer>q2;


    public Stack2(){

        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }


    //Push, Adding an element in the Stack

    public void push(int val){

        q2.add(val);

        //transferring all elements of q1 to q2

        while(!q1.isEmpty()){

            q2.offer(q1.poll());

        }

        //Swap both queues q1 and q2

        Queue<Integer>temp=q1;
        q1=q2;
        q2=temp;

    }


    //POP,remove element from the stack O(1)

    public int pop(){

        if(q1.isEmpty()){
            throw new IllegalStateException("Stack is empty!");
        }
        return q1.poll();
    }


    //Peek O(1)

    public int peek(){
        if(q1.isEmpty()){
            throw new IllegalStateException("Stack is empty!");
        }
        return q1.peek();

    }

    public boolean isEmpty(){
        return q1.isEmpty();

    }


    //Size of the Stack O(1)

    public int size(){

        return q1.size();
    }

}
