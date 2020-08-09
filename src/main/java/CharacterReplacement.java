import java.util.HashMap;

public class CharacterReplacement {

    public static int findLength(String str, int k) {
       int max = Integer.MIN_VALUE;
       HashMap<Character,Integer> charFrequency = new HashMap<>();
       int maxReapeatedCharacter =0;
       int start=0;
       for(int end=0;end<str.length();end++){
           char rightChar = str.charAt(end);
           charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar,0)+1);
           maxReapeatedCharacter = Math.max(maxReapeatedCharacter, charFrequency.get(rightChar));
           if(end-start+1-maxReapeatedCharacter > k){
                char leftChar = str.charAt(start++);
                charFrequency.put(leftChar,charFrequency.get(leftChar)-1);
           }
           max = Math.max(max, end-start+1);
       }

       return max;
    }

    public static void main(String[] args){
        System.out.println(findLength("aabccbb",2) == 5);
        System.out.println(findLength("abbcb",1) == 4);
        System.out.println(findLength("abccde",1) == 3);
        System.out.println(findLength("babab",2));
    }

}
