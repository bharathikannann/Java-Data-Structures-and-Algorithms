package com.company;

public class LongestPalindromeSubsequence {
    static int[][] l;
    public static int lps(String s,int n){
        l=new int[n][n];
        for(int i=0;i<n;i++){
            l[i][i]=1;
        }
        int j=0;
        for(int cl=2;cl<=n;cl++){      //cl=1;cl<n ,i<n-cl , j=i+cl;
            for(int i=0;i<n-cl+1;i++){
                j=i+cl-1;
                if(s.charAt(i)==s.charAt(j)&&cl==2){
                    l[i][j]=2;
                }else if(s.charAt(i)==s.charAt(j)){
                    l[i][j]=l[i+1][j-1]+2;
                }else{
                    l[i][j]=max(l[i+1][j],l[i][j-1]);
                }
            }
        }
        printarray(n,n);
        return l[0][n-1];
    }
    public static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static void printarray(int n,int k){
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                System.out.print(l[i][j]+" ");
            }
            System.out.println();
        }
    }
}
