package Greedy;

//Minimum Time to make rope Colorful  -1578

public class Minimum_Time_Colorful {


    public static void main(String[] args) {

        String colors="aabaa";
        int[] neededTime={1,2,3,4,1};

        System.out.println("Minimum Time Needed to Make Rope Colorful is : "+minCost(colors,neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {

        int time =0;
        int prevMax=0;


        for(int i=0;i<colors.length();i++){

            int curr=neededTime[i];

            if(i>0 && (colors.charAt(i)!=colors.charAt(i-1))){
                prevMax=0;
            }


            time+=Math.min(prevMax,curr);
            prevMax=Math.max(prevMax,curr);

        }

        return time;

    }


}
