package Strings;

public class Add_Binary {

    //3 important tricky things in  this Question
    //1.Different lengths
    //2.final Carry
    //3.We built result backward - Because we're adding from right to left.

    public static void main(String[] args) {
        System.out.println("Added Binary String is : "+addBinary("101","001"));
    }
    public static String addBinary(String a, String b) {

        StringBuilder ans=new StringBuilder();

        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;

        while(i>=0 || j>=0 || carry!=0 ){//Carry!=0 condition is for the case when there will be a carry left in the ned

            int sum=carry;

            if(i>=0){
                sum+=a.charAt(i--)-'0';
            }

            if(j>=0){
                sum+=b.charAt(j--)-'0';

            }

            ans.append(sum%2);
            carry=sum/2;


        }

        return ans.reverse().toString();
    }

}
