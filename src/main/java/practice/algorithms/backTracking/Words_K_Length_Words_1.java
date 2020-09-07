/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the
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
acb
adb
aeb
acd
ace
adc
aec
ade
aed
bac
bad
bae
cab
dab
eab
cad
cae
dac
eac
dae
ead
bca
bda
bea
cba
dba
eba
cda
cea
dca
eca
dea
eda
bcd
bce
bdc
bec
bde
bed
cbd
cbe
dbc
ebc
dbe
ebd
cdb
ceb
dcb
ecb
deb
edb
cde
ced
dce
ecd
dec
edc
 */

package practice.algorithms.backTracking;

import java.util.HashSet;
import java.util.Scanner;

public class Words_K_Length_Words_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        String ustr = "";
        HashSet<Character> set = new HashSet<>();
        for(char c: str.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                ustr += c;
            }
        }

        Character[] spots = new Character[k];
        generateWords(0, ustr, 0, k, spots);
    }

    private static void generateWords(int cs, String ustr, int ssf, int ts, Character[] spots) {
        if(cs == ustr.length()){
            if(ssf==ts){
                for(int i=0;i< spots.length;i++)
                    System.out.print(spots[i]);
                System.out.println();
            }
            return;
        }

        char c = ustr.charAt(cs);
        for(int i=0;i<spots.length;i++){
            if(spots[i] == null){
                spots[i] = c;
                generateWords(cs+1,ustr,ssf+1,ts,spots);
                spots[i] = null;
            }
        }
        generateWords(cs+1,ustr,ssf,ts,spots);
    }


}
