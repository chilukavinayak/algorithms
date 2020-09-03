/*
Question
1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.

Note -> Check out the question video and write the recursive code as it is intended without
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A string S and a number K
Output Format
A number
Constraints
1 <= length of S <= 30
1 <= K <= 10
Sample Input
1234567
4
Sample Output
7654321
 */

package practice.algorithms.backTracking;

import java.util.Scanner;

public class LargestNumberAfterKSwaps {
    static String max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        max = str;
        int k = sc.nextInt();
        largestNAfterKSwap(str,k);
        System.out.println(max);
    }

    private static void largestNAfterKSwap(String str, int k) {
        if(Integer.parseInt(str) > Integer.parseInt(max)){
            max = str;
        }

        if(k==0){
            return;
        }

        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                str = swap(str,i,j);
                largestNAfterKSwap(str,k-1);
                str = swap(str,i,j);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0,i);
        String mid = str.substring(i+1,j);
        String right = str.substring(j+1);

        return left+jth+mid+ith+right;
    }
}
