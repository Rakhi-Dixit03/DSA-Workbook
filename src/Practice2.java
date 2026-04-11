import java.util.*;

import Binary_Tree.TreeNode;

public class Practice2 {

    static class Pair{

        int hd;//horizontal distance
        TreeNode node;

        public Pair(TreeNode n,int hd){
            this.hd=hd;
            this.node=n;


        }

    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(3),
                new TreeNode(4)),new TreeNode(5,new TreeNode(6),null));

        System.out.println("Top View Of Binary Tree : "+topViewBT(root));
        System.out.println("Bottom View of a Binary Tree : "+bottomView(root));

        System.out.println("Reversed String is : "+reverseStr("my name is rakhi"));
        System.out.println("String after Reversing vowels is :  "+reverseVowels("I LOVE JAVA"));
        arrangeList(new int[]{-8,4,3,-4,0,9,-6,5,7,8});
    }


    public static List<Integer> topViewBT(TreeNode root){

        Map<Integer,TreeNode> map=new HashMap<>();

        int minHD=0;//minimum horizontal distance
        int maxHD=0;//maximum horizontal distance
        Queue<Pair>q=new LinkedList<>();

        q.add(new Pair(root,0));


        while(!q.isEmpty()){

            Pair curr=q.poll();

            TreeNode node=curr.node;

            maxHD=Math.max(curr.hd, maxHD);
            minHD=Math.min(curr.hd,minHD);

            if(!map.containsKey(curr.hd)){//stores only if not already stored
                map.put(curr.hd, node);
            }

            //Store left child  if exist

            if(node.left!=null){

                q.add(new Pair(node.left,curr.hd-1));

            }

            if(node.right!=null){

                q.add(new Pair(node.right, curr.hd+1));
            }


        }

        //Answer List
        List<Integer>ans=new ArrayList<>();

        for(int i=minHD;i<=maxHD;i++){

            ans.add(map.get(i).val);


        }

        return ans;

    }

   //Bottom View

    public static List<Integer> bottomView(TreeNode root){

        Map<Integer,TreeNode> map=new HashMap<>();

        int minHD=0;//minimum horizontal distance
        int maxHD=0;//maximum horizontal distance
        Queue<Pair>q=new LinkedList<>();

        q.add(new Pair(root,0));


        while(!q.isEmpty()){

            Pair curr=q.poll();

            TreeNode node=curr.node;

            maxHD=Math.max(curr.hd, maxHD);
            minHD=Math.min(curr.hd,minHD);

               //store in the map
                map.put(curr.hd, node);


            //Store left child  if exist

            if(node.left!=null){

                q.add(new Pair(node.left,curr.hd-1));

            }

            if(node.right!=null){

                q.add(new Pair(node.right, curr.hd+1));
            }


        }

        //Answer List
        List<Integer>ans=new ArrayList<>();

        for(int i=minHD;i<=maxHD;i++){

            ans.add(map.get(i).val);


        }

        return ans;


    }

    //Strings Questions

    //Reverse String
    //my name is rakhi  to ym eman si ihkar means reversing string word by word
    //Since all major steps take time proportional to the total number of characters (N),
    // the overall time complexity remains efficient at O(N).

    public static String reverseStr(String s){

        String[] arr=s.split(" ");

        StringBuilder sb=new StringBuilder();
        for(String str:arr){

            sb.append(reverse(str)).append(" ");

        }

        return sb.toString();

    }


    public static String reverse(String s){

        StringBuilder sb=new StringBuilder();

        for(int i=s.length()-1;i>=0;i--){

            sb.append(s.charAt(i));

        }

        return sb.toString();
    }


   //Reversing Vowels in a String

    public static String reverseVowels(String s){

//        s=s.toLowerCase();
        char[] arr= s.toCharArray();//converting it to char array for easier manipulation

        int i=0;
        int j=arr.length-1;
        int n= arr.length;

        while(i<j){

            while(i<n && !isVowel(arr[i]))i++;

            while(j>=0 && !isVowel(arr[j]))j--;

            //swap chars at (i,j)
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;

        }

        return new String(arr);
    }


    public static boolean isVowel(char ch){

        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }


    public static void arrangeList(int[] arr){
       //-ve  0's  +ve  while maintaining the relative order

        for(int i=0;i< arr.length;i++){
            //if element is +ve do nothing


            if (arr[i]<0) {//-ve
                int j=i-1;
                int temp=arr[i];//current element

                while(j>=0 && arr[j]>=0){//making place for -ve element

                    arr[j+1]=arr[j];
                    j--;

                }

                //inserting it at it's right position
                arr[j+1]=temp;

            }else if(arr[i]==0){//if 0

                int j=i-1;
                int temp=arr[i];

                while(j>=0 && arr[j]>0){//making place for 0

                    arr[j+1]=arr[j];
                    j--;

                }

                //inserting it at it's right position
                arr[j+1]=temp;

            }


        }


        System.out.println("Arranged List is : "+Arrays.toString(arr));

    }



}
