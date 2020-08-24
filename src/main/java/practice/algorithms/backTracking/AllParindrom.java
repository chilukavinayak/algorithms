package practice.algorithms.backTracking;

import java.util.Scanner;

/*
        1. You are given a string of length n.
        2. You have to partition the given string in such a way that every partition is a palindrome.

        Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't force you but intends you to teach a concept.
        Input Format
        A String of length n
        Output Format
        Check the sample ouput and question video.
        Constraints
        1 <= length of string <= 15
        Sample Input
        pep
        Sample Output
        (p) (e) (p)
        (pep)

*/
public class AllParindrom {

    public static void solution(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i=0;i<str.length();i++){
            String prefix = str.substring(0,i+1);
            String ros = str.substring(i+1);
            if(isParlindrome(prefix)){
                solution(ros,asf+"("+prefix+") ");
            }
        }

    }

    private static boolean isParlindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left)  != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }

}
