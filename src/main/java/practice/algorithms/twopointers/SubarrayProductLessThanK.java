package practice.algorithms.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int start=0;
        int product=1;
        for(int end=0;end<arr.length;end++){
            product *= arr[end];
            while(product >= target){
                product /= arr[start++];
            }
            List<Integer> list = new LinkedList<>();
            for(int i=end;i>=start;i--){
                list.add(0,arr[i]);
                subarrays.add(new ArrayList<>(list));
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}