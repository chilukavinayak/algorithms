/*
1. You are given a number n.
2. You have to count the number of set bits in the given number.
Input Format
A number n
Output Format
Number of set bits in n
Constraints
1 <= n <= 10^9
Sample Input
58
Sample Output
4

 */

package practice.algorithms.bitmanupulation;

import java.util.Scanner;

public class CountNoSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count =0;
        for(int i=31;i>=0;i++){
            if((n & 1 << i) != 0)
                count++;
        }
        System.out.println(count);
    }
}
