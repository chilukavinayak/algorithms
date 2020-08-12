package practice.algorithms.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DutchFlag {
    public static int[] sort(int[] arr) {

        int low=0,high=arr.length-1;
        int i=0;
        while(i<high){
            if(arr[i] == 0){
                swap(arr,low,i);
                low++;
                i++;
            }
            else if(arr[i] == 1){
                i++;
            }
            else{
                swap(arr,i,high);
                high--;
            }
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(sort(new int[]{1, 0, 2, 1, 0})).boxed().collect(Collectors.toList()));
        System.out.println(sort(new int[]{2, 2, 0, 1, 2, 0}));
    }
}
