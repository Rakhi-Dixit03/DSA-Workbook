package Graph;

import java.util.*;

public class MinMovesBal_CircularArr {


    public static void main(String[] args) {

       int[] balance={1,2,-5,2};

        System.out.println("Minimum Moves required  to balance the circular Array : "+minMoves(balance));


    }

    //TC-N(logN) for sorting
    //SC-O(N) for helpers list

    static class Pair {

        int minDis;
        int val;

        public Pair(int minD, int v) {

            minDis = minD;
            val = v;

        }

    }

    public static long minMoves(int[] balance) {

        long minMoves = 0;
        long sum = 0;
        int n = balance.length;

        for (int num : balance) {//early check
            sum += num;

        }

        if (sum < 0)
            return -1;

        //if possible find nearest helpers
        //finding index and amount of needy(negBalance)
        int needyIdx = -1;
        int need = 0;

        for (int i = 0; i < n; i++) {

            if (balance[i] < 0) {
                needyIdx = i;
                need = Math.abs(balance[i]);
            }

        }

        //Building a list of helpers along with their minimum distances(both straight and circular) from needy
        List<Pair> helpers = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (balance[i] > 0) {

                int minDis = Math.min(Math.abs(i - needyIdx), n - Math.abs(i - needyIdx));
                helpers.add(new Pair(minDis, balance[i]));

            }

        }

        helpers.sort(Comparator.comparingInt(a->a.minDis));//Sorting helpers by minimum distances


        for (Pair helper : helpers) {

            int take = Math.min(helper.val, need);

            minMoves += (long) take * helper.minDis;
            need -= take;

            if (need <= 0) {
                break;
            }

        }

        return minMoves;
    }


}
