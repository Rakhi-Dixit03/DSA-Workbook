package Arrays;

import java.util.HashSet;

//Repeating and Missing Number
public class RepeatAndMiss {

    public static void main(String[] args) {

        int[] arr={1,3,4,2,4};
        int n=5;//Integer range from 1-N

        int[] ans1=repeatAndMissing1(arr);
        int[] ans2=repeatAndMissing2(arr,n);


        System.out.println("1st Approach : "+"Repeated Number : "+ans1[0]+" Missing Number is : "+ans1[1]);
        System.out.println("2nd Approach : "+"Repeated Number : "+ans2[0]+" Missing Number is : "+ans2[1]);


    }

    //1st
    public static int[] repeatAndMissing1(int[] arr){
        int n=arr.length;
        int[] ans=new int[2];
        int[] count=new int[n+1];//Frequency Array

        for(int ele:arr){
            count[ele]++;
        }

        for(int c=0;c<count.length;c++){

            if(count[c]==2)ans[0]=c;
            if(count[c]==0)ans[1]=c;

        }

      return ans;
    }

    //2nd Solution

    public static int[] repeatAndMissing2(int[] arr,int n){

        HashSet<Integer>set =new HashSet<>();

        int[] ans=new int[2];

        for(int i=0;i<arr.length;i++){
            if(!set.add(arr[i])){
                ans[0]=arr[i];
            }

            }

            for(int i=1;i<=n;i++){
                if(!set.contains(i)){
                    ans[1]=i;
                }

            }
           return ans;
    }

}
