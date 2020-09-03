/*
Question
1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't
                   force you but intends you to teach a concept.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 0 means empty box.
Constraints
0 < nboxes <= 10
0 <= ritems <= nboxes
Sample Input
5
3
Sample Output
12300
12030
12003
13200
10230
10203
13020
10320
10023
13002
10302
10032
21300
21030
21003
31200
01230
01203
31020
01320
01023
31002
01302
01032
23100
20130
20103
32100
02130
02103
30120
03120
00123
30102
03102
00132
23010
20310
20013
32010
02310
02013
30210
03210
00213
30012
03012
00312
23001
20301
20031
32001
02301
02031
30201
03201
00231
30021
03021
00321
 */

package practice.algorithms.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }

    private static void permutations(int[] boxes, int ci, int ti) {
        if(ci > ti){
            for(int i=0;i< boxes.length;i++){
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for(int i=0;i< boxes.length;i++){
            if(boxes[i] == 0){
                boxes[i] = ci;
                permutations(boxes,ci+1,ti);
                boxes[i] = 0;
            }

        }
    }
}
