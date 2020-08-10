package practice.algorithms.twopointers;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int j=1; //non duplicate
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] != arr[i])
                arr[j++] = arr[j];
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}) == 4);
        System.out.println(remove(new int[]{2, 2, 2, 11}) == 2);
    }
}
