package Graph;
import java.util.*;

//TC - O(N+M)
//SC - O(N+M)
public class Remove_Methods_From_Project {

    void dfs(List<Integer>[] graph, int node, boolean[] suspicious, int[] inDeg) {

        if (suspicious[node]) {//already marked
            return;
        }

        //mark it suspicious
        suspicious[node] = true;

        //Traverse over its neighbours

        for (int neigh : graph[node]) {
            inDeg[neigh]--;
            dfs(graph, neigh, suspicious, inDeg);

        }

    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        boolean[] suspicious = new boolean[n];
        int[] inDegree = new int[n];

        //initialise all ArrayLists

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        //Now Build Graph by Using Invocations array

        for (int[] i : invocations) {

            int u = i[0];
            int v = i[1];

            graph[u].add(v);
            inDegree[v]++;

        }

        //call dfs
        dfs(graph, k, suspicious, inDegree);

        boolean cannotRemove = false;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (suspicious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }

            if (!suspicious[i]) {

                ans.add(i);
            }

        }

        if (cannotRemove) {
            List<Integer> ans2 = new ArrayList<>();
            for (int i = 0; i < n; i++)
                ans2.add(i);
            return ans2;

        } else {
            return ans;
        }

    }

    public static void main(String[] args) {
        Remove_Methods_From_Project obj = new Remove_Methods_From_Project();
        int[][] invocations = {{1,2},{0,1},{3,2}};
        System.out.println("List Of Methods in the Project : "+obj.remainingMethods(4,1,invocations));
    }


}
