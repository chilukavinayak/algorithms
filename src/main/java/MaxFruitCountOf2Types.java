import java.util.HashMap;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int start =0;
        int max = Integer.MIN_VALUE;
        HashMap<Character,Integer> charCount = new HashMap<>();
        for(int end=0;end< arr.length;end++){
            char right = arr[end];
            charCount.put(right, charCount.getOrDefault(right,0)+1);
            if(charCount.size() <= 2){
                max = Math.max(max, end - start+1);
            }
            else{
                while(charCount.size() > 2){
                    char left = arr[start++];
                    charCount.put(left , charCount.get(left)-1);
                    if(charCount.get(left) == 0){
                        charCount.remove(left);
                    }
                }
            }
       }

        return max;
    }
    public static void main(String[] args){
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}) == 3);
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}) == 5);
    }
}
