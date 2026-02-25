package Bit_Manipulation;

public class Sort_Integers_By_Count_of_1 {

    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,5,6,7,8};

        System.out.println("Sorted Array is : "+java.util.Arrays.toString(sortByBits(arr)));
    }
    public static int[] sortByBits(int[] arr) {

        Integer[] newArray=java.util.Arrays.stream(arr).boxed().toArray(Integer[]::new);//Converting primitive array into Integer[object] Array


        java.util.Arrays.sort(newArray,(a,b)->{//Applying custom Comparator while Sorting

            int count1=Integer.bitCount(a);
            int count2=Integer.bitCount(b);

            if(count1==count2){
                return a-b;
            }
            return count1-count2;

        });
        arr=java.util.Arrays.stream(newArray).mapToInt(i->i).toArray();//Converting back to primitive array
        return arr ;
    }
}
