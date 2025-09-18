package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWin_Max {

    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,7,1,6};
        System.out.println("Sliding Window Maximum through Brute Force : ");
        System.out.println(slidingWinMax(arr,3).toString());
        System.out.println("Sliding Window Maximum through Optimised Approach : ");
        System.out.println(slidingWinMax2(arr,3).toString());
    }

    //Brute force O(N^2)

    public static List<Integer> slidingWinMax(int[] arr,int k){

       int n=arr.length;
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<n-k;i++){
            int max=arr[i];

            for(int j=i+1;j<i+k;j++){

               max= Math.max(arr[j],max);

            }
            ans.add(max);

        }
        return ans;

    }

   //Optimised Approach

    public static List<Integer> slidingWinMax2(int[] arr,int k){

        Deque<Integer>dq=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            //Checking for valid window size
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){

                dq.pollFirst();

            }

            //Maintaining monotonic stack
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();

            }
            dq.addLast(i);

            if(!dq.isEmpty() && i>=k-1){
                ans.add(arr[dq.peekFirst()]);
            }

        }

       return ans;
    }








}
