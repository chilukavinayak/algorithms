/*

1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
Input Format
9*9 integers ranging from 1 to 9.
0 represents an empty cell.
Output Format
You have to print the solved sudoku.
Constraints
0 <= arr[i][j] <= 9
Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
Sample Output
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9

*/

package practice.algorithms.backTracking;

import java.util.Scanner;

public class Sudoku {
    public static void sudoku(int[][] board,int i,int j){

        if(i == board.length) {
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;

        if(j == board[0].length-1){
            ni= i+1;
            nj = 0;
        }
        else{
            ni = i;
            nj = j+1;
        }

        if(board[i][j] != 0) {
            sudoku(board,ni,nj);
        }else{
            for (int op = 1; op <= 9; op++) {
                if (isValid(board, i, j, op)) {
                    board[i][j] = op;
                    sudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }

    }
    public static boolean isValid(int[][] board, int x, int y, int op){

        for(int j=0;j< board[0].length;j++)
            if(board[x][j] == op)
                return false;

        for(int i=0;i<board[0].length;i++)
            if(board[i][y] == op)
                return false;


        int smi = x/3 * 3;
        int smj = y/3 * 3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi+i][smj+j] == op)
                    return false;
            }
        }
        return  true;
    }
    public static void display(int[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = sc.nextInt();
            }
        }
        sudoku(board,0,0);
    }
}
