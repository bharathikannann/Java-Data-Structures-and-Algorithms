package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(memoization(10));
        System.out.println(lookup(10));

    }
    public static int fib(int n){
        if(n<=1)
            return n;
        return fib(n-1)+fib(n-2);
    }
    public static int memoization(int n){
        int[] array=new int[n+1];
        if(n<=1) {
            return n;
        }
        if(array[n]!=0) {
            return array[n];
        }else {
            array[n] = fib(n - 1) + fib(n - 2);
            return array[n];
        }
    }
    public static int lookup(int n){
        int[] array=new int[n+2];
        array[0]=0;
        array[1]=1;
        for(int i=2;i<=n;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[n];
    }
}
