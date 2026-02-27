package Bit_Manipulation;

import java.util.*;

public class Min_Ops_To_Equalize_BinStr {

    public int minOperations(String s, int k) {

        int n=s.length();

        int startZeros=0;
        for(char ch:s.toCharArray()){
            if(ch=='0'){
                startZeros++;
            }
        }

        if(startZeros==0){//already in result  state
            return 0;
        }

        int[] operations=new int[n+1];
        Arrays.fill(operations,-1);

        TreeSet<Integer>evenSet=new TreeSet<>();
        TreeSet<Integer>oddSet=new TreeSet<>();

        for(int count=0;count<=n;count++){
            if(count%2==0){
                evenSet.add(count);
            }else{
                oddSet.add(count);
            }
        }

        Queue<Integer>q=new LinkedList<>();

        q.offer(startZeros);

        operations[startZeros]=0;

        if(startZeros%2==0){
            evenSet.remove(startZeros);
        }else{
            oddSet.remove(startZeros);
        }

        while(!q.isEmpty()){

            int z=q.poll();

            int minNewZ=k+z-2*Math.min(k,z);
            int maxNewZ=k+z-2*Math.max(0,k-n+z);

            TreeSet<Integer>currSet=(minNewZ%2==0)?evenSet:oddSet;

            Integer val=currSet.ceiling(minNewZ);//lower Bound

            while(val!=null && val<=maxNewZ){

                int newZ=val;

                operations[newZ]=operations[z]+1;

                if(newZ==0){
                    return operations[newZ];
                }

                q.offer(newZ);
                currSet.remove(val);

                val=currSet.ceiling(minNewZ);


            }

        }

        return -1;

    }

}
