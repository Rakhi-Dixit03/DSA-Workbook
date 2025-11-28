package Heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapImpl {

    static class Heap{

        private final List<Integer> arr=new ArrayList<>();

        public void add(int val){

            arr.add(val);//adding at the end of array i.e. at the last level of heap

          //fix the heap

            int x= arr.size()-1;//child index
            int par=(x-1)/2;//parent index

            while(arr.get(x)<arr.get(par)){

                //swap
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                x=par;
                par=(x-1)/2;

            }

        }

        private void heapify(int i){

            int left=2*i+1;//left child index
            int right=2*i+2;//right child index
            int minIdx=i;

            //compare and find minimum value minIdx

            if(left<arr.size() && arr.get(left)<arr.get(minIdx)){
                minIdx=left;
            }

            if(right< arr.size() && arr.get(right)<arr.get(minIdx)){

                minIdx=right;
            }

            //swap element at root with minIdx element

            if(minIdx!=i){

                int temp=arr.get(minIdx);
                arr.set(minIdx,arr.get(i));
                arr.set(i,temp);
                heapify(minIdx);//calling heapify for swapped val

            }

        }


        public int remove(){

            int ele=arr.get(0);//root element

            //1. swap 1st and last element in the heap

            int temp=arr.get(arr.size()-1);
            arr.set(arr.size()-1,arr.get(0));
            arr.set(0,temp);

            arr.remove(arr.size()-1);//delete last element

            //fix the heap

            heapify(0);//fix the heap from top to bottom

            return ele;
        }


         public int peek(){

                return arr.get(0);

         }

         public boolean isEmpty(){

                return arr.isEmpty();
         }


    }

    public static void main(String[] args) {

        Heap heap=new Heap();
        heap.add(1);
        heap.add(4);
        heap.add(5);
        heap.add(3);
        heap.add(2);

        while(!heap.isEmpty()){

            System.out.print(heap.peek()+" ");
            heap.remove();
        }

    }


}
