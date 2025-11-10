package Stack_and_Queues;

//LeetCode  3542
public class Min_Ops_ToMake_Array_0 {

    public static void main(String[] args) {

        int[] arr={1,2,1,2,1,2};

        System.out.println("Minimum Operations to amke array elements zero : "+minOperations(arr));


    }

    //If we need to return modified Array we can use Map+stack

    public static  int minOperations(int[] nums) {

        int minOps = 0;

        int[] st = new int[nums.length + 1];

        int top = 0;
        for (int i = 0; i < nums.length; i++) {

            while (st[top] > nums[i]) {//Monotonic increasing Stack
                top--;
                minOps++;

            }

            if (st[top] != nums[i]) {

                st[++top] = nums[i];

            }
        }
        return minOps + top;

    }


}
