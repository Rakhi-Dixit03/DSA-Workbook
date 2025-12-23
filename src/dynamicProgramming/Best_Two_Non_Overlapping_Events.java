package dynamicProgramming;

import java.util.Comparator;

public class Best_Two_Non_Overlapping_Events {

    public static void main(String[] args) {

        int[][] events = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};

        Best_Two_Non_Overlapping_Events obj = new Best_Two_Non_Overlapping_Events();

        System.out.println("Maximum Value that we can get by choosing two best Events : " + obj.maxTwoEvents(events));
        System.out.println("Maximum Value that we can get by choosing two best Events : " + obj.maxTwoEvents2(events));

    }

    //TC-O(NLogN)
    //SC-O(N)
    int n;

    public  int maxTwoEvents(int[][] events) {

        n = events.length;
        int[][] memo=new int[100001][3];
        //initialising memo

        for(int[] row : memo){

            java.util.Arrays.fill(row,-1);
        }
        java.util.Arrays.sort(events, Comparator.comparingInt(a->a[1]));

        return solve(events, 0, 0,memo);
    }

    private int binarySearch(int[][] events, int end) {

        int l = 0, h = n - 1;
        int ans = n;
        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (events[mid][0] > end) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return ans;
    }

    private int solve(int[][] events, int i, int count,int[][] memo) {

        //Base Case

        if (i >= n || count == 2) {
            return 0;
        }

        if(memo[i][count]!=-1)return memo[i][count];

        int validIdx = binarySearch(events, events[i][1]);
        int take = events[i][2] + solve(events, validIdx, count + 1,memo);

        int notTake = solve(events, i + 1, count,memo);

        return memo[i][count]= Math.max(take, notTake);

    }



    //2nd Approach


    public int maxTwoEvents2(int[][] events) {

        n = events.length;

        java.util.Arrays.sort(events,Comparator.comparingInt(a -> a[0]));
        int ans = 0;

        int[] suffix = new int[n];//storing maximum value from index i to the last of events arrays

        suffix[n - 1] = events[n - 1][2];


        for (int i = n - 2; i >= 0; i--) {

            suffix[i] = Math.max(suffix[i + 1], events[i][2]);

        }



        for (int[] event : events) {

            int val = event[2];

            int l = 0, h = n - 1;

            int idx = -1;
            while (l <= h) {

                int mid = l + (h - l) / 2;

                if (events[mid][0] > event[1]) {
                    idx = mid;
                    h = mid -1;
                } else {
                    l = mid + 1;
                }

            }

            if (idx != -1) {
                val += suffix[idx];
            }

            ans = Math.max(ans, val);

        }

        return ans;

    }


}
