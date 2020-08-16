package practice.algorithms.fastslowpointer;

import java.util.List;



public class RearrangeList {

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void reorder(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        print(secondHalf);
        print(firstHalf);
        while(firstHalf != null && secondHalf != null){
            ListNode intermediateNode = secondHalf;
            secondHalf = secondHalf.next;

            intermediateNode.next = firstHalf.next;
            firstHalf.next = intermediateNode;
            firstHalf = intermediateNode.next;
        }
        if (firstHalf != null)
            firstHalf.next = null;

    }
    public static ListNode reverse(ListNode node){
        ListNode current = node, previous = null, next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
           head = head.next;
      }
    }
}