package practice.algorithms.slidingwindow;

import java.util.*;

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for(char ch: pattern.toCharArray())
            charFrequency.put(ch, charFrequency.getOrDefault(ch,0)+1);

        int matched=0,start=0,min=str.length()+1,subString=0;
        for(int end=0;end<str.length();end++){
            char rightChar = str.charAt(end);
            if(charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar)-1);
                if(charFrequency.get(rightChar) >= 0){
                    matched++;
                }
                while(matched == pattern.length()){

                    if(min > end-start+1){
                        min = end-start+1;
                        subString = start;
                    }

                    char leftChar = str.charAt(start++);
                    if(charFrequency.containsKey(leftChar)){

                        if(charFrequency.get(leftChar) >= 0)
                            matched--;
                        charFrequency.put(leftChar,charFrequency.get(leftChar)+1);

                    }
                }
            }
        }

        return min > str.length()? "": str.substring(subString,subString+min);
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec","abc"));
        System.out.println(findSubstring("abdabca","abc")  );
        System.out.println(findSubstring("adcad","abc"));
    }
}
