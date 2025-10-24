package Stack_and_Queues;

import java.util.Stack;

public class Maximum_Min_Prod {

    static final long MOD =1_000_000_007L;
    public static void main(String[] args) {

        int[] arr={1,2,3,2};
        System.out.println(maxSumMinProduct(arr));


    }

    public  static int maxSumMinProduct(int[] nums) {

        long maxMinProd=0;
        int n=nums.length;

        java.util.Stack<Integer>st=new Stack<>();
        long[] prefix=new long[n];
        prefix[0]=nums[0];



        //Building Prefix Array

        for(int i=1;i<nums.length;i++){

            prefix[i] =nums[i]+prefix[i-1];

        }

        for(int i=0;i<=nums.length;i++){

            int curr=(i==n)?0: nums[i];

            while(!st.isEmpty() && nums[st.peek()]>curr){

                int minIdx=st.pop();

                int leftIdx=st.isEmpty()?0:st.peek()+1;
                int rightIdx=i-1;

                long subArrSum=prefix[rightIdx]-(leftIdx>0?prefix[leftIdx-1]:0L);

                long minProd=subArrSum*(long)nums[minIdx];

                maxMinProd=Math.max(maxMinProd,minProd);

            }

            if(i<n)st.push(i);
        }
        return (int)(maxMinProd % MOD);

    }



}
