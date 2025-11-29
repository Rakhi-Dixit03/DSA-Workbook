package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Nearby_Cars {
    //k Nearby Cars from origin in a 2D plane
//It can be in the form of nearby restaurants,nearby horses or like that

    static class Car{

        int x;
        int y;
        int idx;
        int dist;

        public Car(int x, int y,int idx, int dist) {
            this.x = x;
            this.y = y;
            this.idx=idx;
            this.dist = dist;
        }
    }


    public static void main(String[] args) {

        int[][] cars={{3,3},{5,-1},{-2,4}};
        int k=2;
        nearByCars(cars,k);


    }


    public static void nearByCars(int[][] cars,int k){

        PriorityQueue<Car>pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        for(int i=0;i< cars.length;i++){

            int dist=cars[i][0]*cars[i][0] + cars[i][1]*cars[i][1];
            pq.add(new Car(cars[i][0],cars[i][1],i,dist));


        }

        System.out.println("K nearest cars are : ");
        for(int i=0;i<k;i++){

            System.out.println("C"+pq.remove().idx);

        }

    }

}
