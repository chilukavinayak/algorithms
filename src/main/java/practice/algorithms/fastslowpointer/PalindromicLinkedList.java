package practice.algorithms.fastslowpointer;
import java.util.Stack;

public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sencondHalf = reverse(slow);
        ListNode copySecondHalf = sencondHalf;
        while (head != null && sencondHalf != null ){
            if(head.value != sencondHalf.value)
               break;
            head = head.next;
            sencondHalf = sencondHalf.next;
        }

        reverse(copySecondHalf);
        if(head == null && sencondHalf == null)
            return true;


        return false;
    }

    private static ListNode reverse(ListNode node) {
        ListNode head = node, previous=null, next=null;
        while(head != null){
            next = head.next;
            head.next = previous;
            previous= head;
            head = next;
        }
        return previous;
    }
// my approach
    public static boolean isPalindrom1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = slow.next;

        while(temp != null){
            stack.push(temp);
            temp = temp.next;

        }
        ListNode node = head;
        while(node != slow){
            if(node.value != stack.pop().value )
                return false;
            node=node.next;
        }


        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }


}