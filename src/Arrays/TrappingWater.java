package Arrays;

public class TrappingWater {
    public static void main(String[] args) {

        int[] height={4,2,0,3,2,5};
        System.out.println("Trapped Water using 1st Approach : "+trappedWater1(height));
        System.out.println("Trapped Water using 2nd Approach : "+trappedWater2(height));

    }


    //1st Approach TC-O(N) SC-O(N)
    public static int trappedWater1(int[] height){
        int n=height.length;

        int[] leftMax=new int[n];
        int[] rightMax=new int[n];

        leftMax[0]=height[0];
        //Building leftMax array
        for(int i=1;i<n;i++){

            leftMax[i]=Math.max(leftMax[i-1],height[i]);

        }

        rightMax[n-1]=height[n-1];
        //Building rightMax array
        for(int i=n-2;i>=0;i--){

            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }


        int trappedWater=0;

        for(int i=0;i<n;i++){

            trappedWater+=Math.min(leftMax[i],rightMax[i])-height[i];
        }

        return trappedWater;
    }


    //2nd Approach TC-O(N) SC-O(1) Two Pointers
    public static int trappedWater2(int[] height){
        int n=height.length;
        int trappedWater=0;

        int l = 0, r = n - 1;
        int lMax = height[l];
        int rMax = height[r];

        //Smallest height will decide how much water is trapped

        while(l<r){

            if(height[l]<=height[r]){

                l++;
                lMax=Math.max(lMax,height[l]);
                trappedWater+=lMax-height[l];

            }else{
                r--;
                rMax=Math.max(rMax,height[r]);
                trappedWater+=rMax-height[r];

            }
        }
        return trappedWater;
    }

}
