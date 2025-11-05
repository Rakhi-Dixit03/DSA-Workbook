package Arrays;

import java.util.*;

public class TopX_Sum_Of_KSubArrays {


    public static void main(String[] args) {

        int[] nums={1,1,2,2,3,4,2,3};

        TopX_Sum_Of_KSubArrays obj=new TopX_Sum_Of_KSubArrays();

        System.out.println(Arrays.toString(obj.findXSum(nums,6,2)));


    }


    long sum = 0;//Maintains sum of top x elements from main set
    Map<Integer, Integer> map;//Storing Freq and element
    TreeSet<int[]> main;//Top x freq and element
    TreeSet<int[]> sec;//contains remaining freq and elements

    public long[] findXSum(int[] nums, int k, int x) {

        int n=nums.length;

        map=new HashMap<>();

        Comparator<int[]> comp=(a, b)->{

            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);

            return Integer.compare(a[1],b[1]);
        };

        main=new TreeSet<>(comp);
        sec=new TreeSet<>(comp);

        List<Long> ans=new ArrayList<>();

        int i=0;
        int j=0;

        while(j<n){

            int num=nums[j];

            //Element already in the map
            if(map.getOrDefault(num,0)>0){

                removeFromSet(new int[]{map.get(num),num},x);

            }

            //Increase frequency

            map.put(num,map.getOrDefault(num,0)+1);

            //Insert updated pair in the set

            insertToSet(new int[]{map.get(num),num},x);

            //if window size becomes equal to k
            if(j-i+1==k){

                ans.add(sum);

                //Remove the outGoing element /shrinking the window

                int outNum=nums[i];

                removeFromSet(new int[]{map.get(outNum),outNum},x);

                map.put(outNum,map.get(outNum)-1);

                if(map.get(outNum)==0){
                    map.remove(outNum);
                }else{

                    insertToSet(new int[]{map.get(outNum),outNum},x);
                }

                i++;

            }

            j++;
        }


        //Covert List<Long> to long[]

        long[] answer=new long[ans.size()];

        for(int idx=0;idx<ans.size();idx++){

            answer[idx]=ans.get(idx);

        }

        return answer;
    }

    void insertToSet(int[] p,int x){

        if(main.size()<x || comparePairs(p,main.first())>0){

            sum+= (long) p[0] * p[1];

            main.add(p);

            if(main.size()>x){

                int[] smallest = main.first();

                sum-=(long) smallest[0]*smallest[1];

                main.remove(smallest);

                sec.add(smallest);

            }

        }else{
            sec.add(p);
        }
    }

    void removeFromSet(int[] p, int x) {

        if (main.contains(p)) {

            sum -= (long) p[0] * p[1];

            main.remove(p);

            //Maintaining the size of main

            if(!sec.isEmpty()){

                int[] largest = sec.last();

                sec.remove(largest);
                main.add(largest);
                sum += (long) largest[0] * largest[1];
            }

        } else {

            sec.remove(p);
        }

    }
    //For Comparison of two Pairs

    int comparePairs(int[] a,int[] b){

        if(a[0]!=b[0])return Integer.compare(a[0],b[0]);

        return Integer.compare(a[1],b[1]);

    }



}
