package practice.algorithms.backTracking;

import java.util.Scanner;

public class Combinations1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tb = sc.nextInt();
        int  ti = sc.nextInt();

        combinations(tb, ti, 1, 0, "");
    }

    private static void combinations(int tb, int ti, int cb, int ssf, String ans) {
        if(cb > tb){
            if(ssf == ti) {
                System.out.println(ans);
            }
            return;
        }

        combinations(tb,ti, cb+1,ssf+1,ans+"i");
        combinations(tb,ti, cb+1,ssf,ans+"-");
    }
}
