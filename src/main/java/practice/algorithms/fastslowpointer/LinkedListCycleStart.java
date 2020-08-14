package practice.algorithms.fastslowpointer;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycleStart {
    public static int findCycleLength(ListNode node){
        int length=0;
        ListNode temp = node;
        do{
            temp = temp.next;
            length++;
        }while(temp != node);
        return length;
    }
    public static ListNode findCycleStart(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        int length=0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                length = findCycleLength(slow);
                break;
            }

        }

        if(fast == null)
            return null;

        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while(length > 0){
            pointer2 = pointer2.next;
            length--;
        }

        while(pointer2 != pointer1){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    public static ListNode findCycleStart1(ListNode head) {
        ListNode temp = head;
        int length= LinkedListCycleLength.findCycleLength(temp);

        HashSet<ListNode> set = new HashSet<>();
        temp = head;
        while(temp != null){
            if(set.contains(temp))
                break;

            set.add(temp);
            temp= temp.next;
        }

        temp= head;
        int tni = set.size()- length;
        while(tni > 0){
            temp = temp.next;
            tni--;
        }

        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}