package practice.algorithms.slidingwindow;

import java.util.HashMap;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {

        int max = Integer.MIN_VALUE;
        int ones = 0;
        int start=0;
        for(int end=0;end< arr.length;end++){
            if(arr[end] == 1){
                ones++;
            }
            if(end-start+1-ones > k){
                if(arr[start++] == 1)
                    ones--;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2) == 6);
        System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3) == 9);
    }
}
