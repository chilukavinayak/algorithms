package practice.algorithms.patterns;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            for(int j=n-i-1;j>0;j--)
                System.out.print("\t");
            for(int k=i;k>=0;k--)
                System.out.print("*\t");

            System.out.println();
        }


    }
}
