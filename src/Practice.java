import java.util.*;

public class Practice {

    public static void main(String[] args) {


        PriorityQueue<Student>pq=new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("Rohit",18,1));
        pq.add(new Student("Mohit",16,2));
        pq.add(new Student("Anya",17,3));
        pq.add(new Student("Maya",20,4));


        while(!pq.isEmpty()){

            System.out.println("Student Name : "+pq.peek().name +", Student Age -> "+pq.peek().age);
            pq.remove();

        }





//        TreeAncestor obj=new TreeAncestor(7,new int[]{-1, 0, 0, 1, 1, 2, 2});
//
//        System.out.println(obj.getKthAncestor(3,1));
//        System.out.println(obj.getKthAncestor(5,2));
//        System.out.println(obj.getKthAncestor(5,4));

//        System.out.println("Majority element in the array is : "+majorityEle(new int[]{3,2,3,4,2,3,3}));
//        System.out.println("Maximum Profit By buying and selling stocks : "+buyAnsSell(new int[]{7,1,5,6,3,4}));
//        System.out.println("Maximum SubArray sum : "+ maxSubArrSum(new int[]{0,1,-5,-2,4,3}));

//        majorityElement(new int[]{3,2,3,4,2,3,3,3});
//        System.out.println();
//        System.out.println("Are earth and heart anagrams of each other : "+anagramCheck("earth","heart"));

//        System.out.println("Count of SubArrays whose sum Equals k is  :  "+subArraySumEqualsK(new int[]{10,2,-2,-20,10},-10));

        System.out.println("Two elements that Sum equal to target : "+ Arrays.toString(twoSum(new int[]{2,3,5,7,1},9)));


    }

    static class TreeAncestor {

        int[][] dp;

        public TreeAncestor(int n, int[] parent) {

            dp=new int[16][n];//16 will cover k's constraint of  10^4 and n is for n nodes

            dp[0]=parent;

            for(int i=1;i<16;i++){

                for(int j=0;j<n;j++){

                    if(dp[i-1][j]==-1)dp[i][j]=-1;
                    else dp[i][j]=dp[i-1][dp[i-1][j]];


                }

            }

        }

        public int getKthAncestor(int node, int k) {

            for(int i=0;i<16;i++){

                if(node==-1)return -1;
                if(((1<<i)&k)!=0){

                    node=dp[i][node];

                }

            }

           return node;
        }

    }

    private static int majorityEle(int[] arr){

        int count=0;
        int candidate=0;//Assuming there will always be a majority element in the array


        for(int n:arr){

            if(count==0){

                candidate=n;
                count++;

            }else if(n==candidate){

                count++;

            }else{

                count--;
            }


        }

        return candidate;
    }


   static int buyAnsSell(int[] prices){

        int buyP=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int price:prices){

            if(price<buyP){

                buyP=price;

            }else{

               maxProfit= Math.max(maxProfit,price-buyP);

            }


        }

        return maxProfit;
    }


   //Kadane's Algo

    static int maxSubArrSum(int[] arr){

        int currSum=0;
        int maxSum=0;

        for(int ele:arr ){

          currSum= Math.max(ele,currSum+ele);
          maxSum=Math.max(currSum,maxSum);

        }

        return maxSum;
    }



    static class Student implements Comparable<Student>{

        String name;
        int age;
        int rollNo;

        public Student(String name, int age, int rollNo) {
            this.name = name;
            this.age = age;
            this.rollNo = rollNo;
        }


     public int compareTo(Student s2){

            return this.age- s2.age;//sorting basis of age

     }

    }


    public static void majorityElement(int[] arr){

        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:arr){

            map.put(num,map.getOrDefault(num,0)+1);
        }

        System.out.print("Majority Element is :  ");

        for(int key:map.keySet()){

            if(map.get(key)>n/2){

                System.out.print(key+" ");

            }

        }

    }


    //Checking if two Strings are Anagram  or not

    public static boolean anagramCheck(String s,String t){

        if(s.length()!=t.length())return false;

        Map<Character,Integer>map=new HashMap<>();//character + its frequency

        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }

        for(int i=0;i<t.length();i++){

            char ch=t.charAt(i);

            if(map.get(ch)!=null){

                if(map.get(ch)==1){
                    map.remove(ch);
                }else{

                    map.put(ch,map.get(ch)-1);

                }

            }else{
                return false;
            }

        }

        return true;
    }


   //Number of SubArrays sum equals k

    public static int subArraySumEqualsK(int[] arr,int k){

        int preSum=0;
        int ans=0;
        Map<Integer,Integer>map=new HashMap<>();//prefixSum,count
        map.put(0,1);//for the case when subArray starts from 0th index

        for(int n:arr){

            preSum+=n;

            if(map.containsKey(preSum-k)){

                ans+=map.get(preSum-k);
            }

            map.put(preSum, map.getOrDefault(preSum,0)+1);

        }

        return ans;
    }


    public static int[] twoSum(int[] arr,int tar){

        Map<Integer,Integer>map=new HashMap<>();//element,index

        for(int i=0;i<arr.length;i++){

            int complement=tar-arr[i];

            if(map.containsKey(complement)){

                return new int[]{map.get(complement),i};
            }

            map.put(arr[i],i);

        }

        return new int[]{-1,-1};
    }


    public static int dietPerformance(int[] cal,int k,int lower,int upper){

        int points=0;
        int n=cal.length;

        int st=0;
        int end=0;
        int tCal=0;

        while(end<n){

            //1. Add all cal from start to end
            //or 2. calculate it during the window shifting
            tCal+=cal[end];
            //Valid window

            if((end-st+1)==k){


                if(tCal<lower){

                }


            }
        }


       return  points;

    }

//Return max average int the subArray of size K
    //Sliding window Maximum //could be solved through other techniques that's why marked hard

}




/// Binary Search


class Solution {

    public int missingElement(int[] nums, int k) {

        int n = nums.length;

        if (k > countMissingBeforeIndex(nums, n - 1)) {

            return nums[n - 1] + k - countMissingBeforeIndex(nums, n - 1);
        }

        // Binary search to find the first index where missing count >= k


        int left = 0;
        int right = n - 1;
        int firstTrueIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (countMissingBeforeIndex(nums, mid) >= k) {
                // Feasible: this index has at least k missing numbers before it
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                // Not feasible: need more missing numbers, search right
                left = mid + 1;
            }
        }


        return nums[firstTrueIndex - 1] + k - countMissingBeforeIndex(nums, firstTrueIndex - 1);
    }


    private int countMissingBeforeIndex(int[] nums, int i) {

        // Total range from nums[0] to nums[i] is (nums[i] - nums[0])
        // Actual elements present in this range is (i + 1) including both endpoints
        // So missing elements = total range - actual elements present

        return nums[i] - nums[0] - i;
    }
}



