package Heaps;

//heap sort algorithm

public class HeapSort {


    public static void main(String[] args) {

        int[] arr={3,5,7,3,-1,2,1,0,9,-2,8};

        heapSort(arr);
        System.out.println("Sorted Array : ");
        for(int n:arr) System.out.print(n+" ");

    }

    //For Max Heap
    private static void heapify(int i,int n,int[] arr){

        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left<n && arr[left]>arr[maxIdx]){
            maxIdx=left;
        }

        if (right < n && arr[right] > arr[maxIdx]){
            maxIdx=right;

        }

        if(maxIdx!=i){

            //swap
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;

            heapify(maxIdx,n,arr);

        }


    }


    public static void heapSort(int[] arr){
        int n=arr.length;
        //Sorting in Ascending Order (for that we need to create maxHeap)

        //Non-leaf nodes in tree-visualisation, we are going to heapify them
        //build max-heap
        for(int i=n/2;i>=0;i--){ //O(Nlog(N))

            heapify(i,n,arr);//index and size of heap

        }

     //performing sorting  //O(Nlog(N))
      for(int i=n-1;i>=1;i--){

          //swap first and last element

          int temp=arr[0];
          arr[0]=arr[i];
          arr[i]=temp;

          heapify(0,i,arr);//log(N)

      }

    }
}
