package dynamicProgramming;

public class Jump_Game_5 {

    private int[] f;

    private void dfs(int[] arr, int id, int d, int n) {
        if (f[id] != -1) {
            return;
        }
        f[id] = 1;
        for (int i = id - 1; i >= 0 && id - i <= d && arr[id] > arr[i]; --i) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
        for (int i = id + 1; i < n && i - id <= d && arr[id] > arr[i]; ++i) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        f = new int[n];
        java.util.Arrays.fill(f, -1);
        for (int i = 0; i < n; ++i) {
            dfs(arr, i, d, n);
        }
        int ans = 0;
        for (int val : f) {
            ans = Math.max(ans, val);
        }
        return ans;
    }


    public static void main(String[] args) {

        Jump_Game_5 obj = new Jump_Game_5();


        System.out.println("Maximum Jumps : "+obj.maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12},2));
    }

}
