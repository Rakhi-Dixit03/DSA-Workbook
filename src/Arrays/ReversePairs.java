package Arrays;

public class ReversePairs {

    public static void main(String[] args) {
        int[] arr={40,25,19,12,9,6,2};
        System.out.println("Reverse Pairs count Through Brute Force Approach : "+reversePairs1(arr));
        System.out.println("Reverse Pairs count Through Optimised Approach : "+reversePairs2(arr));

    }

    //Brute Force TC-O(N^2)

    public static int reversePairs1(int[] arr){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>2*arr[j]){
                    count++;
                }

            }

        }
        return count;
    }

    //Optimised Approach
    public static int reversePairs2(int[] arr){
        int n=arr.length;
        return mergeSort(arr,0,n-1);

    }

    //Using Modified Merge Sort

    public static int mergeSort(int[] arr,int l,int h){
        int count=0;
        //Base Case
        if(l>=h)return count;

        int mid=l+(h-l)/2;

       count+= mergeSort(arr,l,mid);
       count+= mergeSort(arr,mid+1,h);
       count+= countPairs(arr,l,mid,h);
       merge(arr,l,mid,h);
       return count;
    }

    public static void merge(int[] arr,int st,int mid,int end){

        int[] temp=new int[end-st+1];
        int i=st;
        int j=mid+1;
        int k=0;


        while(i<=mid && j<=end){

            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }

        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=end){
            temp[k++]=arr[j++];
        }

        int n=0;
        //Copying
        for(int m=st;m<=end;m++){
            arr[m]=temp[n++];
        }

    }

//O(N)
    public static int countPairs(int[] arr,int st,int mid,int end){
      int right=mid+1;
      int count=0;

      for(int i=st;i<=mid;i++){

          while(right<=end && (long)arr[i]>2L*arr[right]){
                  right++;
              }
           count+=(right-(mid+1));

          }
      return count;
    }

}
