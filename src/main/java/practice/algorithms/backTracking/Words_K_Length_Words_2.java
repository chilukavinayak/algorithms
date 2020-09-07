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
acd
ace
adb
adc
ade
aeb
aec
aed
bac
bad
bae
bca
bcd
bce
bda
bdc
bde
bea
bec
bed
cab
cad
cae
cba
cbd
cbe
cda
cdb
cde
cea
ceb
ced
dab
dac
dae
dba
dbc
dbe
dca
dcb
dce
dea
deb
dec
eab
eac
ead
eba
ebc
ebd
eca
ecb
ecd
eda
edb
edc
 */

package practice.algorithms.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Words_K_Length_Words_2 {

    public static void generateWords(int cs, int ts, String ustr, HashSet<Character> used, String asf) {
       if(cs > ts){
           System.out.println(asf);
           return;
       }

        for(int i=0;i<ustr.length();i++){
            char c = ustr.charAt(i);
            if(used.contains(c) == false){
                used.add(c);
                generateWords(cs+1,ts,ustr,used,asf+c);
                used.remove(c);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateWords(1, k, ustr, new HashSet<>(), "");
    }

}
