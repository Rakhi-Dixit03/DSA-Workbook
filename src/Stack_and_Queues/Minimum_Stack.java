package Stack_and_Queues;

public class Minimum_Stack {

    public static void main(String[] args) {

        MinStack minStack=new MinStack();

        minStack.push(2);
        minStack.push(1);
        minStack.push(4);
        minStack.push(-1);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());

    }



}


class MinStack {

    java.util.Stack<Integer>st;
    java.util.Stack<Integer>minStack;

    public MinStack() {

        st=new java.util.Stack<>();
        minStack =new java.util.Stack();
    }

    public void push(int val) {

        st.push(val);

        if(minStack.isEmpty()){

            minStack.push(val);

        }else if(!minStack.isEmpty() && minStack.peek()>=val){

            minStack.push(val);
        }

    }

    public void pop() {

        if(!st.isEmpty()){

            if(!minStack.isEmpty()){

                if(st.peek().equals(minStack.peek()))minStack.pop();

            }

            st.pop();

        }

    }

    public int top() {

        return st.isEmpty()? -1: st.peek();

    }

    public int getMin() {

        return minStack.isEmpty()?-1 : minStack.peek();
    }
}