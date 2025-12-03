package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median_in_a_Data_Stream {


    public static void main(String[] args) {

       MedianFinder obj=new MedianFinder();

       obj.addNum(1);
       obj.addNum(2);
       System.out.println("Median is : "+obj.findMedian());
       obj.addNum(3);
       System.out.println("Median is : "+obj.findMedian());


    }

}

class MedianFinder {

    private static PriorityQueue<Integer> left_max_heap;
    private static PriorityQueue<Integer> right_min_heap;

    public MedianFinder() {

        left_max_heap = new PriorityQueue<>(Comparator.reverseOrder());
        right_min_heap = new PriorityQueue<>();

    }

    //O(LogN)
    public void addNum(int num) {
        //Adding new Element
        if (left_max_heap.isEmpty() || num < left_max_heap.peek()) {

            left_max_heap.add(num);

        } else {

            right_min_heap.add(num);

        }

        //Maintain left_max_heap size one more than right_min_heap size

        if (left_max_heap.size() - right_min_heap.size() > 1) {

            right_min_heap.add(left_max_heap.peek());
            left_max_heap.poll();

        } else if (left_max_heap.size() < right_min_heap.size()) {

            left_max_heap.add(right_min_heap.peek());
            right_min_heap.poll();

        }

    }
    //O(1)
    public double findMedian() {

        if ((left_max_heap.size() == right_min_heap.size())) {

            return ((double) left_max_heap.peek() + right_min_heap.peek()) / 2;

        }

        return left_max_heap.peek();

    }
}
