package practice.algorithms.dynamicprogramming;

import java.util.Scanner;

public class Fibonacci {
    public static int fib_normal(int n){
        if(n <= 1){
            return n;
        }
        return fib_normal(n-1)+fib_normal(n-2);
    }
    public static int fib_Tabulation(int n){
        int[] qb = new int[n+1];
        qb[0] = 0;
        qb[1] = 1;
        for(int i=2;i<=n;i++){
            qb[i] = qb[i-1]+qb[i-2];
        }
        return qb[n];
    }
    public static int fib_memo(int n, Integer[] qb){
        if(n <= 1){
            return n;
        }
        if(qb[n] != null){
            return qb[n];
        }

        return fib_memo(n-1,qb)+fib_memo(n-2,qb);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = fib_normal(n);
        System.out.println(result);

        //----------Memorization
        result = fib_memo(n, new Integer[n+1]);
        System.out.println(result);

        //----------Tabulation
        result = fib_Tabulation(n);
        System.out.println(result);


    }
}
