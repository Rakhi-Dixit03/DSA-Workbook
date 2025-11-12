package Binary_Tree;

public class kth_Ancestor_BT {

    public static void main(String[] args) {

        int[] par={-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor ancestor=new TreeAncestor(7,par);

        System.out.println(ancestor.getKthAncestor(2,1));
        System.out.println(ancestor.getKthAncestor(3,1));


    }


}


class TreeAncestor {
    int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        //Binary Lifting

        dp = new int[16][n];//dp[i][j] => 2^ith ancestor of  node j

        dp[0] = parent;//1st ancestor of each node from 0 to n-1

        //for every power of two 2^i (1,2,4,....) we compute the 2^ith ancestor for each node

        for (int i = 1; i < 16; i++) {

            for (int j = 0; j < n; j++) {

                if (dp[i - 1][j] == -1) dp[i][j] = -1;
                else {

                    dp[i][j] = dp[i - 1][dp[i - 1][j]];

                }
            }

        }

    }

    public int getKthAncestor(int node, int k) {

        for (int i = 0; i < 16; i++) {

            if (node == -1) return -1;

            if (((1 << i) & k) != 0) {

                node = dp[i][node];

            }
        }


        return node;

    }

}

