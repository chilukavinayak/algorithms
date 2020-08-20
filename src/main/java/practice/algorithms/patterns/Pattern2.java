package practice.algorithms.patterns;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            for(int j=n-i;j>0;j--)
                System.out.print("*	");
            System.out.println();
        }


    }
}
