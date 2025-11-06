package Graph;

import java.util.*;

//Problem number 3607
public class Power_Grid {

    public static void main(String[] args) {

        Power_Grid pg=new Power_Grid();
        int[][] conn={{1,2},{2,3},{3,4},{4,5}};
        int[][] queries={{1,3},{2,1},{1,1},{2,2},{1,2}};

        System.out.println(Arrays.toString(pg.processQueries(5,conn,queries)));


    }

        static class DSU{

            int[] par;
            int[] size;

            public DSU(int n){

                par=new int[n+1];//1-based indexing
                size=new int[n+1];

                //initialising

                for(int i=0;i<=n;i++){
                    par[i]=i;
                    size[i]=1;

                }
            }

            int find(int x){

                if(par[x]!=x){

                    par[x]=find(par[x]);//path compression

                }

                return par[x];

            }


            void union(int a,int b){//Merging based on component size

                int parA=find(a);
                int parB=find(b);


                if(parA==parB)return;//They belong to same component

                if(size[parA]<parB){

                    par[parA]=parB;

                    size[parB]+=size[parA];

                }else{

                    par[parB]=parA;

                    size[parA]+=size[parB];


                }
            }

        }

        public int[] processQueries(int c, int[][] connections, int[][] queries) {

            DSU dsu=new DSU(c);

            //Build DSU or components from connections
            for(int[] edge:connections){

                dsu.union(edge[0],edge[1]);

            }
            //Leader or root of a component(grid) -> online stations
            Map<Integer, TreeSet<Integer>> map=new HashMap<>();


            for(int i=1;i<=c;i++){

                int leader=dsu.find(i);

                map.putIfAbsent(leader,new TreeSet<>());

                map.get(leader).add(i);//initially all stations will be online

            }

            //isOnline for checking which station is online/offline

            boolean[] isOnline=new boolean[c+1];

            java.util.Arrays.fill(isOnline,true);//All are online initially

            List<Integer> result=new ArrayList<>();


            //Query processing

            for(int[] q:queries){

                int type=q[0];
                int x=q[1];


                if(type==1){

                    if(isOnline[x])result.add(x);
                    else{

                        int leader=dsu.find(x);

                        TreeSet<Integer>set=map.get(leader);

                        if(set==null || set.isEmpty()){
                            result.add(-1);
                        }else{
                            result.add(set.first());

                        }

                    }

                }else if(type==2){

                    if(isOnline[x]){
                        isOnline[x]=false;

                        int leader=dsu.find(x);
                        map.get(leader).remove(x);

                    }
                }

            }

            int[] ans=new int[result.size()];

            for(int i=0;i<result.size();i++){
                ans[i]=result.get(i);

            }

            return ans;

        }
    }

