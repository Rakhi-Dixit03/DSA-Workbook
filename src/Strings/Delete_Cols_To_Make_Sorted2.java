package Strings;

public class Delete_Cols_To_Make_Sorted2 {

    public static void main(String[] args) {

        String [] strs ={"xba","xag","yak"};
        System.out.println("Minimum Deletion size of answer array to make columns lexicographically sorted :  "+minDeletionSize(strs));

    }

    public static int minDeletionSize(String[] strs) {

        int ans=0;
        int n=strs.length;
        int strLen=strs[0].length();

        boolean[] isSorted = new boolean[n-1];
        search : for(int j=0;j<strLen;j++){//column

            for(int i=0;i<n-1;i++){

                if(!isSorted[i] && (strs[i].charAt(j)>strs[i+1].charAt(j) )){
                    ans++;
                    continue search;

                }
            }

            for(int i=0;i<n-1;i++){

                if(!isSorted[i] &&  (strs[i].charAt(j)<strs[i+1].charAt(j))){
                    isSorted[i]=true;
                }
            }

        }

        return ans;
    }

}
