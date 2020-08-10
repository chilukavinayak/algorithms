package practice.algorithms.slidingwindow;

import java.util.*;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {

        HashMap<Character,Integer> charFrequency = new HashMap<>();
        for(char c : pattern.toCharArray()){
            charFrequency.put(c, charFrequency.getOrDefault(c,0)+1);
        }

        int matched=0;
        int start=0;
        for(int end=0;end<str.length();end++){
            char rightChar = str.charAt(end);
            if(charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar)-1);
                if(charFrequency.get(rightChar) == 0){
                    matched++;
                }
            }

            if(matched == charFrequency.size())
                return true;

            if(end-start+1 >= pattern.length()){
                char leftChar = str.charAt(start++);
                if(charFrequency.containsKey(leftChar)){
                    charFrequency.put(leftChar,charFrequency.get(leftChar)+1);

                    if(charFrequency.get(leftChar) == 1)
                        matched--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(findPermutation("oidbcaf","abc") == true);
        System.out.println(findPermutation("odicf","dc") == false);
        System.out.println(findPermutation("bcdxabcdy","bcdyabcdx") == true);
        System.out.println(findPermutation("aaacb","abc") == true);
    }
}
