package practice.algorithms.dynamicprogramming;

import java.util.Scanner;

public class ClimbStairsWithVariableJumps {
    public static int numberOfWaysClimbStairs(int n, int[] arr){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=arr[i];j++){
                if((i+j) < dp.length)
                    dp[i] += dp[i+j];
            }
        }

       return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arry = new int[n];
        for(int i=0;i<n;i++){
            arry[i] = sc.nextInt();
        }
        int result = numberOfWaysClimbStairs(n, arry);
        System.out.println(result);
    }
}
