package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Find_All_People_With_Secret {


    public static void main(String[] args) {

        int n=6;
        int firstPer=1;
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}};

        System.out.println("All People with Secret :  "+findAllPeople(n,meetings,firstPer));

    }

   static class Pair{

        int person;
        int time;

        public Pair(int p,int t){

            person=p;
            time=t;

        }

    }

        public  static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

            @SuppressWarnings("unchecked")
            ArrayList<Pair>[] graph = new ArrayList[n];

            for(int i=0;i<graph.length;i++){

                graph[i] = new ArrayList<>();

            }

            for(int[] m : meetings){

                int per1 = m[0];
                int per2 = m[1];
                int t = m[2];

                graph[per1].add(new Pair(per2,t));
                graph[per2].add(new Pair(per1,t));

            }

            int[] timeOfSecret = new int[n];

            java.util.Arrays.fill(timeOfSecret,Integer.MAX_VALUE);

            timeOfSecret[0]=0;
            timeOfSecret[firstPerson]=0;

            PriorityQueue<Pair>q = new PriorityQueue<>(Comparator.comparingInt(a->a.time));

            q.add(new Pair(0,0));
            q.add(new Pair(firstPerson,0));


            while(!q.isEmpty()){

                Pair curr = q.poll();

                int currPer = curr.person;
                int time = curr.time;

                if(time > timeOfSecret[currPer])continue;

                for(Pair neigh : graph[currPer]){

                    int nextPer = neigh.person;
                    int t = neigh.time;

                    if(t>= time && t < timeOfSecret[nextPer]){

                        timeOfSecret[nextPer] = t;
                        q.add(new Pair(nextPer,t));
                    }


                }

            }

            List<Integer> ans = new ArrayList<>();

            for(int i=0;i<timeOfSecret.length;i++){

                if(timeOfSecret[i]!=Integer.MAX_VALUE){

                    ans.add(i);

                }

            }

            return ans;

        }
    }


