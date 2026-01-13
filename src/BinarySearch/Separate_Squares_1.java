package BinarySearch;

public class Separate_Squares_1 {

    public static void main(String[] args) {

        int[][] squares={{0,0,2},{1,1,1}};
        System.out.println("Minimum Value of y_coordinate such that we can draw a horizontal line which" +
                " separates area of square in equal parts  : "+separateSquares(squares));

    }



    //Take Away :
    // Casting after multiplication does NOT prevent overflow
    //You must cast before multiplying.

    public static double separateSquares(int[][] squares) {

        double hi=0;
        double low=2e9;

        double total=0;

        for(int[] square:squares){

            int y=square[1];
            int l=square[2];

            total+=((double)l*l);//Area of each square
            hi=Math.max(hi,(double)y+l);
            low=Math.min(low,y);

        }

        //Binary Search on Answer

        //   double result = 0.000;
        while(Math.abs(hi-low)>1e-5){

            double mid_y =low + (hi-low)/2.0;

            if(checkIfPossible(squares,mid_y,total)){

                hi=mid_y;

            }else{

                low=mid_y;
            }

        }

        return hi;
    }

    private static boolean checkIfPossible(int[][] squares,double mid_y,double total ){

        double bottomArea=0;

        for(int[] square : squares){

            int l=square[2];
            int top_y=square[1]+l;
            int bottom_y=square[1];

            if(mid_y>top_y){

                bottomArea+=((double)l*l);

            }else if(mid_y>bottom_y){

                bottomArea+=((mid_y-bottom_y)*l);
            }

        }

        return bottomArea>=total/2;

    }

}
