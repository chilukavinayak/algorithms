package practice.algorithms.recursion;

import java.util.Scanner;

public class LexicoGraphicalNumbers {
    public static void print(int n){
       for(int i=1;i<=9;i++){
           dfs(i,n);
       }
    }
    public static void dfs(int i,int n){
        if(i > n) return;
        System.out.print(i+"\t");
        for(int j=0;j<=9;j++){
            dfs(j+i*10,n);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
}
