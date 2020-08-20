package practice.algorithms.patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            for(int j=i;j>0;j--)
                System.out.print("\t");
            for(int k=i;k<n;k++)
                System.out.print("*\t");
            System.out.println();
        }

    }
}
