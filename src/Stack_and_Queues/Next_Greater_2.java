package Stack_and_Queues;
import java.util.Stack;

//Next Greater Element in a Circular Array
public class Next_Greater_2 {


    public static void main(String[] args) {

        int[] nums={1,2,3,4,3};

        System.out.println(java.util.Arrays.toString(nextGreaterEle(nums)));
    }

    public static int[] nextGreaterEle(int[] nums){


        int n=nums.length;
        int[] ans=new int[n];

        java.util.Stack<Integer>st=new Stack<>();

        //initialising array
        java.util.Arrays.fill(ans,-1);

        for(int i=0;i<2*n;i++){

            int curr=nums[i%n];

            while(!st.isEmpty() && nums[st.peek()]<curr){

                ans[st.pop()]=curr;
            }

            if(i<n)st.push(i);

        }

        return ans;

    }
}
