package Graph;

public class Min_Score_Of_A_Path_Bet_2_Cities {

    static int find(int[] root, int i) {
        if (root[i] == i)
            return i;
        return root[i] = find(root, root[i]);
    }

    public static int minScore(int n, int[][] roads) {
        int[] root = new int[n + 1];
        for (int i = 0; i <= n; i++)
            root[i] = i;

        for (int[] r : roads)
            root[find(root, r[0])] = find(root, r[1]);

        int res = 10001;
        for (int[] r : roads)
            if (find(root, r[0]) == find(root, 1))
                res = Math.min(res, r[2]);

        return res;
    }

    public static void main(String[] args) {

        System.out.println("Minimum Score Of A Path Between 2 Cities : "
                +minScore(4,new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}}));
    }

}
