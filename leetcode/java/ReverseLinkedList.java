package leetcode.java;

public class ReverseLinkedList {
    public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next;
        ListNode rest = reverseListRecursive(head.next);
        tail.next = head;
        head.next = null;
        return rest;
    }


    // iterative method of doing it.
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev, cur, next;
        prev = null;
        cur = head;
        next = cur.next;
        while(next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }
}
