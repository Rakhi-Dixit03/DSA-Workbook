package Binary_Tree;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;


public class kth_Largest_Sum {


    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        System.out.println("Kth largest level Sum is : "+kthLargestLevelSum(root,2));

    }
    public  static long kthLargestLevelSum(TreeNode root, int k) {

        //Going to use Queue and a min-heap[to maintain kth Largest sum]

        Queue<TreeNode> q = new LinkedList<>();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        q.add(root);

        while (!q.isEmpty()) {

            int levelSize = q.size();

            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode curr = q.poll();

                levelSum += curr.val;

                if (curr.left != null)
                    q.add(curr.left);//Adding nodes of next level
                if (curr.right != null)
                    q.add(curr.right);

            }

            pq.add(levelSum);

            if (pq.size() > k) {
                pq.poll();
            }

        }

        if (pq.size() < k)
            return -1;//not enough levels

        return pq.peek();

    }



}
