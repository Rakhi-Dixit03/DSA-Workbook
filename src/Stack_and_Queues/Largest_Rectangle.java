package Stack_and_Queues;

import java.util.Stack;

public class Largest_Rectangle {


    public static void main(String[] args) {

        int[] heights={2,1,5,6,2,3};
        System.out.println("Largest Area of the rectangle in the Histogram : "+largestArea1(heights));
        System.out.println("Largest Area of the rectangle in the Histogram : "+largestArea2(heights));
        System.out.println("Largest Area of the rectangle in the Histogram : "+largestArea3(heights));
    }


    //Brute Force
    public static int largestArea1(int[] height){

        int n=height.length;
        int maxArea=0;

        for(int i=0;i<n;i++){

            int minHeight=Integer.MAX_VALUE;

            for(int j=i;j<n;j++){ //Idea is to find left smaller and right smaller for the current element

               minHeight=Math.min(minHeight,height[j]);//This minHeight will act as smaller element in the left and running value of j will act as smaller element in right
               int width=j-i+1;
               maxArea=Math.max(maxArea,(minHeight*width));

            }

        }
        return maxArea;
    }


//Better Approach using Monotonic stack
    public static int largestArea2(int[] height){

        int maxArea=0;
        int n=height.length;

        java.util.Stack<Integer>st=new Stack<>();

        int[] leftSmaller=new int[n];
        int[] rightSmaller=new int[n];


        //Left Smaller Elements or prev smaller
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && height[st.peek()]>=height[i]){

                st.pop();
            }

            if(st.isEmpty())leftSmaller[i]=0;
            else leftSmaller[i]=st.peek()+1;

            st.push(i);

        }


        while(!st.isEmpty())st.pop();//Making stack empty to reuse it

        //Right Smaller elements  or next Smaller
        for(int i=n-1;i>=0;i-- ){

            while(!st.isEmpty() && height[st.peek()]>=height[i]){

                st.pop();

            }

            if(st.isEmpty())rightSmaller[i]=n-1;
            else rightSmaller[i]=st.peek()-1;
            st.push(i);

        }



        for(int i=0;i<n;i++){

            maxArea=Math.max(maxArea,height[i]*(rightSmaller[i]-leftSmaller[i]+1));//height*width

        }

     return maxArea;

    }


//Optimised Approach TC-O(N)
    public static int largestArea3(int[] height){
        int n=height.length;
        int maxArea=0;

        java.util.Stack<Integer>st=new Stack<>();


        for(int i=0;i<=n;i++){

            while(!st.isEmpty() && (i==n || height[st.peek()]>=height[i])){//i==n is for the remaining elements that will be left after heights array exhausts

                int h=height[st.pop()];

                int width;
                if(st.isEmpty())width=i;
                else width=i-st.peek()-1;//Derived Formula for calculating width

                maxArea=Math.max(maxArea,h*width);
            }

            st.push(i);
        }

       return maxArea;

    }


}


