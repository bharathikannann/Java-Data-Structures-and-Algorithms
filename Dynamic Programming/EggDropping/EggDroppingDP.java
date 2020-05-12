package com.company;

public class EggDroppingDP {
    public static int[][] l;
    public static int eggdropping(int n,int k){
        l= new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            l[i][0]=0;
            l[i][1]=1;
        }
        for(int i=2;i<=k;i++){
            l[1][i]=i;
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                int min=Integer.MAX_VALUE,res;
                for(int x=1;x<=j;x++){
                    res=1+max(l[i-1][x-1],l[i][j-x]);
                    if(res<min)
                        min=res;
                }
                l[i][j]=min;
            }
        }
        printarray(n,k);
        return l[n][k];
    }
    public static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static void printarray(int n,int k){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                System.out.print(l[i][j]+" ");
            }
            System.out.println();
        }
    }
}
