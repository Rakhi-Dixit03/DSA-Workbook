package Arrays;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr={2,1,3,1,2};
        System.out.println("Count of Inversions is  : "+countInversion(arr));
    }

    public static int countInversion(int[] arr){

        return mergeSort(arr,0,arr.length-1);


    }

    public static int mergeSort(int[] arr,int st,int end) {
        int count = 0;
        //Base Case
        if (st >= end) {
            return count;
        }

        int mid = st + (end - st) / 2;
        //LeftPart
        count += mergeSort(arr, st, mid);
        count += mergeSort(arr, mid + 1, end);
        count += merge(arr, st, mid, end);

        return count;
    }


    public static int merge(int[] arr,int st,int mid,int end){
        int count=0;
        int[] temp=new int[end-st+1];

        int i=st;
        int j= mid+1;
        int k=0;

        while(i<=mid && j<=end){

            if(arr[i]<=arr[j]){

                temp[k++]=arr[i++];
            }else{
                count+=mid-i+1;
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=end){
            temp[k++]=arr[j++];
        }

        //Copying elements of temp Array to original array
        int l=0;

        for(int m=st;m<=end;m++){
            arr[m]=temp[l];
            l++;
        }
        return count;
    }


}
