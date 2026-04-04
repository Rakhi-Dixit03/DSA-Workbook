package Strings;

public class Decode_the_Slanted_Cipher_Text {

    public static void main(String[] args) {

        System.out.println("Decoded Cipher Text : "+decodeCiphertext("ch   ie   pr",3));
        System.out.println("Decoded Cipher Text : "+decodeCiphertext2("iveo    eed   l te   olc",4));
    }
    //TC-O(rows*cols)
    public static String decodeCiphertext(String encodedText, int rows) {

        int cols = encodedText.length() / rows;
        char[][] mat = new char[rows][cols];

        int charIdx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = encodedText.charAt(charIdx);
                charIdx++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < cols; j++) {

            int col = j;
            int i = 0;

            while (i < rows && col < cols) {
                sb.append(mat[i][col]);
                col++;
                i++;
            }

        }

        return sb.toString().stripTrailing();
    }

    //TC-O(N) N-Length of encodedText
    public static String decodeCiphertext2(String encodedText, int rows) {

        int cols = encodedText.length() / rows;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < cols; j++) {

            for (int i = j; i < encodedText.length(); i+=(cols+1)) {

                sb.append(encodedText.charAt(i));

            }
        }


        return sb.toString().stripTrailing();
    }

}
