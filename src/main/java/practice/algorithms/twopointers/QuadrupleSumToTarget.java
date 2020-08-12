package practice.algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        for(int i=0;i<arr.length-3;i++){
            if(i>0 && arr[i] == arr[i-1])
                continue;
            for(int j=i+1;j<arr.length-2;j++){
                if(j > i+1 && arr[j] == arr[j-1])
                    continue;
                searchPair(arr, target,i,j, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPair(int[] arr, int target,int first,int second, List<List<Integer>> quadruplets) {
        int low = second+1;
        int high = arr.length-1;
        while(low < high){
            int sum = arr[low]+arr[high]+arr[first]+arr[second];
            if(sum == target){
                List<Integer> list = Arrays.asList(arr[first],arr[second],arr[low],arr[high]);
                quadruplets.add(list);
                low++;
                high--;
                while(low < high && arr[low] == arr[low-1])
                    low++;
                while(low < high && arr[high] == arr[high+1])
                    high--;
            }
            else if(sum > target )
                high--;
            else
                low++;

        }

    }
    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
