package practice.algorithms.slidingwindow;

import java.util.HashMap;

public class LongSubStrUnique{
    static public int find(String str,int k){
        HashMap<Character,Integer> charCount = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int start = 0;
        for(int end=0;end<str.length();end++){
            char rightChar = str.charAt(end);
            charCount.put(rightChar, charCount.getOrDefault(rightChar,0)+1);
            if(charCount.size() <= k){
                max = Math.max(max, end-start+1);
            }
            else{
                while(charCount.size() > k){
                    char leftChar = str.charAt(start++);
                    charCount.put(leftChar,charCount.get(leftChar)-1);
                    if(charCount.get(leftChar)==0){
                        charCount.remove(leftChar);
                    }
                }

            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(find("araaci", 2) == 4 );
        System.out.println(find("araaci",1) == 2);
        System.out.println(find("cbbebi",3) == 5);
    }
}