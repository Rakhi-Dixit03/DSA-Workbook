package BinarySearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class PaintersPartition {

    public static void main(String[] args) {

        int[] boards={10,10,10,10};
        System.out.println("Minimum time to paint all Boards is : "+paintersPartition(boards,2));


    }

    public static int paintersPartition(int[] boards,int m){

        int sum= Arrays.stream(boards).sum();
        int max=0;
        for(int ele:boards){
            if(ele>max) {
                max = ele;

            }
        }

        int low=max;
        int high=sum;
        int res=0;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(isPossible(boards,mid,m)){
                res=mid;
                high=mid-1;

            }else{

                low=mid+1;
            }
        }

        return res;
    }

   public static boolean isPossible(int[] boards,int mid,int m){

        int painters=1;
        int allocatedBlocks=0;
        for(int i=0;i<boards.length;i++){

//            allocatedBlocks+=boards[i];
            if(allocatedBlocks+boards[i]>mid){

                painters++;
                allocatedBlocks=boards[i];

            }else{
                allocatedBlocks+=boards[i];
            }
            if(painters>m)return false;



        }

        return true;
   }






}
