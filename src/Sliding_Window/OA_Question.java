package Sliding_Window;

public class OA_Question {

//    Given a permutation p of length N, a number k is balanced if there are 2 indices l and r (1 <= l <= r <= N),
//    such that the numbers [p[l], p[l+1], .... , p[r]] form a permutation of  the numbers from 1,2,...k.
//
//    For each k (1 <= k <= N), determine if it is balanced or not.
//    Return a binary string of length N where the i th character is 1 if [i] is balanced and 0 otherwise.
//
//    A permutation of length N contains each integer from 1 to N exactly once in any order.
//
//    Example:
//    p= [4,1,3,2]
//    N = 4
//    output: "1011"


    public static void main(String[] args) {

        int[] p={6,1,7,3,4,8,2,5,0};

        System.out.println("String : "+getBalancedString(p));

    }

    public static String getBalancedString(int[] p ){

        int n=p.length;

        StringBuilder ansString=new StringBuilder("1");//as we will always have a subArray of size 1 with element
        // 1 to 1=1 only and same goes with size n subArray which will contain all elements from 1 to n

        int[] pos=new int[n+1];

        for(int i=0;i<n;i++){

            pos[p[i]]=i;

        }

        int left=pos[1];
        int right=pos[1];

        for(int k=2;k<n;k++){

         left= Math.min(left,pos[k]);
         right=Math.max(right,pos[k]);

         if((right-left+1)==k){
             ansString.append("1");
         }else{
             ansString.append("0");
         }


        }

        ansString.append("1");

        return ansString.toString();
    }


}
