/*
1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without
                   changing signature. The judge can't force you but intends you to teach a concept.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. - means empty box, i means occupied by item.
Constraints
0 < nboxes <= 10
0 <= ritems <= nboxes
Sample Input
5
3
Sample Output
iii--
ii-i-
ii--i
i-ii-
i-i-i
i--ii
-iii-
-ii-i
-i-ii
--iii
 */

package practice.algorithms.backTracking;

import java.util.Scanner;

public class Combinations2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        int ts = sc.nextInt();

        combination(0,nb,ts,new boolean[nb],-1);

    }

    private static void combination(int ci, int nb, int ts, boolean[] boxes, int lb) {
        if(ci > ts){
            for(int i=0;i<boxes.length;i++){
                if(boxes[i]){
                    System.out.print("i");
                }
                else
                    System.out.print("-");
            }
            System.out.println();
            return;
        }


        for(int i=lb+1;i< boxes.length;i++){
            if(!boxes[i]){
                boxes[i]=true;
                combination(ci+1,nb,ts,boxes,i);
                boxes[i]=false;
            }
        }
    }
}
