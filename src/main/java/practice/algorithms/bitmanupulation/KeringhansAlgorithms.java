/*
Question
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

public class KeringhansAlgorithms {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int counter = 0;
        while(n>0){
            int rsbm = n & -n;
            counter++;
            n = n - rsbm;
        }


        System.out.println(counter);
    }
}
