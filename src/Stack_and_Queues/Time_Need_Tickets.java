package Stack_and_Queues;

import java.util.LinkedList;

public class Time_Need_Tickets {

    public static void main(String[] args) {

        int[] tickets={2,4,2};//I got the mistake ,As I was passing the same array so in the second call the modified array is passed
        int[] tickets2={2,4,2};
        int[] tickets3={2,4,2};
        System.out.println(timeNeededTicket1(tickets,2));
        System.out.println(timeNeededTicket2(tickets2,2));
        System.out.println(timeNeededTicket3(tickets3,2));


    }

// TC-O(N*M),SC-O(N)
    public static int timeNeededTicket1(int[] tickets,int k){

         int time =0;

         if(tickets[k]==1)return k+1;

         java.util.Queue<Integer>q=new LinkedList<>();

         for(int i=0;i<tickets.length;i++){
             q.add(i);
         }

         while(!q.isEmpty()){

             int currIdx=q.poll();

             if(tickets[currIdx]!=0){

                 tickets[currIdx]--;
                 time++;
             }

             if(tickets[currIdx]!=0)q.add(currIdx);

             if(tickets[k]==0)return time;


         }
         return time;

    }

    //TC-O(N*M),SC-O(1)
    public static int timeNeededTicket2(int[] tickets,int k){

        if (tickets[k] == 1)
            return k + 1;

        int time = 0;
        //Array Approach

        while(tickets[k]>0){

            for(int i=0;i<tickets.length;i++){

                if(tickets[i]!=0){//important check
                    tickets[i]--;
                    time++;
                }

                if(tickets[k]==0)return time;
            }
        }

        return time;
    }

    //Optimised Approach TC-O(N),SC-O(1)

    public static int timeNeededTicket3(int[] tickets,int k){

        int time=0;

        for(int i=0;i<tickets.length;i++){

            if(i<=k){
                time+=Math.min(tickets[i],tickets[k]);

            }else{

                time+=Math.min(tickets[i],tickets[k]-1);
            }

        }

        return time;
    }

}
