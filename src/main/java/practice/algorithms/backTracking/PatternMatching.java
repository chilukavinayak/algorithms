package practice.algorithms.backTracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
 Question
 1. You are given a string and a pattern.
 2. You've to check if the string is of the same structure as pattern without using any regular
 expressions.

 Note -> Check out the question video and write the recursive code as it is intended without
 changing signature. The judge can't force you but intends you to teach a concept.
 Input Format
 A String str
 A pattern ptr
 Output Format
 Check the sample ouput and question video.
 Constraints
 1 <= length of str,ptr <= 20
 Sample Input
 graphtreesgraph
 pep
 Sample Output
 p -> graph, e -> trees, .

 */

public class PatternMatching {
    public static void solution(String str, String pattern, HashMap<Character,String> map,String op){
        if(pattern.length() == 0){
            if(str.length() == 0) {
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char c = op.charAt(i);
                    if (!alreadyPrinted.contains(c)) {
                        System.out.print(c + "-> " + map.get(c) + ", ");
                        alreadyPrinted.add(c);
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);

        if(map.containsKey(ch)){
            String previous = map.get(ch);

            if(str.length() >= previous.length()){
                String left = str.substring(0,previous.length());
                String right = str.substring(previous.length());
                if(previous.equals(left))
                   solution(right,rop,map,op);
            }

        }else{
            for(int i=0;i<str.length();i++){
                String left = str.substring(0,i+1);
                String right = str.substring(i+1);
                map.put(ch,left);
                solution(right,rop,map,op);
                map.remove(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String pattern = sc.next();
        HashMap<Character,String> map = new HashMap<>();
        solution(str,pattern,map,pattern);

    }
}
