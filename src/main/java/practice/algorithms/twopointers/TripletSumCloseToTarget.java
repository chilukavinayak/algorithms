package practice.algorithms.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2},2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2},1) );
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1},100));
    }

    private static int searchTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-2;i++){
            int left = i+1, right=arr.length-1;
            int tripletSum = arr[i]+arr[left]+arr[right];
            if(tripletSum == target)
                return tripletSum;
            if(Math.abs(min) > Math.abs(tripletSum-target))
                min = Math.abs(tripletSum-target);

            if(tripletSum > target)
                left--;
            else
                right++;

        }
        return target-min;
    }
}
