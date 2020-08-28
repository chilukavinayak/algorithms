package practice.algorithms.cyclicsort;

import java.util.Arrays;

public class CyclicSort {
    public static void swap(int[] arr, int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }

    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 4, 2};
        sort(nums);
        print(nums);

        nums = new int[]{2, 6, 4, 3, 1, 5};
        sort(nums);
        print(nums);

        nums = new int[]{1, 5, 6, 4, 3, 2};
        sort(nums);
        print(nums);
    }
}
