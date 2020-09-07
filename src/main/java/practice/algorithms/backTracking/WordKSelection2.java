package practice.algorithms.backTracking;

import java.util.HashSet;
import java.util.Scanner;

public class WordKSelection2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();

        String ustr = "";
        HashSet<Character> charSet = new HashSet<>();
        for(char c : str.toCharArray()){
            if(!charSet.contains(c)){
                charSet.add(c);
                ustr += c;
            }
        }

        wordSelection(ustr,1,k,-1,"");
    }

    private static void wordSelection(String ustr, int cs, int ts, int lcl, String asf) {
        if(cs > ts){
            System.out.println(asf);
            return;
        }
        for(int i=lcl+1;i<ustr.length();i++){
            char c = ustr.charAt(i);
            wordSelection(ustr,cs+1,ts,i,asf+c);
        }
    }


}
