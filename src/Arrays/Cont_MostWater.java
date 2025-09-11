package Arrays;

//Container with most Water
public class Cont_MostWater {

    public static void main(String[] args) {

        int[] height={1,8,6,2,5,4,8,3,7};

        System.out.println("Brute Force Approach Container with most Water is : "+containerMostWater1(height));
        System.out.println("Optimal Approach Container with most Water is : "+containerMostWater2(height));


    }
    //TC-O(N^N)

    public static int containerMostWater1(int[] height){
        int n=height.length;
        int maxWater=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int currWater=Math.min(height[i],height[j])*(j-i);
                maxWater=Math.max(currWater,maxWater);
            }

        }
        return maxWater;
    }

     //TC-O(N)
    public static int containerMostWater2(int[] height){
        int n=height.length;

        int i=0;//Two Pointers
        int j=n-1;
        int maxWater=Integer.MIN_VALUE;

        while(i<j){

            int currWater=Math.min(height[i],height[j])*(j-i);//As we are taking minimum of heights,to maximise water we have to
            //  maximise  minimum element so for that update pointer with smaller height to look for potential larger heights

            maxWater=Math.max(currWater,maxWater);

            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }


}
