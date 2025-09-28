package Strings;

public class Rabin_Karp_Algo {

    public static void main(String[] args){

        rabinKarpAlgo("AABAACAADAABAABA","AABA");


    }

    public static void rabinKarpAlgo(String txt, String pat) {

        int m = pat.length();//length of pattern
        int n = txt.length();//length of text

        int d = 256;//Alphabet size
        int q = 101;//Modulo to avoid overflow

        int p = 0;//store hash for pattern
        int t = 0;//store hash for text

        int h = 1; //This is going to store precomputed value for rolling hash

        //Compute h ,calculating d^m-1 % q

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;

        }


        //Compute Hashes for pattern and for substring of txt of size m using Horner's Rule

        for (int i = 0; i < m; i++) {

            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }


        for (int i = 0; i <= n - m; i++) {

            if (p == t) {

                //check each character
                int j;

                for (j = 0; j < m; j++) {

                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                if (j == m) {
                    System.out.println("Pattern found at index : " + i);
                }

            }
            //Compute hash for the next window

            if (i < n - m) {

                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

            }

            if (t < 0) t = t + q;//handling negative values


        }

    }

}
