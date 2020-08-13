package practice.algorithms.twopointers;

public class ShortestWindowSort {
    public static int sort(int[] arr) {

        int left=0;
        while(left < arr.length) {
            if (left > 0 && arr[left] < arr[left - 1])
                break;
            left++;
        }
        
        if(left == arr.length)
            return 0;

        int right=arr.length-1;
        while(right >= 0) {
            if (right < arr.length - 1 && arr[right + 1] < arr[right])
                break;
            right--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        while(left > 0 && min < arr[left-1])
            left--;

        while(right < arr.length-1 && max > arr[right+1])
            right++;


        return right-left+1;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(sort(new int[]{1, 2, 3}));
        System.out.println(sort(new int[]{3, 2, 1}));

    }
}
