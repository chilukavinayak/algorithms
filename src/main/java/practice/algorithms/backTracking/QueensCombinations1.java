package practice.algorithms.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensCombinations1 {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if(row == tq){
            if(tq == qpsf)
                System.out.println(asf);
            return;
        }

        int nRow=0;
        int nCol=0;
        String yasf ="";
        String nasf = "";
        if(col == tq-1){
            nRow = row + 1;
            nCol = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        }
        else {
            nRow = row;
            nCol = col+1;
            yasf = asf + "q";
            nasf = asf + "-";
        }
        queensCombinations(qpsf+1,tq,nRow,nCol,yasf);
        queensCombinations(qpsf+0,tq,nRow,nCol,nasf);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
