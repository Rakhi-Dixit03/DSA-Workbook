package maths_problems;

public class Angle_Between_Clock_Hands {

    public static double angleClock(int hour, int minutes) {

        if(hour==12){
            hour%=12;
        }

        double hour_Angle = (hour*30 + (0.5*minutes));
        double min_Angle = minutes*6.0;
        double diff=Math.abs(hour_Angle - min_Angle);

        return Math.min(diff,360.0-diff);

    }

    public static void main(String[] args) {

        System.out.println("Angle Between Clock Hands is : "+angleClock(12,30));
    }


}
