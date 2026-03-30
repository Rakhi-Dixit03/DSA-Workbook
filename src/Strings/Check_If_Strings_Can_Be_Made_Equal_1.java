package Strings;
//Ques : 2839
public class Check_If_Strings_Can_Be_Made_Equal_1 {

    public static void main(String[] args) {
        System.out.println("Can we make Strings Equal ? : "+canBeEqual1("acbd","bdac"));
        System.out.println("Can we make Strings Equal ? : "+canBeEqual2("acbd","bdac"));
    }

   //TC-O(1)
    public static boolean canBeEqual1(String s1, String s2) {

        return (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2) ||
                s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0)) &&

                (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3) ||
                        s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
    }

    //TC-O(N)
    //Part-2 Ques: 2840
    public static boolean canBeEqual2(String s1, String s2) {
        int n=s1.length();
        int[] even=new int[26];
        int[] odd=new int[26];

        for(int i=0;i<n;i++){

            if(i%2==0){
                even[s1.charAt(i)-'a']++;
                even[s2.charAt(i)-'a']--;

            }else{
                odd[s1.charAt(i)-'a']++;
                odd[s2.charAt(i)-'a']--;
            }
        }

        for(int i=0;i<26;i++){
            if(even[i]!=0 || odd[i]!=0){
                return false;
            }
        }

        return true;
    }

}
