package Binary_Tree;

public class Check_SubTree {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        TreeNode subRoot=new TreeNode(7,new TreeNode(6),new TreeNode(9));

        System.out.println(isSubtree(root,subRoot));


    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root==null)return false;

        if(helper(root,subRoot))return true;

        return  isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);//Look deeper in subtrees, searches through the big tree


    }


    private static boolean helper(TreeNode root,TreeNode subRoot){//this checks if two trees are identical or not

        //Base Cases

        if(root==null && subRoot==null)return true;

        if(root==null || subRoot==null)return false;


        if(root.val!=subRoot.val)return false;

        return helper(root.left,subRoot.left) && helper(root.right,subRoot.right);



    }

    //Using Tree Serialisation

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {

        String rootStr=serialise(root);
        String subRootStr=serialise(subRoot);

        return  rootStr.contains(subRootStr);


    }


    private String serialise(TreeNode root){

        if(root==null)return "#"; //Null marker (#) prevent false matches

        return ","+root.val+","+serialise(root.left)+","+serialise(root.right);


    }

}
