import java.util.HashMap;

public class NoRepeatSubstring {

    public static int findLength(String str){
        int max = Integer.MIN_VALUE;
        int start = 0;
        HashMap<Character,Integer> charIndex = new HashMap<>();
        for(int end=0;end<str.length();end++){
            char rightChar = str.charAt(end);

            if(charIndex.get(rightChar) != null) {
                start = charIndex.get(rightChar) + 1;
            }
            else {
                charIndex.put(rightChar, end);
                max = Math.max(max, end-start+1);
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(findLength("aabccbb") == 3);
        System.out.println(findLength("abbbb") == 2);
        System.out.println(findLength("abccde") == 3);
    }
}
