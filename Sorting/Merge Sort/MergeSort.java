package com.company;

public class MergeSort {
    void sort(int arr[],int beg,int end) {
        if(beg < end) {
            int mid = (beg + end) / 2;
            sort(arr, beg, mid);
            sort(arr, mid + 1, end);
            mergesort(arr, beg, mid, end);
        }
    }
    void mergesort(int arr[],int beg,int mid,int end){
        int left=mid-beg+1;
        int right=end-mid;
        int[] leftarray=new int[left];
        int[] rightarray=new int[right];
        for(int i=0;i<left;i++){
            leftarray[i]=arr[beg+i];
        }
        for(int i=0;i<right;i++){
            rightarray[i]=arr[mid+i+1];
        }
        int i=0,j=0,k=beg;
        while(i<left&&j<right){
            if(leftarray[i]<rightarray[j])
                arr[k++]=leftarray[i++];
            else
                arr[k++]=rightarray[j++];
        }
        while(i<left){
            arr[k++]=leftarray[i++];
        }
        while(j<right){
            arr[k++]=rightarray[j++];
        }
    }
}
