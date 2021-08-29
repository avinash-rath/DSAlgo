package leetcode.java;

import java.util.Stack;

/* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null) return;
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode n = head;
        while(n!=null) { 
            st.add(n);
            n = n.next;
        }
        int len = st.size() / 2;
        n = head;
        for(int i = 1; i <= len; i++) {
            ListNode temp = n.next;
            n.next = st.pop();
            n.next.next = temp;
            n = n.next.next;
        }
        n.next = null;
    }
}
