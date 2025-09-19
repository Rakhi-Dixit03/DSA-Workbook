package Arrays;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {

        int[] histo={2,1,5,6,2,3};
        System.out.println("Largest Rectangle area in Histogram : "+largestRectangle1(histo));
        System.out.println("Largest Rectangle area in Histogram : "+largestRectangle2(histo));
        System.out.println("Largest Rectangle area in Histogram : "+largestRectangle3(histo));


    }

//Brute Force
    public static int largestRectangle1(int[] histo){

        int max=Integer.MIN_VALUE;


        for(int i=0;i<histo.length;i++){

            int minHeight=Integer.MAX_VALUE;

            for(int j=i;j<histo.length;j++){
               minHeight= Math.min(minHeight,histo[j]);
                max=Math.max(max,minHeight*(j-i+1));
            }
        }
        return max;

    }
//Using Previous Smallest element and Next smallest element concept
    public static int largestRectangle2(int[] histo){
         int n=histo.length;
        int[] leftSmall=new int[n];
        int[] rightSmall=new int[n];
        int maxArea=0;
        Stack<Integer>st=new Stack<>();

                //Calculating previous smallest element
                for(int i=0;i<n;i++){

                    while(!st.isEmpty() && histo[st.peek()]>=histo[i]){
                        st.pop();
                    }

                    if(st.isEmpty())leftSmall[i]=0;
                    else{
                        leftSmall[i]=st.peek()+1;//valid index to which we can start calculating  area
                    }
                    st.push(i);
                }
              //Calculating next smallest element
                for(int i=n-1;i>=0;i--){

                    while(!st.isEmpty() && histo[st.peek()]>=histo[i]){
                        st.pop();
                    }

                    if(st.isEmpty())rightSmall[i]=n;
                    else{
                        rightSmall[i]=st.peek()-1;
                    }

                    st.push(i);
                }

                //Calculating max Area

                for(int i=0;i<n;i++){

                   maxArea= Math.max(maxArea,histo[i]*(rightSmall[i]-leftSmall[i]+1));

                }

               return maxArea;
    }

    //Using Concept of Monotonic stack
    public static int largestRectangle3(int[] histo){

      Stack<Integer>st=new Stack<>();
      int n=histo.length;
      int maxArea=0;
      for(int i=0;i<=n;i++){

          while(!st.isEmpty() && (i==n || histo[st.peek()]>=histo[i])){//sentinel

              int height=histo[st.peek()];
              st.pop();
              int width;

              if(st.isEmpty())
                  width=i;
              else{
                  width=i-st.peek()-1;
              }
              maxArea=Math.max(maxArea,height*width);
          }
          st.push(i);
      }
      return maxArea;
    }

}
