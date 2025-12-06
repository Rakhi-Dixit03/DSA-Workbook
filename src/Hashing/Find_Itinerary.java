package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Find_Itinerary {

    public static void main(String[] args) {

        String[][] stations={{"Chennai","Bengaluru"},{"Goa","Chennai"},{"Delhi","Goa"},{"Mumbai","Delhi"}};

        findItinerary(stations);


    }

    public static void findItinerary(String[][] stations){

        //Map From-To
        Map<String,String> map=new HashMap<>();//Storing Source-Destination
        Set<String> set=new HashSet<>();//Storing Destinations only

        //Building map and set
        for(String[] station:stations){

            map.put(station[0],station[1]);
            set.add(station[1]);
        }

        //finding source, if any station which is not in destination set that will be our source
         String source=null;

        for(String[] station:stations){

            if(!set.contains(station[0])){
                source=station[0];

            }

        }

        System.out.print(source+"->");
        //Starting our journey from the identified source

        for(int i=0;i< set.size();i++){

            if(i== set.size()-1){

                System.out.print(map.get(source));

            }else{

                System.out.print(map.get(source)+"->");
            }

            source=map.get(source);
        }


    }


}
