package leetcode.java;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        head = temp;
        return head;
    }
}
