package practice.algorithms.backTracking;

import java.util.Scanner;

public class NQueenBranchBound {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sizeOfBoard = s.nextInt();
        solveNQueen(sizeOfBoard);
    }

    public static void solveNQueen(int sizeOfBoard) {
        boolean[][] board = new boolean[sizeOfBoard][sizeOfBoard];
        boolean[] cols = new boolean[sizeOfBoard];
        boolean[] ndiag = new boolean[2*sizeOfBoard-1];
        boolean[] rdiag = new boolean[2*sizeOfBoard-1];
        solveNQueen(board,0,cols,ndiag,rdiag,"");
    }
    public static void solveNQueen(boolean[][] board,int row,boolean[] cols, boolean[] ndiag,boolean[] rdiag, String asf){
        if(row == board.length){
            System.out.println(asf);
            return;
        }

        for(int c=0;c<board[0].length;c++){
            if(cols[c] == false && rdiag[row-c+board.length-1] == false &&  ndiag[row + c] == false) {
                board[row][c] = true;
                cols[c] = true;
                ndiag[row + c] = true;
                rdiag[row - c + board.length - 1] = true;
                solveNQueen(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + c + ", ");
                board[row][c] = false;
                cols[c] = false;
                ndiag[row + c] = false;
                rdiag[row - c + board.length - 1] = false;
            }
        }
    }

}
