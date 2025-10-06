package Recursion_BackTracking;

public class First_Last_Occur {


    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,5,6,6};
        System.out.println(firstOccur(arr,0,arr.length,2));
        System.out.println(lastOccur(arr,0,2, arr.length));
        System.out.println("Array sorted or not : "+isSorted(arr,0));
    }


    public static int firstOccur(int[] arr,int i,int n,int key){

        //Base case
        if(i==n)return -1;

        if(arr[i]==key){
            return i;
        }
       return  firstOccur(arr,i+1,n,key);
    }


    public static int lastOccur(int[] arr,int i,int key,int n){

        //Base case
        if(i==n)return -1;

        int found=lastOccur(arr,i+1,key,n);

        if(found!=-1)return found;

        if(arr[i]==key)return i;

       return -1;

    }

   public static boolean isSorted(int[] arr,int i){

        //Base case
       if(i==arr.length-1)return true;

       if(arr[i]>arr[i+1])return false;

       return isSorted(arr,i+1);

   }


}
