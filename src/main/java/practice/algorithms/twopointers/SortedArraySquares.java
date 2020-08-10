package practice.algorithms.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int index = arr.length-1;
        int left=0,right= arr.length-1;
        while(left<right){
            if(Math.abs(arr[left]) > Math.abs(arr[right])){
                squares[index] = arr[left]*arr[left];
                left++;
            }
            else{
                squares[index] = arr[right]*arr[right];
                right--;
            }
            index--;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(makeSquares(new int[]{-2, -1, 0, 2, 3})).boxed().collect(Collectors.toList())); //[0, 1, 4, 4, 9]
        System.out.println(Arrays.stream(makeSquares(new int[]{-3, -1, 0, 1, 2})).boxed().collect(Collectors.toList())); //[0, 1, 1, 4, 9]
    }
}
