package Arrays;

public class Min_Time_Visiting_All_Points {

    public static void main(String[] args) {

        int[][] points ={{1,1},{3,4},{-1,0}};//we will visit all points in order
        System.out.println("Minimum Time to visit all points : "+minTimeToVisitAllPoints(points));


    }
    //Can have a follow-up : what if we can visit all points in any order ?
    public static int minTimeToVisitAllPoints(int[][] points) {

        int ans=0;
        int n=points.length;

        for(int i=0;i<n-1;i++){

            int currX = points[i][0];
            int currY = points[i][1];

            int tarX = points[i+1][0];
            int tarY = points[i+1][1];

            int xDiff=Math.abs(currX-tarX);
            int yDiff=Math.abs(currY-tarY);

            ans+=Math.max(xDiff,yDiff);


        }
        return ans;
    }


}
