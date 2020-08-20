
/*

1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet from a to z.
2. You have to find the maximum score of any valid set of words formed by using the given alphabets.
3. A word can not be used more than one time.
4. Each alphabet can be used only once.
5. It is not necessary to use all the given alphabets.

Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number N representing number of words
N space separated strings
A number M representing number of alphabets(might be repeating)
M space separated characters
26 numbers representing score of unique alphabets from a to z.
Output Format
Check the sample ouput and question video.
Constraints
1 <= N <= 14
1 <= length of word <= 15
1 <= M <= 100
1 <= Value of score <= 10
Sample Input
4
dog cat dad good
9
a b c d d d g o o
1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
Sample Output
23




 */

package practice.algorithms.backTracking;
import java.util.*;

public class MaxScore {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx == words.length)
            return 0;
        // exclude element
        int s1 = solution(words,farr,score,idx+1);
        String word = words[idx];
        int s2 = 0;
        boolean flag = true;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);

            if(farr[c-'a'] == 0){
                flag = false;
            }
            farr[c-'a']--;
            s2 += score[c-'a'];
        }
        int sword=0;
        if(flag){
            sword += s2 + solution(words,farr,score,idx+1);
        }
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            farr[c-'a']++;
        }
        return Math.max(s1,sword);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

    }
}
