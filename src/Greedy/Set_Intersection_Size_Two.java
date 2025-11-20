package Greedy;

public class Set_Intersection_Size_Two {

    public static void main(String[] args) {

        int[][] intervals={{1,3},{3,7},{8,9}};//answer should be 5

        System.out.println("The minimum possible size of a containing set : "+intersectionSizeTwo(intervals));


    }


    public static int intersectionSizeTwo(int[][] intervals) {

        java.util.Arrays.sort(intervals,(a,b)->{

            if(a[1]==b[1])return b[0]-a[0];
            return a[1]-b[1];
        }); // sort to process intervals greedily

        int ans=0;

        int s1=-1_000_000_000;//(smaller)
        int s2=-1_000_000_000;//(larger)

        for(int[] in:intervals){

            int st=in[0];
            int end=in[1];

            if(s2<st){ //when both s1 and s2 are out of interval
                ans+=2;
                s1=end-1;
                s2=end;

            }else if(s1<st){//one of then (s1) is out of interval

                ans+=1;
                s1=s2;
                s2=end;

            }//last case when both lies inside the interval do nothing


        }

        return ans;

    }



}
