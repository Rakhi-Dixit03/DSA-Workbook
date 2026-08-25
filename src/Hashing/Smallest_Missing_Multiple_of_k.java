package Hashing;

import java.util.*;

public class Smallest_Missing_Multiple_of_k {
    //TC-O(N+M)
    //SC-O(N)
    public static int missingMultiple(int[] numbers, int k) {

        Set<Integer> set = new HashSet<>();

        for (int num : numbers) {
            set.add(num);
        }

        int ans = k;
        while (set.contains(ans)) {
            ans += k;

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Smallest Missing Multiple of K : "+missingMultiple(new int[]{8,2,3,4,6},2));
        System.out.println("Smallest Missing Multiple of K : "+missingMultiple1(new int[]{8,2,3,4,6},2));
    }

    //Using Sorting TC- O(NLogN)
    //SC-O(1)
    public static int missingMultiple1(int[] numbers, int k) {

        Arrays.sort(numbers);

        int ans = k;

        for (int num : numbers) {

            if (num > 0 && num % k == 0) {
                if (num == ans) {//if multiple encountered ,find next
                    ans += k;

                }
            }

        }

        return ans;
    }
}
