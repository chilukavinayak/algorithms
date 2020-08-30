
/*
Question
1. You are given a string of length n.
2. You have to print all the palindromic permutations of the given string.
3. If no palindromic permutation exists for the given string, print "-1".

Note -> Check out the question video and write the recursive code as it is intended without
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A String of length n
Output Format
Check the sample ouput and question video.
Constraints
1 <= length of string <= 15
Sample Input
aaabb
Sample Output
ababa
baaab

 */
package practice.algorithms.backTracking;

import java.util.HashMap;
import java.util.Scanner;

public class AllParlimdromePermuation {

    public static void generatepw(int cs, int ts, HashMap < Character, Integer > fmap, Character oddc, String asf) {
        if(cs > ts){

         //   System.out.println(asf);
            StringBuffer rev = new StringBuffer(asf).reverse();
            if(oddc != null){
                asf += oddc;
            }
            asf += rev;
            System.out.println(asf);

            return;
        }
        for (char c: fmap.keySet()) {
            if (fmap.get(c) > 0) {
                fmap.put(c, fmap.get(c) - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + c);
                fmap.put(c, fmap.get(c) + 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap < Character, Integer > fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;
        Character oddChar = null;
        int len = 0;
        for (Character c: fmap.keySet()) {
            int frq = fmap.get(c);
            if (frq % 2 == 1) {
                oddChar = c;
                oddCount++;
            }
            if (oddCount > 1) {
                System.out.println("-1");
                return;
            }
            fmap.put(c, frq / 2);
            len += frq/2;
        }

        generatepw(1, len, fmap, oddChar, "");
        //write your code here
    }

}