package Arrays;

public class Majority {


    public static void main(String[] args) {

        int[] arr={1,1,2,2,2,1,1,2,2};
        System.out.println("1st approach : "+majorityEle1(arr));
        System.out.println("2nd approach : "+majorityEle2(arr));
        System.out.println("3rd approach : "+majorityEle3(arr));


    }

    public static int majorityEle1(int[] arr){
        int n=arr.length;
        if(n==0)return -1;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i;j<n;j++){
                if(arr[i]==arr[j])count++;
            }
            if(count > n/2)return arr[i];

        }
        return -1;
    }


    //2nd Approach
    public static int majorityEle2(int[] arr){
        int n=arr.length;
        if(n == 0)return -1;

        java.util.Arrays.sort(arr);
        return arr[n/2];
    }

    //3rd Approach
    //Moore's Voting Algorithm
    //In case majority element is guaranteed

    public static int majorityEle3(int[] arr){
        int n=arr.length;
        int count=0;
        int candidate=0;
        for(int i=0;i<n;i++){
            if(count==0){
                candidate=arr[i];
                count++;
            }else if(arr[i]==candidate){
                count++;
            }else{
                count--;
            }

        }
        return candidate;
    }

}
