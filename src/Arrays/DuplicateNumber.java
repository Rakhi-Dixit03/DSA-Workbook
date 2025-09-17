package Arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {

    public static void main(String[] args) {
        int[] arr={1,3,2,3,4};
        System.out.println("Duplicate number using First Approach is : "+duplicateNumber1(arr));
        System.out.println("Duplicate number using second Approach is : "+duplicateNumber2(arr));
        System.out.println("Duplicate number using third Approach is : "+duplicateNumber3(arr));
        System.out.println("Duplicate number using third Approach is : "+duplicateNumber4(arr,4));
    }

    //1st Approach TC-O(N) SC-O(N)
    public static int duplicateNumber1(int[] arr){

        Set<Integer> set=new HashSet<>();

        for(int i=0;i<arr.length;i++){

            if(!set.add(arr[i])){
               return arr[i];
            }

        }
        return -1;
    }

    //2nd Approach TC-O(NLogN) SC-O(1)
    public static int duplicateNumber2(int[] arr){
        java.util.Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++){

            if(arr[i]==arr[i+1]){
                return arr[i];
            }

        }
        return -1;
    }

    //LinedList Cycle method to find duplicate
    //3rd Approach TC-O(N) SC-O(1)
    public static int duplicateNumber3(int[] arr){

        int slow=0;
        int fast=0;

        do{

            slow=arr[slow];
            fast=arr[arr[fast]];

        }while(slow!=fast);

        fast=0;

        while(slow!=fast){

            slow=arr[slow];
            fast=arr[fast];
        }

       return slow;
    }

    //4th Approach
    public static int duplicateNumber4(int[] arr,int n){

       int[] freq=new int[n+1];
        for(int i=1;i<=arr.length;i++){

            if(freq[arr[i]]==0){
                freq[arr[i]]+=1;
            }else{
                return arr[i];
            }
        }
        return -1;
    }

}
