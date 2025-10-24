package Stack_and_Queues;

import java.util.Stack;

public class Celebrity_Problem {

    public static void main(String[] args) {

        int[][] mat={{0,1,0},{0,0,0},{0,1,0}};

        int n=mat.length;
        System.out.println("Celebrity is : "+celebrityProblem(mat,n));


    }


    public static int celebrityProblem(int[][] mat,int n){

     java.util.Stack<Integer>st=new Stack<>();

     for(int  i=0;i<n;i++){//pushing Candidates to stack
         st.push(i);

        }

     while(st.size()>1){

         int i=st.pop();
         int j=st.pop();

         if(mat[i][j]==0)st.push(i);//Eliminating
         else{
             st.push(j);
         }

     }
      int celebrity=st.pop();

     for(int i=0;i<n;i++){//Ensuring Celebrity

         if(i!=celebrity && (mat[i][celebrity]==0 || mat[celebrity][i]==1))return -1;

     }

    return celebrity;

    }

}
