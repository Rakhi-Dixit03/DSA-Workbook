package Greedy;

public class Min_Boats_To_Save_People {

    public static void main(String[] args) {

        System.out.println("Minimum Boats to save People : "+numRescueBoats(new int[]{3,2,2,1},3));

    }


    public static int numRescueBoats(int[] people, int limit) {

        int boats=0;

        int l=0;
        int r=people.length-1;

        java.util.Arrays.sort(people);//Sorting is required
        //we will form pairs and to take informed decision which people we can take in a pair we have sorted our input

        while(l<=r){

            if(people[l]+people[r]<=limit){//means it is possible to carry two people  in one boat
                l++;


            }//if not possible then we will need a boat for single heavy weight person
            r--;//Heavy Person always boards
            boats++;

        }

        return boats;
    }




}
