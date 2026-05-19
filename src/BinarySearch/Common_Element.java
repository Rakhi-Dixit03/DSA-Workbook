package BinarySearch;

public class Common_Element {

    public int getCommon(int[] numbers1, int[] numbers2) {

        //TC-O(Max(M,N))
       //Two Pointer Approach
         int i = 0, j = 0;

         while ((i < numbers1.length) && (j < numbers2.length)) {

             if (numbers1[i] == numbers2[j]) {
                 return numbers1[i];
             } else if (numbers1[i] < numbers2[j]) {
                 i++;

             } else {
                 j++;
             }

         }

         //TC-O(N*logM)
        //Binary Search
        for(int num:numbers1){

            if(binarySearch(num,numbers2)){
                return num;
            }


        }
        return -1;

    }

    //Binary Search Solution
    boolean binarySearch(int target,int[] arr){

        int l=0;
        int r=arr.length-1;

        while(l<=r){

            int mid=l+(r-l)/2;

            if(arr[mid]==target){
                return true;
            }else if(arr[mid]>target){

                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return false;
    }

}
