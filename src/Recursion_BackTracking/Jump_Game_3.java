package Recursion_BackTracking;

//TC-O(N)
//SC-O(N)
public class Jump_Game_3 {

    boolean []vis;

    boolean solve(int[] arr, int i) {

        if (i < 0 || i >= arr.length || vis[i]) {
            return false;
        }

        if (arr[i] == 0) {
            return true;
        }

        vis[i] = true;

        return solve(arr, i + arr[i]) || solve(arr, i - arr[i]);

    }

    public boolean canReach(int[] arr, int start) {

        int n = arr.length;
        vis = new boolean[n];

        return solve(arr, start);

    }


    public static void main(String[] args) {
        Jump_Game_3 obj =new Jump_Game_3();

        System.out.println("Can we reach an index with value 0 :  "+obj.canReach(new int[]{4,2,3,0,3,1,2},5));
    }


}
