package BinarySearch;

import java.sql.SQLOutput;

public class MedianOfSorted {

    public static void main(String[] args) {
        int[] array1={1,2,3,4,7,10,12};
        int[] array2={2,3,6,15};
        int m=array1.length;
        int n=array2.length;
        System.out.println("Median of 2 sorted Arrays using Brute Force  is : "+medianOfSorted1(array1,array2,m,n));
        System.out.println("Median of 2 sorted Arrays using Better Approach is : "+medianOfSorted1(array1,array2,m,n));
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

    //Using Brute Force TC-O(M+N) SC-(1)
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


    //Using Brute Force TC-O(Log(M+N)) SC-O(1)

    public static double medianOfSorted3(int[] nums1,int nums2,int m,int n){







        return 1.0;
    }

}
