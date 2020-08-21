package practice.algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once.
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if you start and stop collecting gold from any position in the grid that has some gold.

Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
A number m
e11
e12..
e12
e22..
m*n numbers
Output Format
Maximum gold collected
Constraints
1 <= n <= 10
1 <= m <= 10
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

output: 120
*/
public class GoldMining {
    static int max = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j  < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }
    private static void travelAndCollectGold(int[][] arr, int i,int j, boolean[][] visited, List<Integer> bag){
        if(i < 0 || j < 0 || i >= arr.length ||j >= arr[0].length || visited[i][j] || arr[i][j] == 0)
            return;

        bag.add(arr[i][j]);
        visited[i][j] = true;
        travelAndCollectGold(arr,i-1,j,visited,bag);
        travelAndCollectGold(arr,i,j+1,visited,bag);
        travelAndCollectGold(arr,i,j-1,visited,bag);
        travelAndCollectGold(arr,i+1,j,visited,bag);

    }
    private static void getMaxGold(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] != 0 && visited[i][j] == false){
                    List<Integer> bag = new ArrayList<Integer>();
                    travelAndCollectGold(arr,i,j,visited,bag);
                    max = Math.max(max,bag.stream().mapToInt(s->s).sum());
                }
            }
        }
    }
}
