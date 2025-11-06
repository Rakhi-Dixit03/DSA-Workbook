package Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Max_Width_Of_BT {


    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6), new TreeNode(9)));

        System.out.println("Maximum width is : "+maxWidthOfBT(root));
        System.out.println("Max width : "+recursive(root));
    }

    //BFS TC-O(N) SC-(N)

    public static long maxWidthOfBT(TreeNode root ){

       long maxWidth=0;

        Deque<Data>dq=new ArrayDeque<>();

        dq.add(new Data(root,0));

        while(!dq.isEmpty()){

             int n=dq.size();//Size at this tree level

            long leftIdx=dq.peek().idx;
            long rightIdx=dq.peekLast().idx;

            maxWidth=Math.max(maxWidth,rightIdx-leftIdx+1);


            while(n-->0){

                TreeNode curr=dq.peekFirst().node;
                long index=dq.peekFirst().idx;

                dq.pollFirst();

                if(curr.left!=null){

                    dq.add(new Data(curr.left,2*index+1));

                }

                if(curr.right!=null){

                    dq.add(new Data(curr.right,2*index+2));
                }

            }


        }
        return maxWidth;
    }



//Recursive solution [DFS]
    public static int recursive(TreeNode root){

        if(root==null)return 0;

        return helper(root,1,0,new ArrayList<>());

    }

    public static int  helper(TreeNode root,int idx,int level,List<Integer>list){

        if(root==null)return 0;

        if(level== list.size()){
            list.add(idx);
        }

        int currWidth=idx-list.get(level)+1;

        int left=helper(root.left,2*idx,level+1,list);
        int right=helper(root.right,2*idx+1,level+1,list);
        return Math.max(currWidth,Math.max(left,right));


    }

}

//Storing  node and index
class Data{

    TreeNode node;
    long idx;

    public Data(TreeNode node,long idx){

        this.node=node;
        this.idx=idx;

    }

}
