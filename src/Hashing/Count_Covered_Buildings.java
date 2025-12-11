package Hashing;
import java.util.*;

public class Count_Covered_Buildings {


    public static void main(String[] args) {

        int[][] buildings={{1,2},{2,2},{3,2},{2,1},{2,3}};
        int n=3;

        System.out.println("Count of Covered Buildings is : "+countCoveredBuildings(n,buildings));


    }



    static class Pair{

        int min;
        int max;

        public Pair(){

            min=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;

        }


    }
    public static int countCoveredBuildings(int n, int[][] buildings) {

        int result=0;

        Map<Integer,Pair>xMinMaxY=new HashMap<>();
        Map<Integer,Pair>yMinMaxX=new HashMap<>();

        for(int[] b:buildings){

            int x=b[0];
            int y=b[1];

            if(!xMinMaxY.containsKey(x)){
                xMinMaxY.put(x,new Pair());
            }

            if(!yMinMaxX.containsKey(y)){
                yMinMaxX.put(y,new Pair());
            }

            Pair xMinMax_y = xMinMaxY.get(x);
            Pair yMinMax_x = yMinMaxX.get(y);

            //finding min,max y in a column
            xMinMax_y.min= Math.min(xMinMax_y.min,y);
            xMinMax_y.max= Math.max(xMinMax_y.max,y);

            //finding min,max x in a row
            yMinMax_x.min=Math.min(yMinMax_x.min,x);
            yMinMax_x.max=Math.max(yMinMax_x.max,x);

        }


        for(int[] b:buildings){

            int x=b[0];
            int y=b[1];

            Pair xMinMax_y = xMinMaxY.get(x);
            Pair yMinMax_x = yMinMaxX.get(y);

            if(xMinMax_y.min< y && y < xMinMax_y.max && yMinMax_x.min<x && x < yMinMax_x.max ){
                result++;

            }

        }

        return result;

    }


}
