package practice.algorithms.recursion;

import java.util.Scanner;

public class CircularKilling {

    // 0 to n-1
    public static int lastPerson(int n ,int k){
        if(n == 0)
            return 0;
        int x =  lastPerson(n-1,k);
        int y = (x+k)%n;
        return y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(lastPerson(n,k));
    }
}
