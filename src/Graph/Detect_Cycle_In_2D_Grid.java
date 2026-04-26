package Graph;

//TC-O(M*N)
//SC-O(M*N)

public class Detect_Cycle_In_2D_Grid {

    int n,m;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    boolean detectCycleDFS(int r, int c, int prev_r, int prev_c, char[][] grid, boolean[][] vis) {
        if (vis[r][c]) {//cycle exists
            return true;
        }

        vis[r][c] = true;//mark curr cell visited

        for (int[] dir : directions) {//explore neighbours

            int new_r = r + dir[0];
            int new_c = c + dir[1];

            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n && grid[r][c] == grid[new_r][new_c]) {

                if (new_r == prev_r && new_c == prev_c) {//parent condition
                    continue;
                }

                if (detectCycleDFS(new_r, new_c, r, c, grid, vis)) {
                    return true;
                }

            }

        }
        return false;

    }

    public boolean containsCycle(char[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] vis = new boolean[m][n]; //visited Grid


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(!vis[i][j] && detectCycleDFS(i,j,-1,-1,grid,vis)){
                    return true;
                }

            }

        }
        return false;
    }

    public static void main(String[] args) {

        char[][] grid = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        Detect_Cycle_In_2D_Grid obj = new Detect_Cycle_In_2D_Grid();
        System.out.println("Does cycle Exist ? : "+obj.containsCycle(grid));
    }
}
//Can be solved with BFS and Union-Find too
