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

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class PermutationWord2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character,Integer> lastOccurence = new HashMap<>();
        for(char c: str.toCharArray()){
            lastOccurence.put(c,-1);
        }

        permutation(0,new Character[str.length()],str,lastOccurence);

    }

    private static void permutation(int cc, Character[] spots, String str, HashMap<Character, Integer> lastOccurence) {
        if(cc == str.length()){
            for(int i=0;i< spots.length;i++)
                System.out.print(spots[i]);
            System.out.println();
            return;
        }
        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);
        for(int i=lo+1;i<str.length();i++){
            if(spots[i] == null){
                spots[i] = ch;
                lastOccurence.put(ch,i);
                permutation(cc+1,spots,str,lastOccurence);
                spots[i] = null;
                lastOccurence.put(ch,lo);
            }
        }
    }
}
