package practice.algorithms.twopointers;

import java.util.*;

public class TripletSumToZero {

    private static void findTargetPair(int[] arry, int left, int target, List<List<Integer>> result){
        int right = arry.length-1;
        while(left < right){
            int sum = arry[left]+arry[right];
            if(sum == target){
                result.add(Arrays.asList(-target, arry[left],arry[right]));
                right--;
                left++;
                while (left < right  && arry[right] == arry[right+1]) {
                    right--;
                }
                while(left < right && arry[left] == arry[left-1]){
                    left++;
                }

            }
            else if (sum > target) {
                right--;
            }
            else{
                left++;
            }
        }
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            if(i>0 && arr[i-1] == arr[i])
                continue;
            findTargetPair(arr,i+1,-arr[i],triplets);
        }
        return triplets;
    }

    private static void print(List<List<Integer>> result){
        System.out.println(result);
    }

    public static void main(String[] args) {
        print(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2})); //  [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        print(searchTriplets(new int[]{-5, 2, -1, -2, 3})); // [[-5, 2, 3], [-2, -1, 3]]
    }

}