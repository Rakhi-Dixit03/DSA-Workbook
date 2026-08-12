package Sliding_Window;
import java.util.*;

//TC-O(N)
//SC-O(N)

public class Len_Of_Longest_SubArr_With_AtMost_K_Freq {

    public static int maxSubArrayLength(int[] numbers, int k) {

        int n=numbers.length;
        if(n==0 || n==1)return n;

        int l=0;
        int r=0;

        int maxLen = Integer.MIN_VALUE;
        Map<Integer,Integer>map = new HashMap<>();

        while(r<n){

            //add curr element's freq to map
            map.put(numbers[r],map.getOrDefault(numbers[r],0)+1);

            //Invalid Window
            while(map.getOrDefault(numbers[r],0)>k){

                map.put(numbers[l],map.get(numbers[l])-1);
                l++;
            }

            //if  window  becomes valid calculate size and update maxLength

            int currLen = r-l+1;
            maxLen = Math.max(currLen,maxLen);

            r++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3,1,2};
        System.out.println("Length Of Longest SubArray with at most k Frequency : "+maxSubArrayLength(arr,2));
    }

}
