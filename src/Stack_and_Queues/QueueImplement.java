package Stack_and_Queues;

import java.util.Stack;

public class QueueImplement {

    public static void main(String[] args) {

        Queue q=new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Queue Size : "+q.size());

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.peek());

        System.out.println("Queue Size : "+q.size());


    }

}


//Implementing a Queue using 2 stacks

class Queue{

private static int size;
private Stack<Integer>inputSt;
private Stack<Integer>outputSt;


public Queue(){

    inputSt=new Stack<>();
    outputSt=new Stack<>();

}

//Adding an element in the queue O(1)
public void enqueue(int val){

    inputSt.push(val);
    size++;
    System.out.println("Element Added.");
}

//Removing element from the Queue O(N)

public int dequeue(){

    //check in output stack

    if(!outputSt.isEmpty()){
        size--;
        return outputSt.pop();
    }else{

        if(inputSt.isEmpty()){
            throw new IllegalStateException("Queue is empty!");
        }else{

            //transfer all elements of input stack to output stack

            while(!inputSt.isEmpty()){

                outputSt.push(inputSt.pop());

            }
            size--;
            return outputSt.pop();
        }


    }


}


public int peek(){

    if(!outputSt.isEmpty()){
        return outputSt.peek();

    }else{

        if(inputSt.isEmpty()){
            throw new IllegalStateException("Queue is Empty!");

        }else{


            while(!inputSt.isEmpty()){

                outputSt.push(inputSt.pop());
            }

            return outputSt.peek();

        }

    }
}


public int size(){
    return size;
}

}