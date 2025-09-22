package BinarySearch;

import java.sql.SQLOutput;

public class MedianOfSorted {

    public static void main(String[] args) {
        int[] array1={1,2,3,4,7,10,12};
        int[] array2={2,3,6,15};
        int m=array1.length;
        int n=array2.length;
        System.out.println("Median of 2 sorted Arrays using Brute Force  is : "+medianOfSorted1(array1,array2,m,n));
        System.out.println("Median of 2 sorted Arrays using Better Approach is : "+medianOfSorted2(array1,array2,m,n));
        System.out.println("Median of 2 sorted Arrays using Better Approach is : "+medianOfSorted3(array1,array2));
    }


    //Using Brute Force TC-O(M+N) SC-(M+N)
    public static double medianOfSorted1(int[] nums1,int[] nums2,int m,int n){

        int[] temp=new int[m+n];

        int i=0,j=0,k=0;

        while(i<m && j<n ){

            if(nums1[i]<=nums2[j]){

                temp[k++]=nums1[i++];
            }else{
                temp[k++]=nums2[j++];
            }

        }

        while(i<m){

            temp[k++]=nums1[i++];

        }

        while(j<n){
            temp[k++]=nums2[j++];

        }

        int size=(m+n);
        //Odd Number of elements
        if(size%2==1){

            return temp[size/2]*1.0;

        }
        //Even Number of elements
        return (temp[size/2]+temp[(size/2)-1])/2.0;

    }

    //Using Better Approach TC-O(M+N) SC-(1)
    public static double medianOfSorted2(int[] nums1,int[] nums2,int m,int n){

        int size=m+n;

        int idx1=size/2;
        int idx2=(size/2)-1;

        int ele1=0;
        int ele2=0;

        int i=0,j=0,k=0;


        while(i< m && j < n){

            if(nums1[i]<=nums2[j]){

                if(k==idx1){
                    ele1=nums1[i];
                }

                if(k==idx2){
                    ele2=nums1[i];
                }
                i++;
            }else{

                if(k==idx1){
                    ele1=nums2[j];
                }

                if(k==idx2){
                    ele2=nums2[j];
                }
                j++;
            }
            k++;

        }

        while(i<m){

            if(k==idx1){

                ele1=nums1[i];
            }

            if(k==idx2){

                ele2=nums1[i];
            }
            i++;
            k++;
        }

        while(j<n){

            if(k==idx1){

                ele1=nums2[j];
            }

            if(k==idx2){

                ele2=nums2[j];
            }
            j++;
            k++;
        }

        //odd
        if(size%2==1){

            return ele1*1.0;

        }else{
            return (ele1+ele2)/2.0;
        }

    }


    //Using Optimal Solution TC-O(Log(M+N)) SC-O(1)

    public static double medianOfSorted3(int[] nums1,int[] nums2){


        if(nums1.length>nums2.length){
            return medianOfSorted3( nums2,nums1);//Ensuring nums1 is always smaller
        }

        int m=nums1.length;
        int n=nums2.length;

        int l=0;
        int h=m;

        while(l<=h){

            int px=l+(h-l)/2;
            int py=(m+n+1)/2-px;

            //Left side elements
            int x1=px==0?Integer.MIN_VALUE : nums1[px-1];
            int x2=py==0?Integer.MIN_VALUE : nums2[py-1];

            //Right side elements
            int x3=px==m?Integer.MAX_VALUE : nums1[px];
            int x4=py==n?Integer.MAX_VALUE : nums2[py];


            if(x1<=x4 && x2<=x3){

                if((m+n)%2==0){

                    return (Math.max(x1,x2) + Math.min(x3,x4))/2.0 ;

                }else{

                    return Math.max(x1,x2)*1.0;
                }

            }

            if(x1 > x4){

                h=px-1;

            }else{

                l=px+1;
            }


        }
        return -1;

    }

}
