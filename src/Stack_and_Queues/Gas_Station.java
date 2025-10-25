package Stack_and_Queues;

public class Gas_Station {

    public static void main(String[] args) {

        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        System.out.println("Starting gas station's index if we can travel around the circuit once : "+canCompleteCircuit(gas,cost));

        System.out.println("Starting gas station's index if we can travel around the circuit once : "+canCompleteCircuit2(gas,cost));

    }

    //Brute Force O(N^2)
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n=gas.length;

        for(int i=0;i<n;i++){

            if(gas[i]<cost[i])continue;

            int j=(i+1)%n;

            int currGas=gas[i]-cost[i]+gas[j];

            while(j!=i){

                int costOfMovingToNext=cost[j];

                if(currGas < costOfMovingToNext)
                    break;

                j=(j+1)%n;

                int gasEarningAtStationj=gas[j];

                currGas=currGas-costOfMovingToNext + gasEarningAtStationj;


            }

            if(i==j)return i;

        }

        return -1;
    }


    //Greedy Approach O(N)

    public static int canCompleteCircuit2(int[] gas, int[] cost) {

        int n=gas.length;

        int sumGas=java.util.Arrays.stream(gas).sum();
        int sumCost=java.util.Arrays.stream(cost).sum();

        if(sumGas<sumCost)return -1;

        int res=0;
        int total=0;

        for(int i=0;i<n;i++){

            total+=gas[i]-cost[i];

            if(total<0){

                total=0;
                res=i+1;

            }
        }

        return res;

    }


}
