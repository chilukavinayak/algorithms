package practice.algorithms.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {

        int left=0;
        int right=arr.length-1;
        while(left < right){
            int sum = arr[left]+arr[right];
            if(sum == targetSum)
                return new int[]{left,right};
            if(sum > targetSum)
                right--;
            else
                left++;
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(search(new int[]{1, 2, 3, 4, 6},6)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(search(new int[]{2, 5, 9, 11},11)).boxed().collect(Collectors.toList()));

    }
}