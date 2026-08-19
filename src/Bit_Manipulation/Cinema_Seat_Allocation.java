package Bit_Manipulation;

import java.util.*;
//TC-O(M)
//SC-O(M)
public class Cinema_Seat_Allocation {

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {

            int mask = (1 << seat[1]);
            map.put(seat[0], (map.getOrDefault(seat[0], 0) | mask));

        }

        int ans = 0;

        ans += (n - map.size()) * 2;

        int maskA = ((1 << 2) | (1 << 3) | (1 << 4) | (1 << 5));
        int maskB = ((1 << 4) | (1 << 5) | (1 << 6) | (1 << 7));
        int maskC = ((1 << 6) | (1 << 7) | (1 << 8) | (1 << 9));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            boolean grpA = (maskA & entry.getValue()) == 0;
            boolean grpB = (maskB & entry.getValue()) == 0;
            boolean grpC = (maskC & entry.getValue()) == 0;

            if (grpA && grpC) {
                ans += 2;
            } else if (grpA || grpB || grpC) {
                ans += 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] resSeats={{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};

        System.out.println("Maximum Number of Groups That can be allocated Seats : "+maxNumberOfFamilies(3,resSeats));
    }

}
