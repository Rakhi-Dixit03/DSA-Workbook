package Graph;

import java.util.*;

public class MinMovesBal_CircularArr {


    public static void main(String[] args) {

       int[] balance={1,2,-5,2};

        System.out.println("Minimum Moves required  to balance the circular Array : "+minMoves(balance));
        System.out.println("Minimum Moves required  to balance the circular Array using 2nd method : "+minMoves2(balance));

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

        if(needyIdx==-1)return 0;//in case there is no negative element although problem guarantees one

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

    //2nd Approach
 //TC-O(N)
    public static long minMoves2(int[] balance) {

        long minMoves = 0;
        long sum = 0;
        int n = balance.length;

        for (int num : balance) {//early check
            sum += num;

        }

        if (sum < 0)
            return -1;


        //finding index and amount of needy(negBalance)
        int needyIdx = -1;


        for (int i = 0; i < n; i++) {

            if (balance[i] < 0) {
                needyIdx = i;

            }

        }


        if(needyIdx==-1){
            return 0;
        }

        int dis=1;

        while(balance[needyIdx]<0){

            int left = (needyIdx-dis+n)%n;//% to handle circular array

            int right = (needyIdx+dis)%n;

            long available=balance[right]+balance[left];

            if(left==right){//if contributor is the same index

                available-=balance[right];

            }

            long needed = -balance[needyIdx];

            long taken=Math.min(needed,available);

            minMoves+=taken*dis;
            balance[needyIdx]+=(int)taken;

            dis++;

        }
        return minMoves;
    }





}
