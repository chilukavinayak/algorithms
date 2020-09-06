/*
Question
1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video.
Constraints
0 < str.length() <= 4
Sample Input
aabb
Sample Output
aabb
abab
abba
baab
baba
bbaa
 */

package practice.algorithms.backTracking;

import java.io.*;
import java.util.*;

public class PermutationWord1 {

    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        if(cs > ts){
            System.out.println(asf);
            return;
        }

        for(char c: fmap.keySet()){
            if(fmap.get(c)>0){
                fmap.put(c, fmap.get(c)-1);
                generateWords(cs+1,ts,fmap,asf+c);
                fmap.put(c, fmap.get(c)+1);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: str.toCharArray()){
            if(fmap.containsKey(ch)){
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        generateWords(1, str.length(), fmap, "");
    }

}