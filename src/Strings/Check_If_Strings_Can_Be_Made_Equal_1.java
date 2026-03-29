package Strings;
//Ques : 2839
public class Check_If_Strings_Can_Be_Made_Equal_1 {

    public static void main(String[] args) {
        System.out.println("Can we make Strings Equal ? : "+canBeEqual("acbd","bdac"));
    }

   //TC-O(1)
    public static boolean canBeEqual(String s1, String s2) {

        return (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2) ||
                s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0)) &&

                (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3) ||
                        s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
    }


}
