/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the
     word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video.
Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde
 */

package practice.algorithms.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class WordKSelection1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> charSet = new HashSet<>();
        String ustr = "";
        for(char ch: str.toCharArray()){
           if(!charSet.contains(ch)) {
               charSet.add(ch);
               ustr += ch;
           }
        }
        generateSelection(0,k,ustr,"");

    }

    private static void generateSelection(int cc, int k, String ustr, String asf) {
        if(cc == ustr.length()){
            if(asf.length() == k){
                System.out.println(asf);
            }
            return;
        }

        char c = ustr.charAt(cc);
        generateSelection(cc+1,k,ustr,asf+c);
        generateSelection(cc+1,k,ustr,asf);

    }
}
