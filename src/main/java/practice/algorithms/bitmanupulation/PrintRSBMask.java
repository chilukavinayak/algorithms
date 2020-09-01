/*
1. You are given a number n.
2. You have to print the right-most set bit mask.
Input Format
A number n
Output Format
A number
Constraints
1 <= n <= 10^9
Sample Input
58
Sample Output
10

 */
package practice.algorithms.bitmanupulation;

import java.util.Scanner;

public class PrintRSBMask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rsbmask = n & -n;
        System.out.println(Integer.toBinaryString(rsbmask));
    }
}
