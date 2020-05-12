package com.company;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        //         -2  -3  4  3   1   2  7  4
        //         -2  -2  4  4   4   4  7  7

        int maxhere = a[0]; //maxoutput=a[0];
        int[] maxoutput = new int[a.length];
        maxoutput[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            maxhere = max(a[i], a[i] + maxhere);
            maxoutput[i] = max(maxhere, maxoutput[i - 1]);
        }
        System.out.println(maxoutput[a.length - 1]);
        printlist(maxoutput,a);
        System.out.println();
        for(int i=0;i<maxoutput.length;i++){
            System.out.print(maxoutput[i]+" ");
        }
    }
    public static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static void printlist(int[] maxoutput,int[] a){
            int index=0;
            for(int i=a.length-1;i>=0;i--){
                if(maxoutput[i]>maxoutput[i-1]){
                    index=i;
                    break;
                }

            }
            int j=maxoutput[a.length-1];
            int newindex=index;
            while(j!=0){
                System.out.print(a[index--]+" ");
                j=j-a[newindex--];
            }
        }
    }

