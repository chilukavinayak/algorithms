package practice.algorithms.slidingwindow;

import java.util.*;

class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        HashMap<String,Integer> wordFrequency = new HashMap<>();


        for(String word: words)
            wordFrequency.put(word, wordFrequency.getOrDefault(word,0)+1);

        int wordCount = words.length, wordLength=words[0].length();
        for(int i=0;i<=str.length()-wordLength*wordCount;i++){
            HashMap<String,Integer> wordsSeen = new HashMap<>();
            for(int j=0;j<wordCount;j++){
                int nextWordIndex = i+j*wordLength;
                String word = str.substring(nextWordIndex,nextWordIndex+wordLength);
                if(!wordFrequency.containsKey(word))
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word,0)+1);

                if(wordsSeen.get(word) > wordFrequency.getOrDefault(word,0))
                    break;

                if(j+1 == wordCount)
                    resultIndices.add(i);
            }

        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat",new String[]{"cat","fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox",new String[]{"cat","fox"}));
    }
}
