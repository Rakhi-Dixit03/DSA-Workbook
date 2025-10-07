package Recursion_BackTracking;

public class BasicQuestions {

    public static void main(String[] args) {
        int[] arr={1,3,4,5,2,5,4,2,3,2,2};
        printAllOccur(arr,0,2);
        printDigits(145);
        System.out.println();
        System.out.println("Length of string is : "+length("Maya"));
        System.out.println("Total ways to pair friends are : "+friendsPair(3));

    }

    public static void printAllOccur(int[] arr,int i,int key){

        if(i==arr.length)return;

        if(arr[i]==key){
            System.out.println("Found at index : "+i);

        }
        printAllOccur(arr,i+1,key);


    }

    static String[] digits={"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void printDigits(int n){

        if(n==0)return;

        int lastDigit=n%10;
        printDigits(n/10);
        System.out.print(digits[lastDigit]+" ");


    }


    public static int length(String s){

        if(s.isEmpty())return 0;

        return length(s.substring(1))+1;

    }

    public static int friendsPair(int n){
        //Base case
        if(n==1 || n==2)return n;

        return friendsPair(n-1)+(n-1)*friendsPair(n-2);


    }


}
