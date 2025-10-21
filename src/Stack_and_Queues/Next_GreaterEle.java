package Stack_and_Queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_GreaterEle {

    public static void main(String[] args) {

        int[] nums1={4,3,1};
        int[] nums2={1,2,3,4,-2,9};

        System.out.println(java.util.Arrays.toString(nextGreaterEle(nums1,nums2)));

    }

    public static int[] nextGreaterEle(int[] nums1,int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        java.util.Stack<Integer> st =new Stack<>();


        for (int i = 0; i < nums2.length; i++) {

            while ((!st.isEmpty()) && (st.peek() < nums2[i])) {

                map.put(st.peek(), nums2[i]);
                st.pop();

            }

            st.push(nums2[i]);


        }

        for (int i = 0; i < nums1.length; i++) {

            nums1[i] = map.getOrDefault(nums1[i], -1);

        }

        return nums1;

    }
}

