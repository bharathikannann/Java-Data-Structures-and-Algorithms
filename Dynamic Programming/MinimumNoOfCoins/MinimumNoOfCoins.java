package com.company;

import java.util.Arrays;

public class MinimumNoOfCoins {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        //dp = 0 12 12 12 12 12 12 12 12 12 12 12
        //     0 1  1  2  2  1  2  2  3  3  2  3
            // 0 1  min(2,12) ......
          //   - -  min(2,1)  ......
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        System.out.println("The DP array is");
        for(int i=0;i<amount+1;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println("\nThe output is");
        System.out.println(dp[amount]);
    }
    public static int min(int a,int b){
        return a<b?a:b;
    }
}
