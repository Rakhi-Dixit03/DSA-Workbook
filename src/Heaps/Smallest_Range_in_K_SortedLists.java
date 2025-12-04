package Heaps;

import java.util.*;

public class Smallest_Range_in_K_SortedLists {

    public static void main(String[] args) {


        Smallest_Range_in_K_SortedLists obj=new Smallest_Range_in_K_SortedLists();

        List<List<Integer>>lists=new ArrayList<>();

           List<Integer> list1=new ArrayList<>(Arrays.asList(4,10,15,24,26));
           List<Integer> list2=new ArrayList<>(Arrays.asList(0,9,12,20));
           List<Integer> list3=new ArrayList<>(Arrays.asList(5,18,22,30));
           lists.add(list1);
           lists.add(list2);
           lists.add(list3);

          System.out.println("Smallest Range Covering Elements from K Lists using Brute force is :" +
                  " "+Arrays.toString(obj.smallestRange1(lists)));
        System.out.println("Smallest Range Covering Elements from K Lists using Better Approach  is :" +
                " "+Arrays.toString(obj.smallestRange2(lists)));

        System.out.println("Smallest Range Covering Elements from K Lists using Optimal Approach  is :" +
                " "+Arrays.toString(obj.smallestRange3(lists)));


    }

    //Brute Force
   //Sorted List + Sliding window TC-O(N*K*(Log(N*K))
    static class Element {
        int val;
        int listIdx;

        public Element(int val,int listIdx) {

            this.val = val;
            this.listIdx = listIdx;
        }

    }

    public int[] smallestRange1(List<List<Integer>> nums) {

        List<Element> allEle = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {

            for (int val : nums.get(i)) {

                allEle.add(new Element(val, i));//value and listId to identify to which list it belongs to

            }
        }

        //Sorting all elements based on values

        allEle.sort(Comparator.comparingInt(a -> a.val));

        int k = nums.size();//total number of lists

        int nk = allEle.size();//size of sorted single  list containing all elements /Total number of elements of all lists

        int minRange = Integer.MAX_VALUE;

        int start = -1;//start of range
        int end = -1;//end of range

        int left = 0;//left pointer of sliding window

        Map<Integer, Integer> counts = new HashMap<>();

        for (Element currRightEle : allEle) {//expanding the window

            counts.put(currRightEle.listIdx, counts.getOrDefault(currRightEle.listIdx, 0) + 1);//number of elements in a list

            //Try shrinking the window from left,if we have at least one element from each list

            while (counts.size() == k) {

                Element currLeftEle = allEle.get(left);
                int currRange = currRightEle.val - allEle.get(left).val;

                //Update minimum range found so far

                if (minRange > currRange) {
                    minRange = currRange;
                    start = allEle.get(left).val;
                    end = currRightEle.val;

                }

                //shrink the window from the left

                counts.put(currLeftEle.listIdx, counts.get(currLeftEle.listIdx) - 1);
                if (counts.get(currLeftEle.listIdx) == 0) {
                    counts.remove(currLeftEle.listIdx);

                }

                left++;

            }

        }

        return new int[] { start, end };
    }



    //Better Approach O(N*K)
//Gave TLE 92/94
    public int[] smallestRange2(List<List<Integer>> nums) {

        int k=nums.size();

        int[] minArr=new int[k];//list elements' indices///initially storing 0th index of each list indicating element at this index


        int[] minRange={-1000000,1000000};

        while(true){

            int minEle=Integer.MAX_VALUE;
            int minEleListIdx=0;
            int maxEle=Integer.MIN_VALUE;


            for(int i=0;i<k;i++){//keeping k elements in minArray one element from each list

                int listIdx=i;
                int eleIdx= minArr[i];
                int element= nums.get(listIdx).get(eleIdx);

                if(element < minEle){//finding smaller element
                    minEle=element;
                    minEleListIdx=listIdx;
                }


                if(element > maxEle){

                    maxEle=element;

                }

            }

            if(maxEle-minEle < minRange[1]-minRange[0]){
                //update minRange

                minRange[0]=minEle;
                minRange[1]=maxEle;

            }

            //shortening the range by moving minElement index

            int newEleIdx = minArr[minEleListIdx]+1;
            if(newEleIdx >= nums.get(minEleListIdx).size()){
                break;
            }

            minArr[minEleListIdx]=newEleIdx;

        }
        return minRange;
    }


   //Optimal Approach TC-O(N*Log(K))
   static class Pair {

       int val;
       int eleIdx;
       int listIdx;

       public Pair(int val, int eleIdx, int listIdx) {

           this.val = val;
           this.eleIdx = eleIdx;
           this.listIdx = listIdx;

       }

   }

    public int[] smallestRange3(List<List<Integer>> nums) {

        int k = nums.size();

        PriorityQueue<Pair> min_heap = new PriorityQueue<>(Comparator.comparingInt(a->a.val));

        int[] minRange = { -1000000, 1000000 };
        int maxEle = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {//storing each list's 1st element in the pq

            int ele = nums.get(i).get(0);
            maxEle = Math.max(ele, maxEle);

            min_heap.add(new Pair(ele, 0, i));

        }

        while (!min_heap.isEmpty()) {

            Pair curr = min_heap.poll();

            int minEleListIdx = curr.listIdx;
            int minEleIdx = curr.eleIdx;

            int minEle = curr.val;

            if (maxEle - minEle < minRange[1] - minRange[0]) {
                //update minRange

                minRange[0] = minEle;
                minRange[1] = maxEle;

            }

            //shortening the range by moving minElement index

            int newEleIdx = minEleIdx + 1;
            if (newEleIdx >= nums.get(minEleListIdx).size()) {
                break;
            }

            min_heap.add(new Pair(nums.get(minEleListIdx).get(newEleIdx), newEleIdx, minEleListIdx));

            maxEle = Math.max(maxEle, nums.get(minEleListIdx).get(newEleIdx));

        }

        return minRange;
    }


}
