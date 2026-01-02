package Graph;
import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_To_Target {

    public static void main(String[] args) {
        int[][] graph={{1,2},{3},{3},{}};
        All_Paths_From_Source_To_Target obj=new All_Paths_From_Source_To_Target();
        System.out.println("All Paths from Source To Target are : "+obj.allPathsSourceTarget(graph));


    }

    private List<List<Integer>>res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        res=new ArrayList<>();

        dfs(graph,0,n-1,new ArrayList<>());
        return res;

    }

    private void dfs(int[][] graph,int src,int des,List<Integer>list){

        list.add(src);

        if(src==des){

            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }


        for(int neigh : graph[src]){

            dfs(graph,neigh,des,list);


        }

        list.remove(list.size()-1);
    }


}
