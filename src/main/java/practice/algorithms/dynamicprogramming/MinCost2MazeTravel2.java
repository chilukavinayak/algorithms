package practice.algorithms.dynamicprogramming;

import java.util.Scanner;

public class MinCost2MazeTravel2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                maze[i][j] = sc.nextInt();
        }

        int[][] dp = new int[n][m];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 &&  j == m-1){
                    dp[i][j] = maze[i][j];
                }
                else if(i == n-1){
                    dp[i][j] = dp[i][j+1] + maze[i][j];
                }
                else if(j == m-1){
                   dp[i][j] = dp[i+1][j]+maze[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j]+maze[i][j], dp[i][j+1]+maze[i][j]);
                }
            }
        }
        System.out.println(dp[0][0]);


    }
}
