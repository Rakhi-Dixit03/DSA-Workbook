package Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int n=4;
        int m=3;
        int[] arr1=new int[n+m];
        arr1[0]=2;
        arr1[1]=2;
        arr1[2]=60;
        arr1[3]=80;
        int[] arr2={5,7,20};
        mergeSorted(arr1,arr2,n,m);
        printArray(arr1);
    }


    public static void mergeSorted(int[] arr1,int[] arr2,int n,int m){

        int i=n-1;
        int j=m-1;
        int k=n+m-1;

        while(i>=0 && j>=0){

            if(arr1[i] >= arr2[j]){
                arr1[k--]=arr1[i--];

            }else{
                arr1[k--]=arr2[j--];
            }

        }

        while(j>=0){
            arr1[k--]=arr2[j--];
        }
    }

    public static void printArray(int[] arr){

        for(int i:arr){
            System.out.print(i+" ");
        }
    }

}
