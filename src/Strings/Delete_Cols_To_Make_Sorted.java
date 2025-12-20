package Strings;

public class Delete_Cols_To_Make_Sorted {

    public static void main(String[] args) {

        String[] strs={"cba","daf","ghi"};

        System.out.println("Number of Columns that are not sorted Lexicographically : "+minDeletionSize(strs));
        System.out.println("Number of Columns that are not sorted Lexicographically using 2nd approach : "+minDeletionSize2(strs));

    }

//TC-O(N*K)
    public static int minDeletionSize(String[] strs) {

        int n=strs.length;
        int count=0;

        for(int i=0;i<strs[0].length();i++){

            for(int j=1;j<n;j++){

                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    count++;
                    break;
                }
            }


        }
        return count;

    }

    public static int minDeletionSize2(String[] strs) {

        int m = strs.length;//no. of rows

        int n = strs[0].length();//no. of cols
        int count=0;

        char[][] mat=new char[m][n];

       //Building char Array
        for(int i=0;i<m;i++){

            mat[i]=strs[i].toCharArray();

        }

        for(int i=0;i<n;i++){//checking for each column whether it is sorted or not

            if(!isSorted(mat,i)){
                count++;
            }

        }

        return count;
    }

    public static boolean isSorted(char[][] mat,int col){


        for(int i=0;i<mat.length-1;i++){

            if(mat[i][col]>mat[i+1][col])return false;

        }
        return true;
    }


}
