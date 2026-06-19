package Arrays;

//TC-O(N)
//SC-O(1)
//Key Idea : Calculating maximum prefix sum by iterating through altitude gains.

public class Find_The_Highest_Altitude {

    public static int largestAltitude(int[] gain) {

        int maxAlt = 0;
        int curr = 0;

        for (int g : gain) {
            curr += g;
            maxAlt = Math.max(maxAlt, curr);

        }

        return maxAlt;

    }

    public static void main(String[] args) {

        System.out.println("Highest Altitude is : "+largestAltitude(new int[]{-5,1,5,0,-7}));
    }


}
