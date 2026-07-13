package Stack_and_Queues;

import java.util.*;

//TC-O(N) - where N is total count of Sequential Numbers
//Due to  constant number of sequential digits we can also Write TC-O(1)
//SC-O(N)

public class Sequential_Digits {

    public static List<Integer> sequentialDigits1(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        java.util.Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 8; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {

            int curr = q.poll();

            if (curr > high)
                break;

            if (curr >= low ) {//valid Sequential number
                ans.add(curr);
            }

            int lastDigit = curr % 10;

            if (lastDigit + 1 <= 9) {
                int newVal = curr * 10 + lastDigit + 1;
                q.add(newVal);
            }

        }

        return ans;
    }

    public static List<Integer> sequentialDigits2(int low, int high) {

        List<Integer> ans = new ArrayList<>();
        int[] seqDigits = {12,23,34,45,56,67,78,89,
                123,234,345,456,567,678,789,
                1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,
                123456,234567,345678,456789,
                1234567,2345678,3456789,
                12345678,23456789,
                123456789};


        for (int seqNum : seqDigits) {

            if (seqNum >= low && seqNum <= high) {

                ans.add(seqNum);
            }
        }



        return ans;
    }

    public static void main(String[] args) {

        System.out.println("Sequential Numbers are : "+sequentialDigits1(100,300));
        System.out.println("Sequential Numbers are : "+sequentialDigits2(100,300));
    }

}
