import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character,Integer> charFrequency = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            charFrequency.put(ch, charFrequency.getOrDefault(ch,0)+1);
        }

        int matched=0;
        int start=0;
        for(int end=0;end<str.length();end++){
            char rightChar = str.charAt(end);
            if(charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar)-1);
                if(charFrequency.get(rightChar) == 0)
                    matched++;
            }
            if(matched == charFrequency.size()){
                resultIndices.add(start);
            }

            if(end >= pattern.length()-1){
                char leftChar = str.charAt(start++);
                if(charFrequency.containsKey(leftChar)){
                    charFrequency.put(leftChar,charFrequency.get(leftChar)+1);
                    if(charFrequency.get(leftChar) == 1){
                        matched--;
                    }
                }
            }
        }

        return resultIndices;
    }
    public static void main(String[] args){
        System.out.println(findStringAnagrams("ppqp","pq")); //[1.2]
        System.out.println(findStringAnagrams("abbcabc","abc")); //[2,3.4]
    }
}
