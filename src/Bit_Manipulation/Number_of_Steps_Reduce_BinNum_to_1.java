package Bit_Manipulation;
//Good Question 1404
public class Number_of_Steps_Reduce_BinNum_to_1 {

    public static void main(String[] args) {
        Number_of_Steps_Reduce_BinNum_to_1 obj=new Number_of_Steps_Reduce_BinNum_to_1();

        System.out.println("Number of steps needed to reduce the number in binary representation to 1 : "+obj.numSteps("10101"));
    }
    StringBuilder str;
    public int numSteps(String s) {

        str=new StringBuilder(s);
        int steps=0;

        for(int i=str.length()-1;i>=1;i--){
            //if 1 means odd num
            //Add 1 to it
            if(str.charAt(i)=='1'){

                addOne();
                //reset i=lastIndex
                i=str.length();//[flow understanding helped me to debug]

            }else{//even number ,divide it by 2,basically remove last element from the string

                str.deleteCharAt(str.length()-1);

            }
            steps++;

        }

        return steps;
    }

    private void addOne(){
        int firstZero=-1;
        for(int i=str.length()-1;i>=0;i--){

            if(str.charAt(i)=='0'){
                firstZero=i;
                break;
            }

            str.setCharAt(i,'0');

        }

        if(firstZero==-1){//we didn't find an index where there is a zero char
            StringBuilder newStr=new StringBuilder("1");

            newStr.append(str);
            str=newStr;

        }else{

            str.setCharAt(firstZero,'1');

        }

    }

}
