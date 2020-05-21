package com.company;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the numbers");
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the search number");
        int searchnumber=sc.nextInt();
        if(binarysearch(a,searchnumber)!=-1)
            System.out.println("The number "+ binarysearch(a,searchnumber)+" is present in the array");
        else
        System.out.println("The number is not present in the array");
    }
    public static int binarysearch(int[] array,int number){
        int low=0,mid=0;
        int high=array.length-1;
        while(low<=high){
            mid=(high+low)/2;
            if(mid==number)
                return mid;
            if(number<mid)
                high=mid-1;
            else if(number>mid)
                low=mid+1;
        }
        return -1;
    }


}
