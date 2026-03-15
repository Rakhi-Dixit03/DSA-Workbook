package maths_problems;

import java.util.ArrayList;

public class Fancy_Seq {
    //Approach - Simple maths + Binary Exponentiation and Fermat's Little Theorem
    //T.C : O(log(M)) for Binary Exponentiation power(mult, M-2)
    //S.C : O(1)


    static final long M = 1000000000 + 7;
    ArrayList<Long> seq;
    long add = 0;
    long mul = 1;

    public Fancy_Seq() {

        seq = new ArrayList<>();

    }

    public long binExpo(long a, long n) {

        long result = 1;
        long base = a;
        while (n > 0) {

            if ((n & 1) == 1) {//set bit
                result = (result * base) % M;
            }
            base = (base * base) % M;
            n >>= 1;
        }

        return result;
    }

    public void append(int val) {
        long newVal = ((val - add) % M + M) * binExpo(mul, M - 2) % M;
        seq.add(newVal);
    }

    public void addAll(int inc) {
        add = (add + inc) % M;
    }

    public void multAll(int m) {
        add = (add * m) % M;
        mul = (mul * m) % M;
    }

    public int getIndex(int idx) {

        if (idx >= seq.size()) {
            return -1;
        }
        return (int) ((seq.get(idx) * mul + add) % M);

        // return (int)((x*mul+add)%M);
    }

    public static void main(String[] args) {

        Fancy_Seq seq=new Fancy_Seq();

        seq.append(2);
        seq.addAll(2);
        seq.multAll(3);
        System.out.println("value is : "+seq.getIndex(3));
        seq.append(5);
        seq.multAll(2);
        System.out.println("value is : "+seq.getIndex(1));
    }
}


