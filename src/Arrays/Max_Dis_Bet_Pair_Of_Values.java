package Arrays;
//Ques : 1855
//Approach : Leveraging sorted properties to advance pointers greedily, maximizing distance without checking all pairs.
//O(M+N)
public class Max_Dis_Bet_Pair_Of_Values {

    public static void main(String[] args) {
        System.out.println("Maximum Distance Between Pair of values  : "+maxDistance(new int[]{55,30,5,4,2},
                new int[]{100,20,20,20,5}));
    }
    public static int maxDistance(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int maxDis = 0;
        int i, j;
        i = j = 0;

        while (i < m && j < n) {

            if (nums1[i] > nums2[j]) {
                i++;
            } else {

                maxDis = Math.max(maxDis, j - i);
                j++;
            }
        }

        return maxDis;

    }



}
