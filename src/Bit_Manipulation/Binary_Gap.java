package Bit_Manipulation;

public class Binary_Gap {

    public static void main(String[] args) {
        System.out.println("Maximum Binary Gap :  "+binaryGap(10));
        System.out.println("Maximum Binary Gap :  "+binaryGap1(10));
    }
    //TC-O(N)
    public static int binaryGap(int n) {

        String binStr = Integer.toBinaryString(n);

        //30 bits are needed to rep. 10^9 integer  value
        int binGap = 0;
        int lastIdx = -1;
        for (int i = binStr.length() - 1; i >= 0; i--) {

            if (binStr.charAt(i) == '1') {

                if (lastIdx == -1) {
                    lastIdx = i;
                } else {

                    int gap = Math.abs(i - lastIdx);
                    binGap = Math.max(binGap, gap);
                    lastIdx = i;

                }

            }
        }
        return binGap;
    }

    //TC-O(1)
    public static int binaryGap1(int n) {


        //30 bits are needed to rep. 10^9 integer  value
        int binGap = 0;
        int lastIdx = -1;
        for (int i = 0; i <31 ; i++) {

            if(((n>>i)&1)==1){//extracting digit at index i from [least significant to most significant]

                if(lastIdx==-1)lastIdx=i;
                int gap = Math.abs(i - lastIdx);
                binGap = Math.max(binGap, gap);
                lastIdx = i;


            }
        }
        return binGap;
    }

}

