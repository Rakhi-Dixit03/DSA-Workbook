package BinarySearch;

public class AllocatePages {

    public static void main(String[] args) {

        int[] arr={12,34,67,90};
        int k=2;
        System.out.println("Minimum Number of Pages that can be allocated to a student are : "+allocatePages(arr,k));
    }


    public static int allocatePages(int[] arr,int k){
        //k is number of students
        if(k>arr.length)return -1;

        int low;//max Element in the array
        int high=0;//Sum of all elements

        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>max){
                max=arr[i];
            }

            high+=arr[i];

        }

        low=max;
        int res=-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(isValid(arr,k,mid)){
                res=mid;
                high=mid-1;
            }else{

                low=mid+1;

            }
        }
        return res;
    }

    public static boolean isValid(int[] arr,int k,int mid){

        int student=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            sum+=arr[i];

            if(sum>mid){
                student++;
                sum=arr[i];
            }


            if(student>k)return false;
        }

        return true;
    }

}
