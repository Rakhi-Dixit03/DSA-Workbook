package Strings;

public class String_Int_Questions {

    public static void main(String[] args) {

        System.out.println("Reversed String is : "+reverseStr("my name is rakhi"));
        System.out.println("String after Reversing vowels is :  "+reverseVowels("I LOVE JAVA"));

    }

    //Reversing Vowels in a String

    public static String reverseVowels(String s){


        char[] arr= s.toCharArray();//converting it to char array for easier manipulation

        int i=0;
        int j=arr.length-1;
        int n= arr.length;

        while(i<j){

            while(i<n && !isVowel(arr[i]))i++;

            while(j>=0 && !isVowel(arr[j]))j--;

            //swap chars at (i,j)
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;

        }

        return new String(arr);
    }

    public static boolean isVowel(char ch){

        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }

    //Reverse String
    //my name is rakhi  to ym eman si ihkar means reversing string word by word
    //Since all major steps take time proportional to the total number of characters (N),
    // the overall time complexity remains efficient at O(N).

    public static String reverseStr(String s){

        String[] arr=s.split(" ");

        StringBuilder sb=new StringBuilder();
        for(String str:arr){

            sb.append(reverse(str)).append(" ");

        }

        return sb.toString();

    }


    public static String reverse(String s){

        StringBuilder sb=new StringBuilder();

        for(int i=s.length()-1;i>=0;i--){

            sb.append(s.charAt(i));

        }

        return sb.toString();
    }


}
