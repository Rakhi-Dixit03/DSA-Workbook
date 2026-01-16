package Arrays;
import java.util.*;

public class Max_Sq_Area_Removing_Fences {

    public static void main(String[] args) {

        int[] hFences={2,3};
        int[] vFences={2};

        System.out.println("Maximum Square Area : "+maximizeSquareArea(4,3,hFences,vFences));


    }

        public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

            Set<Integer>hSet=getEdges(hFences,m);
            Set<Integer>vSet=getEdges(vFences,n);
            long res=0;

            for(int ele: hSet){

                if(vSet.contains(ele)){
                    res=Math.max(res,ele);
                }

            }

            return res==0?-1:(int)((res*res)%1000000007);

        }

        private static Set<Integer> getEdges(int[] fences,int border ){

            List<Integer>list=new ArrayList<>();
            Set<Integer>set=new HashSet<>();

            for(int f:fences){
                list.add(f);
            }

            list.add(1);
            list.add(border);

            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    set.add(Math.abs(list.get(j)-list.get(i)));
                }
            }

            return set;
        }
    }
