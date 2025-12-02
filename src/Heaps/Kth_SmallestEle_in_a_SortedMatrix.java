package Heaps;

import java.util.PriorityQueue;

public class Kth_SmallestEle_in_a_SortedMatrix {

    public static void main(String[] args) {

       int[][] mat={{1,5,9},{10,11,13},{12,13,15}};
       int k=8;
       Kth_SmallestEle_in_a_SortedMatrix obj=new Kth_SmallestEle_in_a_SortedMatrix();

        System.out.println("Kth smallest element  in the sorted matrix using 1st method  : "+obj.kthSmallest1(mat,k));
        System.out.println("Kth smallest element  in the sorted matrix using 2nd method  : "+obj.kthSmallest2(mat,k));
        System.out.println("Kth smallest element  in the sorted matrix using 3rd method  : "+obj.kthSmallest(mat,k));



    }
    //TC-O(M*N*Log(K))
    //Sc-O(Log(K))

    public int kthSmallest1(int[][] matrix, int k) {

        int m=matrix.length;
        int n=matrix[0].length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                pq.add(matrix[i][j]);

                if(pq.size()>k)pq.poll();

            }
        }

        return pq.peek();
    }


    //TC-O(KLogK) SC-O(K)
    public int kthSmallest2(int[][] matrix, int k) {

        int m=matrix.length;
        int n=matrix[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<Math.min(m,k);i++){

            pq.add(new int[]{matrix[i][0],i,0});

        }

        int ans=-1;
        for(int i=1;i<=k;i++){

            int[] curr=pq.poll();
            int r=curr[1];
            int c=curr[2];
            ans=curr[0];


            if(c+1<n)
                pq.add(new int[]{matrix[r][c+1],r,c+1});


        }

        return ans;
    }


   //Optimised Approach

    int m;
    int n;
    //TC-O((M+N)*Log(max-min)), SC-O(1)
    public int kthSmallest(int[][] matrix, int k) {

        m = matrix.length;
        n = matrix[0].length;

        int ans = -1;

        int low = matrix[0][0];
        int hi = matrix[m - 1][n - 1];

        while (low <= hi) {

            int mid = low + (hi - low) / 2;

            if (countLessOrEqual(matrix, mid) >= k) {

                ans = mid;
                hi = mid - 1;//try to look for smaller value on the left side

            } else {
                low = mid + 1;//try to look for greater value on the right side
            }

        }

        return ans;
    }

    private int countLessOrEqual(int[][] mat, int mid) {

        int col=n-1;//rightmost column
        int count=0;

        for(int r=0;r<m;r++){

            while(col>=0 && mat[r][col]>mid)col--;

            count+=(col+1);

        }
        return count;
    }

}
