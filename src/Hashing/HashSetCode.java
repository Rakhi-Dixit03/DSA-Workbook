package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetCode {


    public static void main(String[] args) {

        //HahSet creation
        //Duplicates are not allowed
        //Unordered
        //null value is allowed
        //Insertion,Deletion,and searching takes  O(1) in Average Cases
        //Internal Implementation : HashMap which is implemented through Array of LinkedLists or trees
        HashSet<Integer>set=new HashSet<>();
        set.add(2);
        set.add(3);
       // set.add(2);duplicate values are not allowed
        set.add(5);

        System.out.println("Elements of  HashSet are : "+set);

        //LinkedHashSet Creation

        //Maintains insertion order of elements
        //null value is allowed
        //Insertion,Deletion,and searching takes  O(1) in Average Cases
        //Internal Implementation : LinkedHashMap which is implemented by using Doubly LinkedLists
        LinkedHashSet<Integer>linkedSet=new LinkedHashSet<>();

        linkedSet.add(1);
        linkedSet.add(3);
        linkedSet.add(2);
        linkedSet.add(5);

        System.out.println("Elements of LinkedHashSet  are : "+linkedSet);

        //TreeSet Creation
        //Maintains Sorted order of elements, by default increasing order
        //null value is not allowed
        // Insertion,Deletion,and searching takes  O(log(N))
        //Internal Implementation : TreeMap which is implemented through  Red-Black Trees
        TreeSet<Integer>treeSet=new TreeSet<>((a,b)->b-a);//can define our custom logic for sorting elements

        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(4);
        treeSet.add(6);

        System.out.println("Elements of TreeSet are : "+treeSet);



        distinctEle(new int[]{2,3,4,1,2,1,5,7,4});


    }


    public static void distinctEle(int[] arr){

        Set<Integer> set=new HashSet<>();

        for(int num:arr){

            set.add(num);
        }

        System.out.println("Number of distinct Elements in the array is : "+set.size());

        System.out.println("Values are : ");
        for(int val:set){
            System.out.print(val+" ");
        }

    }


}
