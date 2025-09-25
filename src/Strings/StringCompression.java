package Strings;

public class StringCompression {

    public static void main(String[] args) {
        char[] arr={'a','a','b','c','c','c','c','c','c'};
        System.out.println("String after Compression : "+stringCompression(arr));

    }


    public static String stringCompression(char[] chars){

        int idx=0;//Tracking position to store next character

        for(int i=0;i<chars.length;i++ ){

            int count=1;
            while(i<chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;

            }
            chars[idx]=chars[i];
            idx++;

            if(count>1){

                if(count>=10){

                    String num=String.valueOf(count);

                    for(char ch : num.toCharArray()){
                        chars[idx]=ch;
                        idx++;
                    }
                }else{
                    chars[idx]=Integer.toString(count).charAt(0);
                    idx++;

                }
            }

        }

        return new String(chars,0,idx);

    }


}
