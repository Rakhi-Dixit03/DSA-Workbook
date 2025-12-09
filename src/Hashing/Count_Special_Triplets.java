package Hashing;

//3583
public class Count_Special_Triplets {

    public static void main(String[] args) {

       int[] arr={8,4,2,8,4};

        System.out.println("Special Triplets Count : "+specialTriplets(arr));
        System.out.println("Special Triplets Count : "+specialTriplets1(arr));

    }


    static int mod=(int)1e9+7;
    static int M=(int)1e5+1;

    //Two pass solution

    public static int specialTriplets(int[] nums) {

        long count=0;
        int[] left=new int[M];
        int[] right=new int[M];


        for(int n:nums)right[n]++;

        for(int num:nums){

          right[num]--;

          int need=num*2;

          if(need<M){//index can go out of bounds
              count=(count+(1L*left[need]*right[need])%mod)%mod;
          }

         //updating left {become prev count of elements seen before that index}
         left[num]++;

        }

        return (int)count;
    }


    //One pass Solution

    public static int specialTriplets1(int[] nums) {

        int count=0;

        int[] valid_i=new int[M];
        int[] valid_j=new int[M];



        //one pass solution
        for(int num:nums){

            // triplet  is of the form - 2x x 2x

            //check if curr element can become valid k

            if(num%2==0){

                count = (count+(valid_j[num/2]))%mod;

            }

            //ask if curr element can become valid j


            if(num*2<M){//check for when  index  go out of bounds

                valid_j[num]= (valid_j[num]+valid_i[num*2])%mod;
            }


            //add current element to valid_i

            valid_i[num]++;

        }

        return count;
    }



}
