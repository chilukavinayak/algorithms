package practice.algorithms.twopointers;

import java.lang.reflect.Array;
import java.util.*;

public class TripletWithSmallerSum {


    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<arr.length-2;i++){
            int left=i+1,right=arr.length-1;
            while(left<right){
                int tripletSum = arr[i]+arr[left]+arr[right];
                if(tripletSum < target){
                    count += right-left;
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3},3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3},5));
    }
}