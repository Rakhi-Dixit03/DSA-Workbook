package Recursion_BackTracking;

public class Tower_Of_Hanoi {

    public static void main(String[] args) {

        towerOfHanoi(3,'A','B','C');
    }

    public static void towerOfHanoi(int n,char src,char help,char dest){

        //Base case
        if(n==1){
            System.out.println("Move disk "+n + " from "+src +" to "+dest);
            return;
        }

        towerOfHanoi(n-1,src,dest,help);
        System.out.println("Move disk "+n + " from "+src +" to "+dest);
        towerOfHanoi(n-1,help,src,dest);



    }

}
