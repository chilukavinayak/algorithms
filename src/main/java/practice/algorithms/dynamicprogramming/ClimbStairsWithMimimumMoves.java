/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of
     staircase.
Note -> If there is no path through the staircase print null.
Input Format
A number n
.. n more elements
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 20
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4
 */

package practice.algorithms.dynamicprogramming;

import java.util.Scanner;

public class ClimbStairsWithMimimumMoves {


    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arry = new int[n];

        for(int i=0;i<arry.length;i++){
            arry[i] = sc.nextInt();
        }

        Integer[] dp = new Integer[n+1];
        dp[n] = 0;


        for(int i=n-1;i >= 0;i--){

            if(arry[i] > 0) {
                int minValue = Integer.MAX_VALUE;
                for (int j = 1; j <= arry[i]; j++) {
                    if ((i + j) < dp.length && dp[i+j] != null ) {
                        minValue = Math.min(dp[i + j], minValue);
                    }
                }
                if(minValue != Integer.MAX_VALUE) {
                    dp[i] = minValue +1;
                }
            }
        }

        System.out.println(dp[0]);
    }

}

