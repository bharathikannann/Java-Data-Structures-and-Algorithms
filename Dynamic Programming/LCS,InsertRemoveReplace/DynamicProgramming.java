package com.company;

public class DynamicProgramming {
    public static int lcs(String s1,String s2,int m,int n){
        int l[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    l[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    l[i][j]=1+l[i-1][j-1];
                else
                    l[i][j]=max(l[i-1][j],l[i][j-1]);
            }
        }
        return l[m][n];
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static int insertremovereplace(String s1,String s2,int m,int n){
        int[][] l=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0)
                    l[i][j]=j;
                else if(j==0)
                    l[i][j]=i;
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    l[i][j]=l[i-1][j-1];
                }else{
                    l[i][j]=1+min(l[i-1][j],l[i][j-1],l[i-1][j-1]);
                }
            }
        }
        return l[m][n];
    }
    public static int min(int a,int b,int c){
        if(a<b&&a<c)
            return a;
        else if(b<a&&b<c)
            return b;
        else
            return c;
    }
}
