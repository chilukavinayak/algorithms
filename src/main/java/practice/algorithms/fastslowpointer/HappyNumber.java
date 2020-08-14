package practice.algorithms.fastslowpointer;

public class HappyNumber {

    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        while(fast > 1)
        {
            fast = squareOfDigits(squareOfDigits(fast));
            slow = squareOfDigits(slow);

            if(slow == fast)
                return false;
        }
        return true;
    }

    private static int squareOfDigits(int num) {
        int result = 0;
        while(num > 0){
            int digit = num%10;
            result += digit*digit;
            num /=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
        System.out.println(HappyNumber.find(20));
        System.out.println(HappyNumber.find(19));
    }
}