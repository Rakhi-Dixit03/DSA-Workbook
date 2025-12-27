package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms3_Google {

    public static void main(String[] args) {

        int[][] meetings={{1,20},{2,10},{3,5},{4,9},{6,8}};
        int n=3;//number of rooms
        System.out.println("Most Used Room is Room number : "+mostBooked(n,meetings));

        System.out.println("Using 2nd Approach,Most Used Room is Room number  : " +mostBooked2(n,meetings));

    }

   //TC-O(M*N)+(MLogM)
    public static int mostBooked(int n, int[][] meetings) {

        //Sort meetings based on start time
        java.util.Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));

        int[] usedCount=new int[n];//this is for used count of rooms
        long[] lastAvailTime=new long[n];//the last time a room will become empty


        for(int[] meet : meetings){

            int start=meet[0];
            int end=meet[1];
            int duration = end-start;
            boolean found=false;

            long minEndTime=Long.MAX_VALUE;//for each meeting, we will find early ending Meeting Time as well as its index
            int minEndRoom=0;//in case there is no empty room available


            //find the first available meeting room for our current meeting
            for(int room=0;room<n;room++){

                if(lastAvailTime[room]<=start){
                    //we can assign meeting to this room
                    lastAvailTime[room]=end;
                    usedCount[room]++;
                    found=true;
                    break;//early exit,we found an empty room

                }

                if(lastAvailTime[room]<minEndTime){
                    minEndTime = lastAvailTime[room];
                    minEndRoom = room;
                }


            }

            if(!found){//we didn't find an empty room

                lastAvailTime[minEndRoom] += duration;
                usedCount[minEndRoom]++;

            }


        }

        //find most used Room
        int maxUsed=0;
        int resultRoom=-1;

        for(int i=0;i<n;i++){

            if(usedCount[i] > maxUsed){
                maxUsed=usedCount[i];
                resultRoom=i;

            }

        }

        return resultRoom;
    }

    //TC-O(M*LogN)+(MLogM)
    public static int mostBooked2(int n, int[][] meetings) {

        //Sort meetings based on start time
        java.util.Arrays.sort(meetings,(Comparator.comparingInt(a->a[0])));

        var meetingsCount=new int[n];//this is for storing how many times a room is used for meeting
        //Storing used room's  meeting's ending time and room number  [meetingEndTime,roomNumber]

        var usedRooms=new PriorityQueue<long[]>((a, b)->a[0]!=b[0]?Long.compare(a[0],b[0]):Long.compare(a[1],b[1]));

        var unusedRooms=new PriorityQueue<Integer>();//By default, min-heap //storing unused rooms

        for(int i=0;i<n;i++){

            unusedRooms.offer(i);//initially all rooms are unused

        }


        for(int[] meet : meetings){

            int start=meet[0];
            int end=meet[1];
            int duration = end-start;

            while(!usedRooms.isEmpty() && usedRooms.peek()[0]<=start){

                int room=(int)usedRooms.peek()[1];//type casting because that was of long type
                usedRooms.poll();
                unusedRooms.offer(room);

            }

            if(!unusedRooms.isEmpty()){

                int room = unusedRooms.poll();

                usedRooms.offer(new long[]{end,room});

                meetingsCount[room]++;

            }else{

                long[] curr =usedRooms.poll();
                assert curr != null;
                int room=(int)curr[1];
                curr[0]+=duration;
                usedRooms.offer(curr);

                meetingsCount[room]++;

            }


        }


        //find most used Room
        int maxUsed=0;
        int resultRoom=-1;

        for(int i=0;i<n;i++){

            if(meetingsCount[i] > maxUsed){
                maxUsed=meetingsCount[i];
                resultRoom=i;

            }

        }

        return resultRoom;
    }

}
