package Stack_and_Queues;

import java.util.Stack;

public class Stock_Span_Problem {

    public static void main(String[] args) {

        int[] prices={10,4,5,90,120,80};

        System.out.println(java.util.Arrays.toString(stockSpan(prices)));

    }


    public static int[] stockSpan(int[] prices){

        java.util.Stack<Integer> st=new Stack<>();

        int[] ans=new int[prices.length];
        //initialise ans with 1's

        java.util.Arrays.fill(ans,1);

        for(int i=0;i<prices.length;i++){

            while(!st.isEmpty() &&  prices[st.peek()]<=prices[i]){

                ans[i]+=ans[st.peek()];

                st.pop();

            }

            st.push(i);

        }
        return ans;
    }


}
