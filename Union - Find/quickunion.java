package com.company;

public class quickunion {
    private int[] id;
    public void QuickUnion(int n){
        id=new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
        }
    }
    public int root(int n){
        while(n!=id[n]){
            n=id[n];
        }
        return n;
    }
    public boolean connected(int p,int q){
        return root(p)==root(q);
    }
    public void union(int p,int q){
        int proot=root(p);
        int qroot=root(q);
        id[proot]=q;
    }
}
