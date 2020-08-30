/*
Question
1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.

Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't
               force you but intends you to teach a concept.
Input Format
A string containing only opening and closing parenthesis
Output Format
Print all the Valid expressions.
Check the sample ouput and question video.
Constraints
1 <= length of string <= 20
Sample Input
()())()
Sample Output
(())()
()()()

 */


package practice.algorithms.backTracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemovalInvalidBracket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int mra = minRemoval(str);
        solution(str,mra,new HashSet<String>());

    }

    private static void solution(String str, int mra, HashSet<String> set) {
        if(mra == 0){
            int mrNow = minRemoval(str);
            if(mrNow == 0){
                if(!set.contains(str)){
                    set.add(str);
                    System.out.println(str);
                }
            }
            return;
        }

        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            solution(left+right,mra-1,set);
        }
    }

    private static int minRemoval(String str) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                if(stack.size() == 0){
                    stack.push(ch);
                }
                else if(stack.peek() == ')'){
                    stack.push(ch);
                }
                else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
