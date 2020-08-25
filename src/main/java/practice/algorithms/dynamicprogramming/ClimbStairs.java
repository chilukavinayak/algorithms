package practice.algorithms.dynamicprogramming;

import java.util.Scanner;

/*

1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
Input Format
A number n
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Constraints
0 <= n <= 20
Sample Input
4
Sample Output
7

 */
public class ClimbStairs {

    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        int result =  solution_recursion(n);
        System.out.println(result);
       // memoization
        Integer[] dp = new Integer[n+1];
        result = solution_memoization(n,dp);
        System.out.println(result);

        result = solution_tabulation(n);
        System.out.println(result);
    }

    private static int solution_tabulation(int n){
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else if(i==2){
                dp[i] = dp[i-1]+dp[i-2];
            }
            else
                dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

    private static int solution_recursion(int n) {
        if(n == 0)
            return 1;
        if(n < 0){
            return 0;
        }
        int s1 = solution_recursion(n-1);
        int s2 = solution_recursion(n-2);
        int s3 = solution_recursion(n-3);

        return s1+s2+s3;
    }

    private static int solution_memoization(int n, Integer[] dp){
        if(n == 0){
            return 1;
        }
        else if(n < 0){
            return 0;
        }
        if(dp[n]  != null)
            return dp[n];

        int c1 = solution_memoization(n-1,dp);
        int c2 = solution_memoization(n-2,dp);
        int c3 = solution_memoization(n-3,dp);
        dp[n] = c1+c2+c3;
        return dp[n];
    }
}
