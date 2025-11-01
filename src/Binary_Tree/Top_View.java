package Binary_Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Top_View {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        System.out.println(topView(root));


    }


   public static List<Integer> topView(TreeNode root){

        List<Integer> ans=new ArrayList<>();

        Queue<Pair> q=new LinkedList<>();

        Map<Integer,Integer>map=new TreeMap<>();

        q.add(new Pair(0,root));//storing level and value  of a node


        while(!q.isEmpty()){

            Pair curr=q.poll();

            TreeNode node=curr.node;

            if(!map.containsKey(curr.level)){

                map.put(curr.level,node.val);
            }

            if(node.left!=null)q.add(new Pair(curr.level-1,node.left));


            if(node.right!=null)q.add(new Pair(curr.level+1,node.right ));


        }


        //Traversing Map

       for(Map.Entry<Integer,Integer>entry:map.entrySet()){

           ans.add(entry.getValue());
       }


       return ans;
   }

}


class Pair{

    int level;
    TreeNode node;

    public Pair(int level,TreeNode node){

        this.level=level;
        this.node=node;

    }


}
